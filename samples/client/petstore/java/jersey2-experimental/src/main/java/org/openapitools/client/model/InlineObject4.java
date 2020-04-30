/*
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints,
 * models. Please do not use this for any other purpose. Special characters: \"
 * \\
 *
 * The version of the OpenAPI document: 1.0.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator
 * (https://openapi-generator.tech). https://openapi-generator.tech Do not edit
 * the class manually.
 */

package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * InlineObject4
 */
@JsonPropertyOrder(
    {InlineObject4.JSON_PROPERTY_PARAM, InlineObject4.JSON_PROPERTY_PARAM2})

public class InlineObject4 {
  public static final String JSON_PROPERTY_PARAM = "param";
  private String param;

  public static final String JSON_PROPERTY_PARAM2 = "param2";
  private String param2;

  public InlineObject4 param(String param) {

    this.param = param;
    return this;
  }

  /**
   * field1
   * @return param
   **/
  @ApiModelProperty(required = true, value = "field1")
  @JsonProperty(JSON_PROPERTY_PARAM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getParam() {
    return param;
  }

  public void setParam(String param) { this.param = param; }

  public InlineObject4 param2(String param2) {

    this.param2 = param2;
    return this;
  }

  /**
   * field2
   * @return param2
   **/
  @ApiModelProperty(required = true, value = "field2")
  @JsonProperty(JSON_PROPERTY_PARAM2)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getParam2() {
    return param2;
  }

  public void setParam2(String param2) { this.param2 = param2; }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineObject4 inlineObject4 = (InlineObject4)o;
    return Objects.equals(this.param, inlineObject4.param) &&
        Objects.equals(this.param2, inlineObject4.param2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(param, param2);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineObject4 {\n");
    sb.append("    param: ").append(toIndentedString(param)).append("\n");
    sb.append("    param2: ").append(toIndentedString(param2)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
