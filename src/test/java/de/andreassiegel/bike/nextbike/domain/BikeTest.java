package de.andreassiegel.bike.nextbike.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Bike POJO test.
 */
public class BikeTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    // region POJO tests

    @Test
    public void that_all_args_constructor_exists() {

        Bike bike = new Bike(0);

        assertNotNull(bike);
    }

    @Test
    public void that_constructor_accepts_null_argument() {

        Bike bike = new Bike(null);

        assertNotNull(bike);
    }

    @Test
    public void that_get_id_exists() {

        Bike bike = new Bike(null);

        assertNull(bike.getId());
    }

    @Test
    public void that_set_get_id_succeeds() {

        final Integer expectedId = 1;

        Bike bike = new Bike(null);
        bike.setId(expectedId);

        assertEquals(expectedId, bike.getId());
    }

    // endregion

    // region JSON Serialization

    @Test
    public void that_json_serialization_succeeds() throws JsonProcessingException {

        final Integer expectedId = 1;
        final String expectedJsonString = String.format("{\"id\":%d}", expectedId);

        Bike bike = new Bike(expectedId);

        String jsonString = objectMapper.writeValueAsString(bike);

        assertEquals(expectedJsonString, jsonString);
    }

    @Test
    public void that_json_serialization_includes_null_value() throws JsonProcessingException {

        final Integer expectedId = null;
        final String expectedJsonString = String.format("{\"id\":%d}", expectedId);

        Bike bike = new Bike(expectedId);

        String jsonString = objectMapper.writeValueAsString(bike);

        assertEquals(expectedJsonString, jsonString);
    }

    // endregion
}
