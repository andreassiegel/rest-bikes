package de.andreassiegel.bike.nextbike.domain.json;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * JSON Geo Reference POJO Test.
 */
public class JsonGeoReferenceTest {

    @Test
    public void that_default_constructor_exists() {

        JsonGeoReference geoReference = new JsonGeoReference();

        assertNotNull(geoReference);
    }

    @Test
    public void that_get_lat_exists() {

        JsonGeoReference geoReference = new JsonGeoReference();

        assertNull(geoReference.getLat());
    }

    @Test
    public void that_get_lng_exists() {

        JsonGeoReference geoReference = new JsonGeoReference();

        assertNull(geoReference.getLng());
    }

    @Test
    public void that_set_get_lat_succeeds() {

        final Double expectedLat = 0d;

        JsonGeoReference geoReference = new JsonGeoReference();
        geoReference.setLat(expectedLat);

        assertEquals(expectedLat, geoReference.getLat());
    }

    @Test
    public void that_set_get_lng_succeeds() {

        final Double expectedLng = 0d;

        JsonGeoReference geoReference = new JsonGeoReference();
        geoReference.setLng(expectedLng);

        assertEquals(expectedLng, geoReference.getLng());
    }

    @Test
    public void that_is_valid_returns_true() {

        final JsonGeoReference geoReference = new JsonGeoReference();
        geoReference.setLat(1.0);
        geoReference.setLng(1.0);

        assertTrue(geoReference.isValid());
    }

    @Test
    public void that_is_valid_returns_false_for_missing_coordinates() {

        final JsonGeoReference geoReference = new JsonGeoReference();

        assertFalse(geoReference.isValid());
    }
}
