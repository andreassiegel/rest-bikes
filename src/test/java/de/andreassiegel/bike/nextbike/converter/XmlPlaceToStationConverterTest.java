package de.andreassiegel.bike.nextbike.converter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import de.andreassiegel.bike.nextbike.domain.Bike;
import de.andreassiegel.bike.nextbike.domain.GeoCoordinate;
import de.andreassiegel.bike.nextbike.domain.Station;
import de.andreassiegel.bike.nextbike.domain.xml.XmlPlace;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * XmlPlace to Station Converter tests.
 */
public class XmlPlaceToStationConverterTest {

    XmlPlaceToStationConverter converter = new XmlPlaceToStationConverter();

    // region convert()

    @Test
    public void that_convert_succeeds_without_bikes() {

        final String expectedName = "someName";
        final Integer expectedNumber = 1;
        final Integer expectedId = 2;
        final Double expectedLat = 1.0;
        final Double expectedLong = 2.0;
        final String expectedType = "someType";

        final XmlPlace xmlPlace = new XmlPlace();
        xmlPlace.setName(expectedName);
        xmlPlace.setNumber(expectedNumber);
        xmlPlace.setUid(expectedId);
        xmlPlace.setLat(expectedLat);
        xmlPlace.setLng(expectedLong);
        xmlPlace.setTerminal_type(expectedType);

        final Station expectedStation = Station.builder()
            .name(expectedName)
            .number(expectedNumber)
            .id(expectedId)
            .location(new GeoCoordinate(expectedLat, expectedLong))
            .type(expectedType)
            .bikes(Collections.emptyList())
            .build();

        Station station = converter.convert(xmlPlace);

        assertEquals(expectedStation, station);
    }

    @Test
    public void that_convert_succeeds_with_bikes() {

        final String bikeNumbers = "1,2,3";
        final Collection<Bike> expectedBikes = Arrays.asList(new Bike(1), new Bike(2), new Bike(3));

        final XmlPlace xmlPlace = new XmlPlace();
        xmlPlace.setBike_numbers(bikeNumbers);

        final Station expectedStation = Station.builder()
            .bikes(expectedBikes)
            .build();

        Station station = converter.convert(xmlPlace);

        assertEquals(expectedStation, station);
    }

    @Test
    public void that_convert_succeeds_for_empty() {

        final XmlPlace xmlPlace = new XmlPlace();

        final Station expectedStation = Station.builder()
            .build();

        Station station = converter.convert(xmlPlace);

        assertEquals(expectedStation, station);
    }

    @Test(expected = IllegalArgumentException.class)
    public void that_convert_fails_for_null() {

        final XmlPlace xmlPlace = null;

        converter.convert(xmlPlace);
    }

    // endregion

    // region getBikeCollectionFromString()

    @Test
    public void that_get_bike_collection_succeeds() {

        final String bikeNumbers = "1,2,3";
        final Collection<Bike> expectedBikes = Arrays.asList(new Bike(1), new Bike(2), new Bike(3));

        Collection<Bike> bikes = converter.getBikeCollectionFromString(bikeNumbers);

        assertEquals(expectedBikes, bikes);
    }

    @Test
    public void that_get_bike_collection_succeeds_with_spaces() {

        final String bikeNumbers = "1, 2, 3";
        final Collection<Bike> expectedBikes = Arrays.asList(new Bike(1), new Bike(2), new Bike(3));

        Collection<Bike> bikes = converter.getBikeCollectionFromString(bikeNumbers);

        assertEquals(expectedBikes, bikes);
    }

    @Test
    public void that_get_bikes_collection_succeeds_for_empty_string() {

        final String bikeNumbers = "";
        final Collection<Bike> expectedBikes = Collections.emptyList();

        Collection<Bike> bikes = converter.getBikeCollectionFromString(bikeNumbers);

        assertEquals(expectedBikes, bikes);
    }

    @Test
    public void that_get_bikes_collection_succeeds_for_null() {

        final String bikeNumbers = null;
        final Collection<Bike> expectedBikes = Collections.emptyList();

        Collection<Bike> bikes = converter.getBikeCollectionFromString(bikeNumbers);

        assertEquals(expectedBikes, bikes);
    }

    @Test(expected = IllegalArgumentException.class)
    public void that_get_bike_collection_fails_for_invalid_string() {

        final String bikeNumbers = "some-invalid-string";

        converter.getBikeCollectionFromString(bikeNumbers);
    }

    // endregion

    // region getGeoCoordinateFromXmlPlace()

    @Test
    public void that_get_geo_coordinate_succeeds() {

        final Double expectedLat = 1.0;
        final Double expectedLng = 2.0;

        final XmlPlace xmlPlace = new XmlPlace();
        xmlPlace.setLat(expectedLat);
        xmlPlace.setLng(expectedLng);

        final GeoCoordinate expectedGeoCoordinate = new GeoCoordinate(expectedLat, expectedLng);

        GeoCoordinate geoCoordinate = converter.getGeoCoordinateFromXmlPlace(xmlPlace);

        assertEquals(expectedGeoCoordinate, geoCoordinate);
    }

    @Test
    public void that_get_geo_coordinate_returns_null_for_missing_coordinates() {

        final XmlPlace xmlPlace = new XmlPlace();

        GeoCoordinate geoCoordinate = converter.getGeoCoordinateFromXmlPlace(xmlPlace);

        assertNull(geoCoordinate);
    }

    @Test
    public void that_get_geo_coordinate_returns_null_for_null() {

        final XmlPlace xmlPlace = null;

        GeoCoordinate geoCoordinate = converter.getGeoCoordinateFromXmlPlace(xmlPlace);

        assertNull(geoCoordinate);
    }

    // endregion
}
