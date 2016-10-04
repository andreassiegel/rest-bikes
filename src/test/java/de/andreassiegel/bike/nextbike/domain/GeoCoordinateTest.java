package de.andreassiegel.bike.nextbike.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Geo Coordinate POJO test.
 */
public class GeoCoordinateTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    // region POJO Test

    @Test
    public void that_all_args_constructor_exists() {

        GeoCoordinate geoCoordinate = new GeoCoordinate(0d, 0d);

        assertNotNull(geoCoordinate);
    }

    @Test
    public void that_constructor_accepts_null_argument() {

        GeoCoordinate geoCoordinate = new GeoCoordinate(null, null);

        assertNotNull(geoCoordinate);
    }

    @Test
    public void that_get_latitude_exists() {

        GeoCoordinate geoCoordinate = new GeoCoordinate(null, null);

        assertNull(geoCoordinate.getLatitude());
    }

    @Test
    public void that_get_longitude_exists() {

        GeoCoordinate geoCoordinate = new GeoCoordinate(null, null);

        assertNull(geoCoordinate.getLongitude());
    }

    @Test
    public void that_set_get_latitude_succeeds() {

        final Double expectedLatitude = 1.0;

        GeoCoordinate geoCoordinate = new GeoCoordinate(null, null);
        geoCoordinate.setLatitude(expectedLatitude);

        assertEquals(expectedLatitude, geoCoordinate.getLatitude());
    }

    @Test
    public void that_set_get_longitude_succeeds() {

        final Double expectedLongitude = 1.0;

        GeoCoordinate geoCoordinate = new GeoCoordinate(null, null);
        geoCoordinate.setLongitude(expectedLongitude);

        assertEquals(expectedLongitude, geoCoordinate.getLongitude());
    }

    // endregion

    // region JSON Serialization

    @Test
    public void that_json_serialization_succeeds() throws JsonProcessingException {

        final Double expectedLatitude = 1.0;
        final Double expectedLongitude = 2.0;
        final String expectedJsonString = String.format("{\"latitude\":%s,\"longitude\":%s}",
                                                        expectedLatitude.toString(),
                                                        expectedLongitude.toString());

        GeoCoordinate geoCoordinate = new GeoCoordinate(expectedLatitude, expectedLongitude);

        String jsonString = objectMapper.writeValueAsString(geoCoordinate);

        assertEquals(expectedJsonString, jsonString);
    }

    @Test
    public void that_json_serialization_includes_null_value() throws JsonProcessingException {

        final Double expectedLatitude = null;
        final Double expectedLongitude = null;
        final String expectedJsonString = String.format("{\"latitude\":%s,\"longitude\":%s}",
                                                        expectedLatitude,
                                                        expectedLongitude);

        GeoCoordinate geoCoordinate = new GeoCoordinate(expectedLatitude, expectedLongitude);

        String jsonString = objectMapper.writeValueAsString(geoCoordinate);

        assertEquals(expectedJsonString, jsonString);
    }

    @Test
    public void that_json_serialization_excludes_valid() throws JsonProcessingException {

        GeoCoordinate geoCoordinate = new GeoCoordinate(1.0, 2.0);

        String jsonString = objectMapper.writeValueAsString(geoCoordinate);

        assertFalse(jsonString.contains("valid"));
    }

    // endregion

    // region Self-validation

    @Test
    public void that_is_valid_returns_true() {

        final GeoCoordinate coordinate = new GeoCoordinate(1.0, 1.0);

        assertTrue(coordinate.isValid());
    }

    @Test
    public void that_is_valid_returns_false_for_missing_coordinates() {

        final GeoCoordinate geoReference = new GeoCoordinate(null, null);

        assertFalse(geoReference.isValid());
    }

    // endregion
}
