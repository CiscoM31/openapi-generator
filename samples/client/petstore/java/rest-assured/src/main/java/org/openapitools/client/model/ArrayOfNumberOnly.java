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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
import org.hibernate.validator.constraints.*;

/**
 * ArrayOfNumberOnly
 */

public class ArrayOfNumberOnly {
  public static final String SERIALIZED_NAME_ARRAY_NUMBER = "ArrayNumber";
  @SerializedName(SERIALIZED_NAME_ARRAY_NUMBER)
  private List<BigDecimal> arrayNumber = null;

  public ArrayOfNumberOnly arrayNumber(List<BigDecimal> arrayNumber) {

    this.arrayNumber = arrayNumber;
    return this;
  }

  public ArrayOfNumberOnly addArrayNumberItem(BigDecimal arrayNumberItem) {
    if (this.arrayNumber == null) {
      this.arrayNumber = new ArrayList<BigDecimal>();
    }
    this.arrayNumber.add(arrayNumberItem);
    return this;
  }

  /**
   * Get arrayNumber
   * @return arrayNumber
   **/
  @javax.annotation.Nullable
  @Valid
  @ApiModelProperty(value = "")

  public List<BigDecimal> getArrayNumber() {
    return arrayNumber;
  }

  public void setArrayNumber(List<BigDecimal> arrayNumber) {
    this.arrayNumber = arrayNumber;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArrayOfNumberOnly arrayOfNumberOnly = (ArrayOfNumberOnly)o;
    return Objects.equals(this.arrayNumber, arrayOfNumberOnly.arrayNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(arrayNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArrayOfNumberOnly {\n");
    sb.append("    arrayNumber: ")
        .append(toIndentedString(arrayNumber))
        .append("\n");
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
