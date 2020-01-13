# coding: utf-8

"""
    OpenAPI Petstore

    This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\  # noqa: E501

    The version of the OpenAPI document: 1.0.0
    Generated by: https://openapi-generator.tech
"""


from __future__ import absolute_import
import re  # noqa: F401
import sys  # noqa: F401

import six  # noqa: F401

from petstore_api.model_utils import (  # noqa: F401
    ModelComposed,
    ModelNormal,
    ModelSimple,
    date,
    datetime,
    file_type,
    int,
    none_type,
    str,
    validate_get_composed_info,
)


class AdditionalPropertiesClass(ModelNormal):
    """NOTE: This class is auto generated by OpenAPI Generator.
    Ref: https://openapi-generator.tech

    Do not edit the class manually.

    Attributes:
      allowed_values (dict): The key is the tuple path to the attribute
          and the for var_name this is (var_name,). The value is a dict
          with a capitalized key describing the allowed value and an allowed
          value. These dicts store the allowed enum values.
      attribute_map (dict): The key is attribute name
          and the value is json key in definition.
      discriminator_value_class_map (dict): A dict to go from the discriminator
          variable value to the discriminator class name.
      openapi_types (dict): The key is attribute name
          and the value is attribute type.
      validations (dict): The key is the tuple path to the attribute
          and the for var_name this is (var_name,). The value is a dict
          that stores validations for max_length, min_length, max_items,
          min_items, exclusive_maximum, inclusive_maximum, exclusive_minimum,
          inclusive_minimum, and regex.
      additional_properties_type (tuple): A tuple of classes accepted
          as additional properties values.
    """

    allowed_values = {
    }

    openapi_types = {
        'map_string': ({str: (str,)},),  # noqa: E501
        'map_number': ({str: (float,)},),  # noqa: E501
        'map_integer': ({str: (int,)},),  # noqa: E501
        'map_boolean': ({str: (bool,)},),  # noqa: E501
        'map_array_integer': ({str: ([int],)},),  # noqa: E501
        'map_array_anytype': ({str: ([bool, date, datetime, dict, float, int, list, str],)},),  # noqa: E501
        'map_map_string': ({str: ({str: (str,)},)},),  # noqa: E501
        'map_map_anytype': ({str: ({str: (bool, date, datetime, dict, float, int, list, str,)},)},),  # noqa: E501
        'anytype_1': (bool, date, datetime, dict, float, int, list, str,),  # noqa: E501
        'anytype_2': (bool, date, datetime, dict, float, int, list, str,),  # noqa: E501
        'anytype_3': (bool, date, datetime, dict, float, int, list, str,),  # noqa: E501
    }

    validations = {
    }

    additional_properties_type = None

    @staticmethod
    def discriminator():
        return None

    attribute_map = {
        'map_string': 'map_string',  # noqa: E501
        'map_number': 'map_number',  # noqa: E501
        'map_integer': 'map_integer',  # noqa: E501
        'map_boolean': 'map_boolean',  # noqa: E501
        'map_array_integer': 'map_array_integer',  # noqa: E501
        'map_array_anytype': 'map_array_anytype',  # noqa: E501
        'map_map_string': 'map_map_string',  # noqa: E501
        'map_map_anytype': 'map_map_anytype',  # noqa: E501
        'anytype_1': 'anytype_1',  # noqa: E501
        'anytype_2': 'anytype_2',  # noqa: E501
        'anytype_3': 'anytype_3',  # noqa: E501
    }

    @staticmethod
    def _composed_schemas():
        return None

    required_properties = set([
        '_data_store',
        '_check_type',
        '_from_server',
        '_path_to_item',
        '_configuration',
    ])

    def __init__(self, _check_type=True, _from_server=False, _path_to_item=(), _configuration=None, **kwargs):  # noqa: E501
        """additional_properties_class.AdditionalPropertiesClass - a model defined in OpenAPI


        Keyword Args:
            _check_type (bool): if True, values for parameters in openapi_types
                                will be type checked and a TypeError will be
                                raised if the wrong type is input.
                                Defaults to True
            _path_to_item (tuple/list): This is a list of keys or values to
                                drill down to the model in received_data
                                when deserializing a response
            _from_server (bool): True if the data is from the server
                                False if the data is from the client (default)
            _configuration (Configuration): the instance to use when
                                deserializing a file_type parameter.
                                If passed, type conversion is attempted
                                If omitted no type conversion is done.
            map_string ({str: (str,)}): [optional]  # noqa: E501
            map_number ({str: (float,)}): [optional]  # noqa: E501
            map_integer ({str: (int,)}): [optional]  # noqa: E501
            map_boolean ({str: (bool,)}): [optional]  # noqa: E501
            map_array_integer ({str: ([int],)}): [optional]  # noqa: E501
            map_array_anytype ({str: ([bool, date, datetime, dict, float, int, list, str],)}): [optional]  # noqa: E501
            map_map_string ({str: ({str: (str,)},)}): [optional]  # noqa: E501
            map_map_anytype ({str: ({str: (bool, date, datetime, dict, float, int, list, str,)},)}): [optional]  # noqa: E501
            anytype_1 (bool, date, datetime, dict, float, int, list, str): [optional]  # noqa: E501
            anytype_2 (bool, date, datetime, dict, float, int, list, str): [optional]  # noqa: E501
            anytype_3 (bool, date, datetime, dict, float, int, list, str): [optional]  # noqa: E501
        """

        self._data_store = {}
        self._check_type = _check_type
        self._from_server = _from_server
        self._path_to_item = _path_to_item
        self._configuration = _configuration

        for var_name, var_value in six.iteritems(kwargs):
            setattr(self, var_name, var_value)
