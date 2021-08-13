/*
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package org.openapitools.client;

import io.swagger.v3.oas.models.Operation;

public class ApiOperation {
    private final String path;
    private final String method;
    private final Operation operation;

    public ApiOperation(String path, String method, Operation operation) {
        this.path = path;
        this.method = method;
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }
}
