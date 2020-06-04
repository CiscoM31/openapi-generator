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


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.client.model.ComplexQuadrilateral;
import org.openapitools.client.model.SimpleQuadrilateral;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.openapitools.client.JSON;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;


@JsonDeserialize(using=Quadrilateral.QuadrilateralDeserializer.class)
public class Quadrilateral extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(Quadrilateral.class.getName());

    public static class QuadrilateralDeserializer extends StdDeserializer<Quadrilateral> {
        public QuadrilateralDeserializer() {
            this(Quadrilateral.class);
        }

        public QuadrilateralDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Quadrilateral deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            int match = 0;
            Object deserialized = null;
            Class cls = JSON.getClassForElement(tree, Quadrilateral.class);
            if (cls != null) {
                // When the OAS schema includes a discriminator, use the discriminator value to
                // discriminate the oneOf schemas.
                // Get the discriminator mapping value to get the class.
                deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
                Quadrilateral ret = new Quadrilateral();
                ret.setActualInstance(deserialized);
                return ret;
            }
            // deserialize ComplexQuadrilateral
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(ComplexQuadrilateral.class);
                // TODO: there is no validation against JSON schema constraints
                // (min, max, enum, pattern...), this does not perform a strict JSON
                // validation, which means the 'match' count may be higher than it should be.
                match++;
                log.log(Level.FINER, "Input data matches schema 'ComplexQuadrilateral'");
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'ComplexQuadrilateral'", e);
            }

            // deserialize SimpleQuadrilateral
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(SimpleQuadrilateral.class);
                // TODO: there is no validation against JSON schema constraints
                // (min, max, enum, pattern...), this does not perform a strict JSON
                // validation, which means the 'match' count may be higher than it should be.
                match++;
                log.log(Level.FINER, "Input data matches schema 'SimpleQuadrilateral'");
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'SimpleQuadrilateral'", e);
            }

            if (match == 1) {
                Quadrilateral ret = new Quadrilateral();
                ret.setActualInstance(deserialized);
                return ret;
            }
            throw new IOException(String.format("Failed deserialization for Quadrilateral: %d classes match result, expected 1", match));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public Quadrilateral getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException("Quadrilateral cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public final static Map<String, GenericType> schemas = new HashMap<String, GenericType>();

    public Quadrilateral() {
        super("oneOf", Boolean.FALSE);
    }

    public Quadrilateral(ComplexQuadrilateral o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Quadrilateral(SimpleQuadrilateral o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("ComplexQuadrilateral", new GenericType<ComplexQuadrilateral>() {
        });
        schemas.put("SimpleQuadrilateral", new GenericType<SimpleQuadrilateral>() {
        });
        JSON.registerDescendants(Quadrilateral.class, Collections.unmodifiableMap(schemas));
        // Initialize and register the discriminator mappings.
        Map<String, Class> mappings = new HashMap<String, Class>();
        mappings.put("ComplexQuadrilateral", ComplexQuadrilateral.class);
        mappings.put("SimpleQuadrilateral", SimpleQuadrilateral.class);
        mappings.put("Quadrilateral", Quadrilateral.class);
        JSON.registerDiscriminator(Quadrilateral.class, "quadrilateralType", mappings);
    }

    @Override
    public Map<String, GenericType> getSchemas() {
        return Quadrilateral.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas.
     *
     * It could be an instance of the 'oneOf' schemas.
     * The oneOf child schemas may themselves be a composed schema (allOf, anyOf, oneOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(ComplexQuadrilateral.class, instance, new HashSet<Class>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(SimpleQuadrilateral.class, instance, new HashSet<Class>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be ComplexQuadrilateral, SimpleQuadrilateral");
    }



}

