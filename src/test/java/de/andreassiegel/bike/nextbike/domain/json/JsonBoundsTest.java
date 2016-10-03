package de.andreassiegel.bike.nextbike.domain.json;

import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * JSON Bounds POJO Test.
 */
public class JsonBoundsTest {

    @Test
    public void that_default_constructor_exists() {

        JsonBounds bounds = new JsonBounds();

        assertNotNull(bounds);
    }

    @Test
    public void that_get_north_east_exists() {

        JsonBounds bounds = new JsonBounds();

        assertNull(bounds.getNorth_east());
    }

    @Test
    public void that_get_south_west_exists() {

        JsonBounds bounds = new JsonBounds();

        assertNull(bounds.getSouth_west());
    }

    @Test
    public void that_set_get_north_east_succeeds() {

        final JsonGeoReference mockGeoReference = mock(JsonGeoReference.class);

        JsonBounds bounds = new JsonBounds();
        bounds.setNorth_east(mockGeoReference);

        assertEquals(mockGeoReference, bounds.getNorth_east());
    }

    @Test
    public void that_set_get_south_west_succeeds() {

        final JsonGeoReference mockGeoReference = mock(JsonGeoReference.class);

        JsonBounds bounds = new JsonBounds();
        bounds.setSouth_west(mockGeoReference);

        assertEquals(mockGeoReference, bounds.getSouth_west());
    }
}
