package de.andreassiegel.bike.nextbike.converter;

import de.andreassiegel.bike.nextbike.domain.Bounds;
import de.andreassiegel.bike.nextbike.domain.GeoCoordinate;
import de.andreassiegel.bike.nextbike.domain.json.JsonBounds;
import de.andreassiegel.bike.nextbike.domain.json.JsonGeoReference;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * JsonBounds to Bounds converter tests.
 */
public class JsonBoundsToBoundsConverterTest {

    private final JsonBoundsToBoundsConverter converter = new JsonBoundsToBoundsConverter();

    // region convert()

    @Test
    public void that_convert_succeeds() {

        final JsonGeoReference southWest = new JsonGeoReference();
        southWest.setLat(1.0);
        southWest.setLng(2.0);
        final JsonGeoReference northEast = new JsonGeoReference();
        northEast.setLat(3.0);
        northEast.setLng(4.0);

        final JsonBounds jsonBounds = new JsonBounds();
        jsonBounds.setSouth_west(southWest);
        jsonBounds.setNorth_east(northEast);

        final Bounds expectedBounds = Bounds.builder()
            .southWest(new GeoCoordinate(1.0, 2.0))
            .northEast(new GeoCoordinate(3.0, 4.0))
            .build();

        Bounds bounds = converter.convert(jsonBounds);

        assertEquals(expectedBounds, bounds);
    }

    @Test
    public void that_convert_succeeds_for_empty_bounds() {

        final JsonBounds jsonBounds = new JsonBounds();

        final Bounds expectedBounds = Bounds.builder()
            .build();

        Bounds bounds = converter.convert(jsonBounds);

        assertEquals(expectedBounds, bounds);
    }

    @Test
    public void that_convert_succeeds_for_null() {

        final JsonBounds jsonBounds = null;

        final Bounds expectedBounds = Bounds.builder()
            .build();

        Bounds bounds = converter.convert(jsonBounds);

        assertEquals(expectedBounds, bounds);
    }

    // endregion

    // region getGeoCoordinateFromJsonGeoReference()

    @Test
    public void that_get_geo_coordinate_succeeds() {

        final JsonGeoReference jsonGeoReference = new JsonGeoReference();
        jsonGeoReference.setLat(1.0);
        jsonGeoReference.setLng(2.0);

        final GeoCoordinate expectedGeoCoordinate = new GeoCoordinate(1.0, 2.0);

        GeoCoordinate geoCoordinate = converter.getGeoCoordinateFromJsonGeoReference(jsonGeoReference);

        assertEquals(expectedGeoCoordinate, geoCoordinate);
    }

    @Test
    public void that_get_geo_coordinate_succeeds_for_empty_coordinates() {

        final JsonGeoReference jsonGeoReference = new JsonGeoReference();

        GeoCoordinate geoCoordinate = converter.getGeoCoordinateFromJsonGeoReference(jsonGeoReference);

        assertNull(geoCoordinate);
    }

    @Test
    public void that_get_geo_coordinate_succeeds_for_null() {

        final JsonGeoReference jsonGeoReference = null;

        GeoCoordinate geoCoordinate = converter.getGeoCoordinateFromJsonGeoReference(jsonGeoReference);

        assertNull(geoCoordinate);
    }

    // endregion
}
