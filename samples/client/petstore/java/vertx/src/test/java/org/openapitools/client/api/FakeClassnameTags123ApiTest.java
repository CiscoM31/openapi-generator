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

import org.openapitools.client.Configuration;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.runner.RunWith;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.core.Vertx;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.ext.unit.junit.RunTestOnContext;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.Async;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for FakeClassnameTags123Api
 */
@RunWith(VertxUnitRunner.class)
@Ignore
public class FakeClassnameTags123ApiTest {

  private FakeClassnameTags123Api api;

  @Rule public RunTestOnContext rule = new RunTestOnContext();

  @BeforeClass
  public void setupApiClient() {
    JsonObject config = new JsonObject();
    Vertx vertx = rule.vertx();
    Configuration.setupDefaultApiClient(vertx, config);

    api = new FakeClassnameTags123ApiImpl();
  }

  /**
   * To test class name in snake case
   * To test class name in snake case
   *
   * @param context Vertx test context for doing assertions
   */
  @Test
  public void testClassnameTest(TestContext context) {
    Async async = context.async();
    Client client = null;
    api.testClassname(client, result -> {
      // TODO: test validations
      async.complete();
    });
  }
}