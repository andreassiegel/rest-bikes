package de.andreassiegel.bike.nextbike.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * Bounds POJO test.
 */
public class BoundsTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    // region POJO Test

    @Test
    public void that_builder_exists() {

        Bounds bounds = Bounds.builder()
            .build();

        assertNotNull(bounds);
    }

    @Test
    public void that_builder_works() {

        final GeoCoordinate mockSouthWest = mock(GeoCoordinate.class);
        final GeoCoordinate mockNorthEast = mock(GeoCoordinate.class);

        Bounds bounds = Bounds.builder()
            .southWest(mockSouthWest)
            .northEast(mockNorthEast)
            .build();

        assertEquals(mockSouthWest, bounds.getSouthWest());
        assertEquals(mockNorthEast, bounds.getNorthEast());
    }

    @Test
    public void that_set_south_west_succeeds() {

        final GeoCoordinate mockSouthWest = mock(GeoCoordinate.class);

        Bounds bounds = Bounds.builder()
            .build();

        bounds.setSouthWest(mockSouthWest);

        assertEquals(mockSouthWest, bounds.getSouthWest());
    }

    @Test
    public void that_set_north_east_succeeds() {

        final GeoCoordinate mockNorthEast = mock(GeoCoordinate.class);

        Bounds bounds = Bounds.builder()
            .build();

        bounds.setNorthEast(mockNorthEast);

        assertEquals(mockNorthEast, bounds.getNorthEast());
    }

    // endregion

    // region JSON Serialization

    @Test
    public void that_json_serialization_succeeds() throws JsonProcessingException {

        final String expectedSouthWest = "{\"latitude\":null,\"longitude\":null}";
        final String expectedNorthEast = "{\"latitude\":null,\"longitude\":null}";
        final String expectedJsonString = String.format("{\"southWest\":%s,\"northEast\":%s}", expectedSouthWest, expectedNorthEast);

        Bounds bounds = Bounds.builder()
            .southWest(new GeoCoordinate(null, null))
            .northEast(new GeoCoordinate(null, null))
            .build();

        String jsonString = objectMapper.writeValueAsString(bounds);

        assertEquals(expectedJsonString, jsonString);
    }

    @Test
    public void that_json_serialization_includes_null_value() throws JsonProcessingException {

        final String expectedSouthWest = null;
        final String expectedNorthEast = null;
        final String expectedJsonString = String.format("{\"southWest\":%s,\"northEast\":%s}", expectedSouthWest, expectedNorthEast);

        Bounds bounds = Bounds.builder()
            .build();

        String jsonString = objectMapper.writeValueAsString(bounds);

        assertEquals(expectedJsonString, jsonString);
    }

    // endregion
}
