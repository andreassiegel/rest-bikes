package de.andreassiegel.bike.nextbike.domain;

import java.util.Arrays;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.*;

import static java.util.Collections.emptyList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Station POJO test.
 */
public class StationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    // region POJO Test

    @Test
    public void that_builder_exists() {

        Station station = Station.builder()
            .build();

        assertNotNull(station);
    }

    @Test
    public void that_builder_works() {

        final Integer expectedId = 1;
        final Integer expectedNumber = 123;
        final GeoCoordinate expectedLocation = new GeoCoordinate(null, null);
        final String expectedName = "someName";
        final String expectedType = "someType";
        final Collection<Bike> expectedBikeCollection = emptyList();

        Station station = Station.builder()
            .id(expectedId)
            .number(expectedNumber)
            .location(expectedLocation)
            .name(expectedName)
            .type(expectedType)
            .bikes(expectedBikeCollection)
            .build();

        assertEquals(expectedId, station.getId());
        assertEquals(expectedNumber, station.getNumber());
        assertEquals(expectedLocation, station.getLocation());
        assertEquals(expectedName, station.getName());
        assertEquals(expectedType, station.getType());
        assertEquals(expectedBikeCollection, station.getBikes());
    }

    @Test
    public void that_set_id_succeeds() {

        final Integer expectedId = 1;

        Station station = Station.builder()
            .build();
        station.setId(expectedId);

        assertEquals(expectedId, station.getId());
    }

    @Test
    public void that_set_number_succeeds() {

        final Integer expectedNumber = 1;

        Station station = Station.builder()
            .build();
        station.setNumber(expectedNumber);

        assertEquals(expectedNumber, station.getNumber());
    }

    @Test
    public void that_set_location_succeeds() {

        final GeoCoordinate expectedLocation = mock(GeoCoordinate.class);

        Station station = Station.builder()
            .build();
        station.setLocation(expectedLocation);

        assertEquals(expectedLocation, station.getLocation());
    }

    @Test
    public void that_set_name_succeeds() {

        final String expectedName = "someName";

        Station station = Station.builder()
            .build();
        station.setName(expectedName);

        assertEquals(expectedName, station.getName());
    }

    @Test
    public void that_set_type_succeeds() {

        final String expectedType = "someType";

        Station station = Station.builder()
            .build();
        station.setType(expectedType);

        assertEquals(expectedType, station.getType());
    }

    @Test
    public void that_set_bikes_succeeds() {

        final Collection<Bike> expectedBikeCollection = Arrays.asList(mock(Bike.class));

        Station station = Station.builder()
            .build();
        station.setBikes(expectedBikeCollection);

        assertEquals(expectedBikeCollection, station.getBikes());
    }

    // endregion

    // region Additional Methods

    @Test
    public void that_get_available_bikes_count_succeeds() {

        Station station = Station.builder()
            .bikes(Arrays.asList(mock(Bike.class)))
            .build();

        assertEquals((Integer) 1, station.getAvailableBikesCount());
    }

    @Test
    public void that_get_available_bikes_count_returns_null_if_no_collection() {

        Station station = Station.builder()
            .build();

        assertNull(station.getAvailableBikesCount());
    }

    // endregion

    // region JSON Serialization

    @Test
    public void that_json_serialization_succeeds() throws JsonProcessingException {

        final Integer expectedId = 1;
        final Integer expectedNumber = 123;
        final String expectedLocation = "{\"latitude\":null,\"longitude\":null}";
        final String expectedName = "someName";
        final String expectedType = "someType";
        final Collection<Bike> expectedBikeCollection = emptyList();
        final String expectedJsonString =
            String.format("{\"id\":%d,\"number\":%d,\"location\":%s,\"name\":\"%s\",\"type\":\"%s\",\"bikes\":%s,\"availableBikesCount\":%d}",
                          expectedId,
                          expectedNumber,
                          expectedLocation,
                          expectedName,
                          expectedType,
                          expectedBikeCollection.toString(),
                          expectedBikeCollection.size());

        Station station = Station.builder()
            .id(expectedId)
            .number(expectedNumber)
            .location(new GeoCoordinate(null, null))
            .name(expectedName)
            .type(expectedType)
            .bikes(expectedBikeCollection)
            .build();

        String jsonString = objectMapper.writeValueAsString(station);

        assertEquals(expectedJsonString, jsonString);
    }

    @Test
    public void that_json_serialization_excludes_null_values() throws JsonProcessingException {

        final String expectedJsonString = "{}";

        Station station = Station.builder()
            .build();

        String jsonString = objectMapper.writeValueAsString(station);

        assertEquals(expectedJsonString, jsonString);
    }

    // endregion
}
