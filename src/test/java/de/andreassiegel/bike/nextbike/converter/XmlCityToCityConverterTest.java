package de.andreassiegel.bike.nextbike.converter;

import java.util.Arrays;
import java.util.Collection;

import de.andreassiegel.bike.nextbike.domain.Bounds;
import de.andreassiegel.bike.nextbike.domain.City;
import de.andreassiegel.bike.nextbike.domain.GeoCoordinate;
import de.andreassiegel.bike.nextbike.domain.Station;
import de.andreassiegel.bike.nextbike.domain.json.JsonBounds;
import de.andreassiegel.bike.nextbike.domain.xml.XmlCity;
import de.andreassiegel.bike.nextbike.domain.xml.XmlPlace;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.convert.ConversionService;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

/**
 * XmlCity to City Converter tests.
 */
@RunWith(MockitoJUnitRunner.class)
public class XmlCityToCityConverterTest {

    @Mock
    private ConversionService conversionService;

    @Mock
    private CollectionConverter collectionConverter;

    @InjectMocks
    private XmlCityToCityConverter converter;

    @After
    public void tearDown() {

        reset(conversionService, collectionConverter);
    }

    @Test
    public void that_mocking_works() {

        assertNotNull(conversionService);
        assertNotNull(collectionConverter);
        assertNotNull(converter);
    }

    // region convert()

    @Test
    public void that_convert_succeeds() {

        final Integer expectedUid = 1;
        final Double expectedLat = 1.0;
        final Double expectedLng = 2.0;
        final Integer expectedZoom = 1;
        final String expectedMapsIcon = "someMapsIcon";
        final String expectedAlias = "someAlias";
        final String expectedName = "someName";
        final Integer expectedNumPlaces = 1;
        final Integer expectedRefreshRate = 1;
        final String bounds = "{\"south_west\":{\"lat\":51.3012,\"lng\":12.2872},\"north_east\":{\"lat\":51.4021,\"lng\":12.4371}}";
        final Collection<XmlPlace> places = Arrays.asList(new XmlPlace());

        final Collection expectedStations = Arrays.asList(Station.builder()
                                                              .build());

        final XmlCity xmlCity = new XmlCity();
        xmlCity.setUid(expectedUid);
        xmlCity.setLat(expectedLat);
        xmlCity.setLng(expectedLng);
        xmlCity.setZoom(expectedZoom);
        xmlCity.setMaps_icon(expectedMapsIcon);
        xmlCity.setAlias(expectedAlias);
        xmlCity.setName(expectedName);
        xmlCity.setNum_places(expectedNumPlaces);
        xmlCity.setRefresh_rate(expectedRefreshRate);
        xmlCity.setBounds(bounds);
        xmlCity.setPlaces(places);

        when(collectionConverter.convert(eq(places), eq(XmlPlace.class), eq(Station.class))).thenReturn(expectedStations);

        final City expectedCity = City.builder()
            .id(expectedUid)
            .location(new GeoCoordinate(expectedLat, expectedLng))
            .name(expectedName)
            .alias(expectedAlias)
            .stations(expectedStations)
            .build();

        final City city = converter.convert(xmlCity);

        assertEquals(expectedCity, city);
    }

    @Test
    public void that_convert_succeeds_for_empty() {

        final XmlCity xmlCity = new XmlCity();

        when(collectionConverter.convert(any(), eq(XmlPlace.class), eq(Station.class))).thenReturn(null);

        final City expectedCity = City.builder()
            .build();

        final City city = converter.convert(xmlCity);

        assertEquals(expectedCity, city);
    }

    @Test
    public void that_convert_succeeds_for_null() {

        final XmlCity xmlCity = null;

        final City expectedCity = City.builder()
            .build();

        final City city = converter.convert(xmlCity);

        assertEquals(expectedCity, city);
    }

    // endregion

    // region parseBoundsFromJson()

    @Test
    public void that_parsing_bounds_succeeds() {

        final String jsonString = "{\"south_west\":{\"lat\":51.3012,\"lng\":12.2872},\"north_east\":{\"lat\":51.4021,\"lng\":12.4371}}";

        final Bounds expectedBounds = Bounds.builder()
            .southWest(new GeoCoordinate(51.3012, 12.2872))
            .northEast(new GeoCoordinate(51.4021, 12.4371))
            .build();

        when(conversionService.convert(any(JsonBounds.class), eq(Bounds.class))).thenReturn(expectedBounds);

        Bounds resultBounds = converter.parseBoundsFromJson(jsonString);

        assertNotNull(resultBounds);
        assertEquals(expectedBounds, resultBounds);
    }

    @Test
    public void that_parsing_bounds_returns_null_if_invalid_input() {

        final String invalidString = "this-is-not-json";

        assertNull(converter.parseBoundsFromJson(invalidString));
    }

    // endregion

    // region getGeoCoordinateFromXmlCity()

    @Test
    public void that_get_geo_coordinate_succeeds() {

        final Double expectedLat = 1.0;
        final Double expectedLng = 2.0;

        final XmlCity xmlCity = new XmlCity();
        xmlCity.setLat(expectedLat);
        xmlCity.setLng(expectedLng);

        final GeoCoordinate expectedGeoCoordinate = new GeoCoordinate(expectedLat, expectedLng);

        GeoCoordinate geoCoordinate = converter.getGeoCoordinateFromXmlCity(xmlCity);

        assertEquals(expectedGeoCoordinate, geoCoordinate);
    }

    @Test
    public void that_get_geo_coordinate_returns_null_for_missing_coordinates() {

        final XmlCity xmlCity = new XmlCity();

        GeoCoordinate geoCoordinate = converter.getGeoCoordinateFromXmlCity(xmlCity);

        assertNull(geoCoordinate);
    }

    // endregion
}
