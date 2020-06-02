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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.client.model.EquilateralTriangle;
import org.openapitools.client.model.IsoscelesTriangle;
import org.openapitools.client.model.ScaleneTriangle;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.openapitools.client.JSON;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;


@JsonDeserialize(using=Triangle.TriangleDeserializer.class)
public class Triangle extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(Triangle.class.getName());

    public static class TriangleDeserializer extends StdDeserializer<Triangle> {
        public TriangleDeserializer() {
            this(Triangle.class);
        }

        public TriangleDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Triangle deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            int match = 0;
            Object deserialized = null;
            Class cls = JSON.getClassForElement(tree, Triangle.class);
            if (cls != null) {
                // When the OAS schema includes a discriminator, use the discriminator value to
                // discriminate the oneOf schemas.
                // Get the discriminator mapping value to get the class.
                deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
                Triangle ret = new Triangle();
                ret.setActualInstance(deserialized);
                return ret;
            }
            // deserialize EquilateralTriangle
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(EquilateralTriangle.class);
                // TODO: there is no validation against JSON schema constraints
                // (min, max, enum, pattern...), this does not perform a strict JSON
                // validation, which means the 'match' count may be higher than it should be.
                match++;
                log.log(Level.FINER, "Input data matches schema 'EquilateralTriangle'");
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'EquilateralTriangle'", e);
            }

            // deserialize IsoscelesTriangle
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(IsoscelesTriangle.class);
                // TODO: there is no validation against JSON schema constraints
                // (min, max, enum, pattern...), this does not perform a strict JSON
                // validation, which means the 'match' count may be higher than it should be.
                match++;
                log.log(Level.FINER, "Input data matches schema 'IsoscelesTriangle'");
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'IsoscelesTriangle'", e);
            }

            // deserialize ScaleneTriangle
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(ScaleneTriangle.class);
                // TODO: there is no validation against JSON schema constraints
                // (min, max, enum, pattern...), this does not perform a strict JSON
                // validation, which means the 'match' count may be higher than it should be.
                match++;
                log.log(Level.FINER, "Input data matches schema 'ScaleneTriangle'");
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'ScaleneTriangle'", e);
            }

            if (match == 1) {
                Triangle ret = new Triangle();
                ret.setActualInstance(deserialized);
                return ret;
            }
            throw new IOException(String.format("Failed deserialization for Triangle: %d classes match result, expected 1", match));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public Triangle getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException("Triangle cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public final static Map<String, GenericType> schemas = new HashMap<String, GenericType>();

    public Triangle() {
        super("oneOf", Boolean.FALSE);
    }

    public Triangle(EquilateralTriangle o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Triangle(IsoscelesTriangle o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Triangle(ScaleneTriangle o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("EquilateralTriangle", new GenericType<EquilateralTriangle>() {
        });
        schemas.put("IsoscelesTriangle", new GenericType<IsoscelesTriangle>() {
        });
        schemas.put("ScaleneTriangle", new GenericType<ScaleneTriangle>() {
        });
        JSON.registerDescendants(Triangle.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, GenericType> getSchemas() {
        return Triangle.schemas;
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
        if (JSON.isInstanceOf(EquilateralTriangle.class, instance, new HashSet<Class>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(IsoscelesTriangle.class, instance, new HashSet<Class>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(ScaleneTriangle.class, instance, new HashSet<Class>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be EquilateralTriangle, IsoscelesTriangle, ScaleneTriangle");
    }



}

