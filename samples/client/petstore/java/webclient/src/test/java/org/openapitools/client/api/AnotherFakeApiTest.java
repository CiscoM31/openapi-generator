/*
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints,
 * models. Please do not use this for any other purpose. Special characters: \"
 * \\
 *
 * OpenAPI spec version: 1.0.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator
 * (https://openapi-generator.tech). https://openapi-generator.tech Do not edit
 * the class manually.
 */

package org.openapitools.client.api;

import org.openapitools.client.model.Client;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for AnotherFakeApi
 */
@Ignore
public class AnotherFakeApiTest {

  private final AnotherFakeApi api = new AnotherFakeApi();

  /**
   * To test special tags
   *
   * To test special tags and operation ID starting with number
   */
  @Test
  public void call123testSpecialTagsTest() {
    Client client = null;
    Client response = api.call123testSpecialTags(client).block();

    // TODO: test validations
  }
}
