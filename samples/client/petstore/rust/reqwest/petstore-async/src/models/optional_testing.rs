/*
 * OpenAPI Petstore
 *
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 * Generated by: https://openapi-generator.tech
 */

/// OptionalTesting : Test handling of optional and nullable fields



#[derive(Clone, Debug, PartialEq, Serialize, Deserialize)]
pub struct OptionalTesting {
    #[serde(rename = "optional_nonnull", skip_serializing_if = "Option::is_none")]
    pub optional_nonnull: Option<String>,
    #[serde(rename = "required_nonnull")]
    pub required_nonnull: String,
    #[serde(rename = "optional_nullable", default, with = "::serde_with::rust::double_option", skip_serializing_if = "Option::is_none")]
    pub optional_nullable: Option<Option<String>>,
    #[serde(rename = "required_nullable", deserialize_with = "Option::deserialize")]
    pub required_nullable: Option<String>,
}

impl OptionalTesting {
    /// Test handling of optional and nullable fields
    pub fn new(required_nonnull: String, required_nullable: Option<String>) -> OptionalTesting {
        OptionalTesting {
            optional_nonnull: None,
            required_nonnull,
            optional_nullable: None,
            required_nullable,
        }
    }
}


