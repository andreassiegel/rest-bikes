package de.andreassiegel.bike.nextbike.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

/**
 * City POJO test.
 */
public class CityTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    // region POJO Test

    @Test
    public void that_builder_exists() {

        City city = City.builder()
            .build();

        assertNotNull(city);
    }

    @Test
    public void that_builder_works() {

        final Integer expectedId = 1;
        final GeoCoordinate expectedLocation = mock(GeoCoordinate.class);
        final String expectedName = "someName";
        final String expectedAlias = "someAlias";
        final Bounds expectedBounds = mock(Bounds.class);
        final Collection<Station> expectedStations = Collections.singletonList(mock(Station.class));

        City city = City.builder()
            .id(expectedId)
            .location(expectedLocation)
            .name(expectedName)
            .alias(expectedAlias)
            .bounds(expectedBounds)
            .stations(expectedStations)
            .build();

        assertEquals(expectedId, city.getId());
        assertEquals(expectedLocation, city.getLocation());
        assertEquals(expectedName, city.getName());
        assertEquals(expectedAlias, city.getAlias());
        assertEquals(expectedBounds, city.getBounds());
        assertEquals(expectedStations, city.getStations());
    }

    @Test
    public void that_set_id_succeeds() {

        final Integer expectedId = 1;

        City city = City.builder()
            .build();
        city.setId(expectedId);

        assertEquals(expectedId, city.getId());
    }

    @Test
    public void that_set_location_succeeds() {

        final GeoCoordinate expectedLocation = mock(GeoCoordinate.class);

        City city = City.builder()
            .build();
        city.setLocation(expectedLocation);

        assertEquals(expectedLocation, city.getLocation());
    }

    @Test
    public void that_set_name_succeeds() {

        final String expectedName = "someName";

        City city = City.builder()
            .build();
        city.setName(expectedName);

        assertEquals(expectedName, city.getName());
    }

    @Test
    public void that_set_alias_succeeds() {

        final String expectedAlias = "someAlias";

        City city = City.builder()
            .build();
        city.setAlias(expectedAlias);

        assertEquals(expectedAlias, city.getAlias());
    }

    @Test
    public void that_set_bounds_succeeds() {

        final Bounds expectedBounds = mock(Bounds.class);

        City city = City.builder()
            .build();
        city.setBounds(expectedBounds);

        assertEquals(expectedBounds, city.getBounds());
    }

    @Test
    public void that_set_stations_succeeds() {

        final Collection<Station> expectedStations = Collections.singletonList(mock(Station.class));

        City city = City.builder()
            .build();
        city.setStations(expectedStations);

        assertEquals(expectedStations, city.getStations());
    }

    // endregion

    // region getStationsCount() Method

    @Test
    public void that_get_stations_count_succeeds() {

        Collection<Station> expectedStations = Arrays.asList(mock(Station.class), mock(Station.class));

        City city = City.builder()
            .stations(expectedStations)
            .build();

        assertEquals((Integer) expectedStations.size(), city.getStationsCount());
    }

    @Test
    public void that_get_stations_count_returns_null_if_no_collection() {

        City city = City.builder()
            .build();

        assertNull(city.getStationsCount());
    }

    // endregion

    // region JSON Serialization

    @Test
    public void that_json_serialization_succeeds() throws JsonProcessingException {

        final Integer expectedId = 1;
        final GeoCoordinate expectedLocation = new GeoCoordinate(null, null);
        final String expectedName = "someName";
        final String expectedAlias = "someAlias";
        final Bounds expectedBounds = Bounds.builder()
            .build();
        final Collection<Station> expectedStations = Collections.singletonList(Station.builder()
                                                                                   .build());

        final String expectedJsonString = String.format(
            "{\"id\":%d,\"location\":%s,\"name\":\"%s\",\"alias\":\"%s\","
            + "\"bounds\":%s,\"stations\":%s,\"stationsCount\":%d}",
            expectedId,
            objectMapper.writeValueAsString(expectedLocation),
            expectedName,
            expectedAlias,
            objectMapper.writeValueAsString(expectedBounds),
            objectMapper.writeValueAsString(expectedStations),
            expectedStations.size());

        City city = City.builder()
            .id(expectedId)
            .location(expectedLocation)
            .name(expectedName)
            .alias(expectedAlias)
            .bounds(expectedBounds)
            .stations(expectedStations)
            .build();

        String jsonString = objectMapper.writeValueAsString(city);

        assertEquals(expectedJsonString, jsonString);
    }

    @Test
    public void that_json_serialization_excludes_null_values() throws JsonProcessingException {

        final String expectedJsonString = "{}";

        City city = City.builder()
            .build();

        String jsonString = objectMapper.writeValueAsString(city);

        assertEquals(expectedJsonString, jsonString);
    }

    // endregion

}
