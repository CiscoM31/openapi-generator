/**
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
package org.openapitools.client.models


import kotlinx.serialization.*
import kotlinx.serialization.internal.CommonEnumSerializer
/**
 * 
 * @param requiredFile file to upload
 * @param additionalMetadata Additional data to pass to server
 */
@Serializable
data class InlineObject5 (
    /* file to upload */
    @SerialName(value = "requiredFile") @Required val requiredFile: org.openapitools.client.infrastructure.OctetByteArray,
    /* Additional data to pass to server */
    @SerialName(value = "additionalMetadata") val additionalMetadata: kotlin.String? = null
)

