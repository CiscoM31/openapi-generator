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

import org.openapitools.client.model.User;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for UserApi
 */
@Ignore
public class UserApiTest {

  private final UserApi api = new UserApi();

  /**
   * Create user
   *
   * This can only be done by the logged in user.
   */
  @Test
  public void createUserTest() {
    User user = null;
    api.createUser(user).block();

    // TODO: test validations
  }

  /**
   * Creates list of users with given input array
   *
   *
   */
  @Test
  public void createUsersWithArrayInputTest() {
    List<User> user = null;
    api.createUsersWithArrayInput(user).block();

    // TODO: test validations
  }

  /**
   * Creates list of users with given input array
   *
   *
   */
  @Test
  public void createUsersWithListInputTest() {
    List<User> user = null;
    api.createUsersWithListInput(user).block();

    // TODO: test validations
  }

  /**
   * Delete user
   *
   * This can only be done by the logged in user.
   */
  @Test
  public void deleteUserTest() {
    String username = null;
    api.deleteUser(username).block();

    // TODO: test validations
  }

  /**
   * Get user by user name
   *
   *
   */
  @Test
  public void getUserByNameTest() {
    String username = null;
    User response = api.getUserByName(username).block();

    // TODO: test validations
  }

  /**
   * Logs user into the system
   *
   *
   */
  @Test
  public void loginUserTest() {
    String username = null;
    String password = null;
    String response = api.loginUser(username, password).block();

    // TODO: test validations
  }

  /**
   * Logs out current logged in user session
   *
   *
   */
  @Test
  public void logoutUserTest() {
    api.logoutUser().block();

    // TODO: test validations
  }

  /**
   * Updated user
   *
   * This can only be done by the logged in user.
   */
  @Test
  public void updateUserTest() {
    String username = null;
    User user = null;
    api.updateUser(username, user).block();

    // TODO: test validations
  }
}
