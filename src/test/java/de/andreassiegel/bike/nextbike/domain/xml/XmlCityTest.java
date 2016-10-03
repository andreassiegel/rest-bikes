package de.andreassiegel.bike.nextbike.domain.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.xml.transform.StringSource;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * City XML model tests.
 */
public class XmlCityTest {

    private final Jaxb2Marshaller marshaller;

    public XmlCityTest() {

        marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(XmlCity.class);
    }

    // region POJO Tests

    @Test
    public void that_default_constructor_exists() {

        XmlCity city = new XmlCity();

        assertNotNull(city);
    }

    @Test
    public void that_get_uid_exists() {

        XmlCity city = new XmlCity();

        assertNull(city.getUid());
    }

    @Test
    public void that_get_lat_exists() {

        XmlCity city = new XmlCity();

        assertNull(city.getLat());
    }

    @Test
    public void that_get_lng_exists() {

        XmlCity city = new XmlCity();

        assertNull(city.getLng());
    }

    @Test
    public void that_get_zoom_exists() {

        XmlCity city = new XmlCity();

        assertNull(city.getZoom());
    }

    @Test
    public void that_get_maps_icon_exists() {

        XmlCity city = new XmlCity();

        assertNull(city.getMaps_icon());
    }

    @Test
    public void that_get_alias_exists() {

        XmlCity city = new XmlCity();

        assertNull(city.getAlias());
    }

    @Test
    public void that_get_name_exists() {

        XmlCity city = new XmlCity();

        assertNull(city.getName());
    }

    @Test
    public void that_get_num_places_exists() {

        XmlCity city = new XmlCity();

        assertNull(city.getNum_places());
    }

    @Test
    public void that_get_refresh_rate_exists() {

        XmlCity city = new XmlCity();

        assertNull(city.getRefresh_rate());
    }

    @Test
    public void that_get_bounds_exists() {

        XmlCity city = new XmlCity();

        assertNull(city.getBounds());
    }

    @Test
    public void that_get_places_exists() {

        XmlCity city = new XmlCity();

        assertNotNull(city.getPlaces());
    }

    @Test
    public void that_get_places_returns_default() {

        XmlCity city = new XmlCity();

        assertEquals(emptyList(), city.getPlaces());
    }

    @Test
    public void that_set_get_uid_succeeds() {

        final Integer expectedUid = 1;

        XmlCity city = new XmlCity();
        city.setUid(expectedUid);

        assertEquals(expectedUid, city.getUid());
    }

    @Test
    public void that_set_get_lat_succeeds() {

        final Double expectedLat = 1.23;

        XmlCity city = new XmlCity();
        city.setLat(expectedLat);

        assertEquals(expectedLat, city.getLat());
    }

    @Test
    public void that_set_get_lng_succeeds() {

        final Double expectedLng = 1.23;

        XmlCity city = new XmlCity();
        city.setLng(expectedLng);

        assertEquals(expectedLng, city.getLng());
    }

    @Test
    public void that_set_get_zoom_succeeds() {

        final Integer expectedZoom = 1;

        XmlCity city = new XmlCity();
        city.setZoom(expectedZoom);

        assertEquals(expectedZoom, city.getZoom());
    }

    @Test
    public void that_set_get_maps_icon_succeeds() {

        final String expectedMapsIcon = "someMapsIcon";

        XmlCity city = new XmlCity();
        city.setMaps_icon(expectedMapsIcon);

        assertEquals(expectedMapsIcon, city.getMaps_icon());
    }

    @Test
    public void that_set_get_alias_succeeds() {

        final String expectedAlias = "someAlias";

        XmlCity city = new XmlCity();
        city.setAlias(expectedAlias);

        assertEquals(expectedAlias, city.getAlias());
    }

    @Test
    public void that_set_get_name_succeeds() {

        final String expectedName = "someName";

        XmlCity city = new XmlCity();
        city.setName(expectedName);

        assertEquals(expectedName, city.getName());
    }

    @Test
    public void that_set_get_num_places_succeeds() {

        final Integer expectedNumPlaces = 1;

        XmlCity city = new XmlCity();
        city.setNum_places(expectedNumPlaces);

        assertEquals(expectedNumPlaces, city.getNum_places());
    }

    @Test
    public void that_set_get_refresh_rate_succeeds() {

        final Integer expectedRefreshRate = 1;

        XmlCity city = new XmlCity();
        city.setRefresh_rate(expectedRefreshRate);

        assertEquals(expectedRefreshRate, city.getRefresh_rate());
    }

    @Test
    public void that_set_get_bounds_succeeds() {

        final String expectedBounds = "someBounds";

        XmlCity city = new XmlCity();
        city.setBounds(expectedBounds);

        assertEquals(expectedBounds, city.getBounds());
    }

    @Test
    public void that_set_get_places_succeeds() {

        final XmlPlace mockPlace = mock(XmlPlace.class);
        final Collection<XmlPlace> expectedPlaceList = new ArrayList(Arrays.asList(mockPlace));

        XmlCity city = new XmlCity();
        city.setPlaces(expectedPlaceList);

        assertEquals(expectedPlaceList, city.getPlaces());
    }

    // endregion

    // region setPlace() Method

    @Test
    public void that_set_place_succeeds() {

        final XmlPlace mockPlace = mock(XmlPlace.class);

        XmlCity city = new XmlCity();
        city.setPlace(mockPlace);

        Collection<XmlPlace> placeCollection = city.getPlaces();

        assertFalse(placeCollection.isEmpty());
        assertEquals(1, placeCollection.size());
        assertEquals(mockPlace,
                     placeCollection.iterator()
                         .next());
    }

    // endregion

    // region XML Deserialization

    @Test
    public void that_empty_xml_deserialization_succeeds() throws Exception {

        final String xmlString = "<city></city>";

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCity);

        XmlCity city = (XmlCity) object;

        assertNotNull(city);
    }

    @Test
    public void that_xml_attribute_uid_deserialization_succeeds() throws Exception {

        final Integer expectedUid = 1;
        final String xmlString = String.format("<city uid=\"%s\"></city>", expectedUid.toString());

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCity);

        XmlCity city = (XmlCity) object;

        assertNotNull(city);
        assertEquals(expectedUid, city.getUid());
    }

    @Test
    public void that_xml_attribute_lat_deserialization_succeeds() throws Exception {

        final Double expectedLat = 50.7086;
        final String xmlString = String.format("<city lat=\"%s\"></city>", expectedLat.toString());

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCity);

        XmlCity city = (XmlCity) object;

        assertNotNull(city);
        assertEquals(expectedLat, city.getLat());
    }

    @Test
    public void that_xml_attribute_lng_deserialization_succeeds() throws Exception {

        final Double expectedLng = 10.6348;
        final String xmlString = String.format("<city lng=\"%s\"></city>", expectedLng.toString());

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCity);

        XmlCity city = (XmlCity) object;

        assertNotNull(city);
        assertEquals(expectedLng, city.getLng());
    }

    @Test
    public void that_xml_attribute_zoom_deserialization_succeeds() throws Exception {

        final Integer expectedZoom = 1;
        final String xmlString = String.format("<city zoom=\"%s\"></city>", expectedZoom.toString());

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCity);

        XmlCity city = (XmlCity) object;

        assertNotNull(city);
        assertEquals(expectedZoom, city.getZoom());
    }

    @Test
    public void that_xml_attribute_maps_icon_deserialization_succeeds() throws Exception {

        final String expectedMapsIcon = "someMapsIcon";
        final String xmlString = String.format("<city maps_icon=\"%s\"></city>", expectedMapsIcon);

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCity);

        XmlCity city = (XmlCity) object;

        assertNotNull(city);
        assertEquals(expectedMapsIcon, city.getMaps_icon());
    }

    @Test
    public void that_xml_attribute_alias_deserialization_succeeds() throws Exception {

        final String expectedAlias = "someAlias";
        final String xmlString = String.format("<city alias=\"%s\"></city>", expectedAlias);

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCity);

        XmlCity city = (XmlCity) object;

        assertNotNull(city);
        assertEquals(expectedAlias, city.getAlias());
    }

    @Test
    public void that_xml_attribute_name_deserialization_succeeds() throws Exception {

        final String expectedName = "someName";
        final String xmlString = String.format("<city name=\"%s\"></city>", expectedName);

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCity);

        XmlCity city = (XmlCity) object;

        assertNotNull(city);
        assertEquals(expectedName, city.getName());
    }

    @Test
    public void that_xml_attribute_num_places_deserialization_succeeds() throws Exception {

        final Integer expectedNumPlaces = 1;
        final String xmlString = String.format("<city num_places=\"%s\"></city>", expectedNumPlaces.toString());

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCity);

        XmlCity city = (XmlCity) object;

        assertNotNull(city);
        assertEquals(expectedNumPlaces, city.getNum_places());
    }

    @Test
    public void that_xml_attribute_refresh_rate_deserialization_succeeds() throws Exception {

        final Integer expectedRefreshRate = 1;
        final String xmlString = String.format("<city refresh_rate=\"%s\"></city>", expectedRefreshRate.toString());

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCity);

        XmlCity city = (XmlCity) object;

        assertNotNull(city);
        assertEquals(expectedRefreshRate, city.getRefresh_rate());
    }

    @Test
    public void that_xml_attribute_bounds_deserialization_succeeds() throws Exception {

        final String expectedBounds = "someBounds";
        final String xmlString = String.format("<city bounds=\"%s\"></city>", expectedBounds);

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCity);

        XmlCity city = (XmlCity) object;

        assertNotNull(city);
        assertEquals(expectedBounds, city.getBounds());
    }
    
    @Test
    public void that_xml_children_deserialization_succeeds() throws Exception {

        final String xmlString = "<city><place></place><place></place></city>";

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCity);

        XmlCity city = (XmlCity) object;

        assertNotNull(city);
        assertNotNull(city.getPlaces());
        assertFalse(city.getPlaces()
                        .isEmpty());
        assertEquals(2,
                     city.getPlaces()
                         .size());
    }

    // endregion
}
