# coding: utf-8

# flake8: noqa

"""
Run the tests.
$ pip install nose (optional)
$ cd OpenAPIetstore-python
$ nosetests -v
"""

import os
import time
import unittest
from dateutil.parser import parse
from Crypto.PublicKey import RSA, ECC

import petstore_api
import petstore_api.configuration

HOST = 'http://petstore.swagger.io/v2'


class ApiClientTests(unittest.TestCase):

    def setUp(self):
        self.api_client = petstore_api.ApiClient()

    def test_http_signature(self):
        """ Test HTTP signature authentication.
        """
        header_params = {
          'test1': 'value1',
          'test2': 'value2',
          'Content-Type': 'application/json'
        }
        query_params = {'test2': 'value2'}
        auth_settings = ['http_signature_test']

        # Generate RSA key for test purpose
        rsakey = RSA.generate(2048)
        # Generate ECDSA key for test purpose
        ecdsakey = ECC.generate(curve='p521')
        #ecdsakey = ecdsa.SigningKey.generate(curve=ecdsa.NIST256p)

        for privkey in [ rsakey, ecdsakey ]:
            config = petstore_api.Configuration()
            config.host = 'http://localhost/'
            config.key_id = 'test-key'
            config.private_key_path = None
            config.signing_scheme = 'hs2019'
            config.signed_headers = ['test1', 'Content-Type']
            config.private_key = privkey
            if isinstance(privkey, RSA.RsaKey):
                signing_algorithms = ['PKCS1-v1_5', 'PSS']
            elif isinstance(privkey, ECC.EccKey):
                signing_algorithms = ['fips-186-3', 'deterministic-rfc6979']

            for signing_algorithm in signing_algorithms:
                config.signing_algorithm = signing_algorithm

                client = petstore_api.ApiClient(config)

                # update parameters based on auth setting
                client.update_params_for_auth(header_params, query_params, auth_settings,
                    resource_path='/pet', method='POST', body='{ }')
                self.assertTrue('Digest' in header_params)
                self.assertTrue('Authorization' in header_params)
                self.assertTrue('Date' in header_params)
                self.assertTrue('Host' in header_params)
                #for hdr_key, hdr_value in header_params.items():
                #    print("HEADER: {0}={1}".format(hdr_key, hdr_value))

    def test_configuration(self):
        config = petstore_api.Configuration()
        config.host = 'http://localhost/'

        # Test api_key authentication
        config.api_key['api_key'] = '123456'
        config.api_key_prefix['api_key'] = 'PREFIX'
        config.username = 'test_username'
        config.password = 'test_password'

        header_params = {'test1': 'value1'}
        query_params = {'test2': 'value2'}
        auth_settings = ['api_key', 'unknown']

        client = petstore_api.ApiClient(config)

        # test prefix
        self.assertEqual('PREFIX', client.configuration.api_key_prefix['api_key'])

        # update parameters based on auth setting
        client.update_params_for_auth(header_params, query_params, auth_settings)

        # test api key auth
        self.assertEqual(header_params['test1'], 'value1')
        self.assertEqual(header_params['api_key'], 'PREFIX 123456')
        self.assertEqual(query_params['test2'], 'value2')

        # test basic auth
        self.assertEqual('test_username', client.configuration.username)
        self.assertEqual('test_password', client.configuration.password)

    def test_select_header_accept(self):
        accepts = ['APPLICATION/JSON', 'APPLICATION/XML']
        accept = self.api_client.select_header_accept(accepts)
        self.assertEqual(accept, 'application/json')

        accepts = ['application/json', 'application/xml']
        accept = self.api_client.select_header_accept(accepts)
        self.assertEqual(accept, 'application/json')

        accepts = ['application/xml', 'application/json']
        accept = self.api_client.select_header_accept(accepts)
        self.assertEqual(accept, 'application/json')

        accepts = ['text/plain', 'application/xml']
        accept = self.api_client.select_header_accept(accepts)
        self.assertEqual(accept, 'text/plain, application/xml')

        accepts = []
        accept = self.api_client.select_header_accept(accepts)
        self.assertEqual(accept, None)

    def test_select_header_content_type(self):
        content_types = ['APPLICATION/JSON', 'APPLICATION/XML']
        content_type = self.api_client.select_header_content_type(content_types)
        self.assertEqual(content_type, 'application/json')

        content_types = ['application/json', 'application/xml']
        content_type = self.api_client.select_header_content_type(content_types)
        self.assertEqual(content_type, 'application/json')

        content_types = ['application/xml', 'application/json']
        content_type = self.api_client.select_header_content_type(content_types)
        self.assertEqual(content_type, 'application/json')

        content_types = ['text/plain', 'application/xml']
        content_type = self.api_client.select_header_content_type(content_types)
        self.assertEqual(content_type, 'text/plain')

        content_types = []
        content_type = self.api_client.select_header_content_type(content_types)
        self.assertEqual(content_type, 'application/json')

    def test_sanitize_for_serialization(self):
        # None
        data = None
        result = self.api_client.sanitize_for_serialization(None)
        self.assertEqual(result, data)

        # str
        data = "test string"
        result = self.api_client.sanitize_for_serialization(data)
        self.assertEqual(result, data)

        # int
        data = 1
        result = self.api_client.sanitize_for_serialization(data)
        self.assertEqual(result, data)

        # bool
        data = True
        result = self.api_client.sanitize_for_serialization(data)
        self.assertEqual(result, data)

        # date
        data = parse("1997-07-16").date()    # date
        result = self.api_client.sanitize_for_serialization(data)
        self.assertEqual(result, "1997-07-16")

        # datetime
        data = parse("1997-07-16T19:20:30.45+01:00")    # datetime
        result = self.api_client.sanitize_for_serialization(data)
        self.assertEqual(result, "1997-07-16T19:20:30.450000+01:00")

        # list
        data = [1]
        result = self.api_client.sanitize_for_serialization(data)
        self.assertEqual(result, data)

        # dict
        data = {"test key": "test value"}
        result = self.api_client.sanitize_for_serialization(data)
        self.assertEqual(result, data)

        # model
        pet_dict = {"id": 1, "name": "monkey",
                    "category": {"id": 1, "name": "test category"},
                    "tags": [{"id": 1, "name": "test tag1"},
                             {"id": 2, "name": "test tag2"}],
                    "status": "available",
                    "photoUrls": ["http://foo.bar.com/3",
                                  "http://foo.bar.com/4"]}
        pet = petstore_api.Pet(name=pet_dict["name"], photo_urls=pet_dict["photoUrls"])
        pet.id = pet_dict["id"]
        cate = petstore_api.Category()
        cate.id = pet_dict["category"]["id"]
        cate.name = pet_dict["category"]["name"]
        pet.category = cate
        tag1 = petstore_api.Tag()
        tag1.id = pet_dict["tags"][0]["id"]
        tag1.name = pet_dict["tags"][0]["name"]
        tag2 = petstore_api.Tag()
        tag2.id = pet_dict["tags"][1]["id"]
        tag2.name = pet_dict["tags"][1]["name"]
        pet.tags = [tag1, tag2]
        pet.status = pet_dict["status"]

        data = pet
        result = self.api_client.sanitize_for_serialization(data)
        self.assertEqual(result, pet_dict)

        # list of models
        list_of_pet_dict = [pet_dict]
        data = [pet]
        result = self.api_client.sanitize_for_serialization(data)
        self.assertEqual(result, list_of_pet_dict)

        # model with additional proerties
        model_dict = {'some_key': True}
        model = petstore_api.StringBooleanMap(**model_dict)
        result = self.api_client.sanitize_for_serialization(model)
        self.assertEqual(result, model_dict)
