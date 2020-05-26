# coding: utf-8

# flake8: noqa

"""
Run the tests.
$ pip install nose (optional)
$ cd OpenAPIPetstore-python
$ nosetests -v
"""
from collections import namedtuple
import json
import os
import time
import unittest
import datetime

import petstore_api
from petstore_api.models import (
    shape,
    equilateral_triangle,
    animal,
    dog,
    apple,
    mammal,
    whale,
    zebra,
    banana,
    fruit_req,
)


MockResponse = namedtuple('MockResponse', 'data')


class DeserializationTests(unittest.TestCase):

    def setUp(self):
        self.api_client = petstore_api.ApiClient()
        self.deserialize = self.api_client.deserialize

    def test_deserialize_shape(self):
        """

        deserialize Shape to an instance of:
        - EquilateralTriangle
        - IsoscelesTriangle
        - IsoscelesTriangle
        - ScaleneTriangle
        - ComplexQuadrilateral
        - SimpleQuadrilateral
        by traveling through 2 discriminators
        """
        shape_type, triangle_type  = ['Triangle', 'EquilateralTriangle']
        data = {
            'shapeType': shape_type,
            'triangleType': triangle_type,
        }
        response = MockResponse(data=json.dumps(data))

        deserialized = self.deserialize(response, (shape.Shape,), True)
        self.assertTrue(isinstance(deserialized, equilateral_triangle.EquilateralTriangle))
        self.assertEqual(deserialized.shape_type, shape_type)
        self.assertEqual(deserialized.triangle_type, triangle_type)

        # invalid second discriminator value
        shape_type, quadrilateral_type  = ['Quadrilateral', 'Triangle']
        data = {
            'shapeType': shape_type,
            'quadrilateralType': quadrilateral_type,
        }
        response = MockResponse(data=json.dumps(data))

        err_msg = ("Cannot deserialize input data due to invalid discriminator "
            "value. The OpenAPI document has no mapping for discriminator "
            "property '{}'='{}' at path: ()"
        )
        with self.assertRaisesRegexp(
            petstore_api.ApiValueError,
            err_msg.format("quadrilateralType", "Triangle")
        ):
            self.deserialize(response, (shape.Shape,), True)

    def test_deserialize_animal(self):
        """
        deserialize Animal to a Dog instance
        Animal uses a discriminator which has a map built of child classes
        that inherrit from Animal
        This is the swagger (v2) way of doing something like oneOf composition
        """
        class_name = 'Dog'
        color = 'white'
        breed = 'Jack Russel Terrier'
        data = {
            'className': class_name,
            'color': color,
            'breed': breed
        }
        response = MockResponse(data=json.dumps(data))

        deserialized = self.deserialize(response, (animal.Animal,), True)
        self.assertTrue(isinstance(deserialized, dog.Dog))
        self.assertEqual(deserialized.class_name, class_name)
        self.assertEqual(deserialized.color, color)
        self.assertEqual(deserialized.breed, breed)

    def test_regex_constraint(self):
        """
        Test regex pattern validation.
        """

        # Test with valid regex pattern.
        inst = apple.Apple(
            cultivar="Akane"
        )
        assert isinstance(inst, apple.Apple)

        inst = apple.Apple(
            origin="cHiLe"
        )
        assert isinstance(inst, apple.Apple)

        # Test with invalid regex pattern.
        err_msg = ("Invalid value for `{}`, must match regular expression `{}`$")
        with self.assertRaisesRegexp(
            petstore_api.ApiValueError,
            err_msg.format("cultivar", "[^`]*")
        ):
            inst = apple.Apple(
                cultivar="!@#%@$#Akane"
            )

        err_msg = ("Invalid value for `{}`, must match regular expression `{}` with flags")
        with self.assertRaisesRegexp(
            petstore_api.ApiValueError,
            err_msg.format("origin", "[^`]*")
        ):
            inst = apple.Apple(
                origin="!@#%@$#Chile"
            )

    def test_deserialize_mammal(self):
        """
        deserialize mammal
        mammal is a oneOf composed schema model with discriminator
        """

        # whale test
        has_baleen = True
        has_teeth = False
        class_name = 'whale'
        data = {
            'hasBaleen': has_baleen,
            'hasTeeth': has_teeth,
            'className': class_name
        }
        response = MockResponse(data=json.dumps(data))
        deserialized = self.deserialize(response, (mammal.Mammal,), True)
        self.assertTrue(isinstance(deserialized, whale.Whale))
        self.assertEqual(deserialized.has_baleen, has_baleen)
        self.assertEqual(deserialized.has_teeth, has_teeth)
        self.assertEqual(deserialized.class_name, class_name)

        # zebra test
        zebra_type = 'plains'
        class_name = 'zebra'
        data = {
            'type': zebra_type,
            'className': class_name
        }
        response = MockResponse(data=json.dumps(data))
        deserialized = self.deserialize(response, (mammal.Mammal,), True)
        self.assertTrue(isinstance(deserialized, zebra.Zebra))
        self.assertEqual(deserialized.type, zebra_type)
        self.assertEqual(deserialized.class_name, class_name)

    def test_deserialize_float_value(self):
        """
        Deserialize floating point values.
        """
        data = {
          'lengthCm': 3.1415
        }
        response = MockResponse(data=json.dumps(data))
        deserialized = self.deserialize(response, (banana.Banana,), True)
        self.assertTrue(isinstance(deserialized, banana.Banana))
        self.assertEqual(deserialized.length_cm, 3.1415)

        # Float value is serialized without decimal point
        data = {
          'lengthCm': 3
        }
        response = MockResponse(data=json.dumps(data))
        deserialized = self.deserialize(response, (banana.Banana,), True)
        self.assertTrue(isinstance(deserialized, banana.Banana))
        self.assertEqual(deserialized.length_cm, 3.0)

    def test_deserialize_fruit_null_value(self):
        """
        deserialize fruit with null value.
        fruitReq is a oneOf composed schema model with discriminator, including 'null' type.
        """

        # Unmarshal 'null' value
        data = None
        response = MockResponse(data=json.dumps(data))
        deserialized = self.deserialize(response, (fruit_req.FruitReq, type(None)), True)
        self.assertEqual(type(deserialized), type(None))

        inst = fruit_req.FruitReq(None)
        self.assertIsNone(inst)
