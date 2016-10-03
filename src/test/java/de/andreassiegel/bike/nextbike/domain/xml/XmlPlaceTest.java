package de.andreassiegel.bike.nextbike.domain.xml;

import org.junit.*;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.xml.transform.StringSource;

import static org.junit.Assert.*;

/**
 * Place XML model tests.
 */
public class XmlPlaceTest {

    private final Jaxb2Marshaller marshaller;

    public XmlPlaceTest() {

        marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(XmlPlace.class);
    }

    // region POJO Tests

    @Test
    public void that_default_constructor_exists() {

        XmlPlace place = new XmlPlace();

        assertNotNull(place);
    }

    @Test
    public void that_get_uid_exists() {

        XmlPlace place = new XmlPlace();

        assertNull(place.getUid());
    }

    @Test
    public void that_get_lat_exists() {

        XmlPlace place = new XmlPlace();

        assertNull(place.getLat());
    }

    @Test
    public void that_get_lng_exists() {

        XmlPlace place = new XmlPlace();

        assertNull(place.getLng());
    }

    @Test
    public void that_get_name_exists() {

        XmlPlace place = new XmlPlace();

        assertNull(place.getName());
    }

    @Test
    public void that_get_spot_exists() {

        XmlPlace place = new XmlPlace();

        assertNull(place.getSpot());
    }

    @Test
    public void that_get_number_exists() {

        XmlPlace place = new XmlPlace();

        assertNull(place.getNumber());
    }

    @Test
    public void that_get_bikes_exists() {

        XmlPlace place = new XmlPlace();

        assertNull(place.getBikes());
    }

    @Test
    public void that_get_terminal_type_exists() {

        XmlPlace place = new XmlPlace();

        assertNull(place.getTerminal_type());
    }

    @Test
    public void that_get_bike_numbers_exists() {

        XmlPlace place = new XmlPlace();

        assertNull(place.getBike_numbers());
    }

    @Test
    public void that_get_bike_types_exists() {

        XmlPlace place = new XmlPlace();

        assertNull(place.getBike_types());
    }

    @Test
    public void that_set_get_uid_succeeds() {

        final Integer expectedUid = 1;

        XmlPlace place = new XmlPlace();
        place.setUid(expectedUid);

        assertEquals(expectedUid, place.getUid());
    }

    @Test
    public void that_set_get_lat_succeeds() {

        final Double expectedLat = 1.23;

        XmlPlace place = new XmlPlace();
        place.setLat(expectedLat);

        assertEquals(expectedLat, place.getLat());
    }

    @Test
    public void that_set_get_lng_succeeds() {

        final Double expectedLng = 1.23;

        XmlPlace place = new XmlPlace();
        place.setLng(expectedLng);

        assertEquals(expectedLng, place.getLng());
    }

    @Test
    public void that_set_get_name_succeeds() {

        final String expectedName = "someName";

        XmlPlace place = new XmlPlace();
        place.setName(expectedName);

        assertEquals(expectedName, place.getName());
    }

    @Test
    public void that_set_get_spot_succeeds() {

        final Integer expectedSpot = 1;

        XmlPlace place = new XmlPlace();
        place.setSpot(expectedSpot);

        assertEquals(expectedSpot, place.getSpot());
    }

    @Test
    public void that_set_get_number_succeeds() {

        final Integer expectedNumber = 1;

        XmlPlace place = new XmlPlace();
        place.setNumber(expectedNumber);

        assertEquals(expectedNumber, place.getNumber());
    }

    @Test
    public void that_set_get_bikes_succeeds() {

        final Integer expectedBikes = 1;

        XmlPlace place = new XmlPlace();
        place.setBikes(expectedBikes);

        assertEquals(expectedBikes, place.getBikes());
    }

    @Test
    public void that_set_get_terminal_type_succeeds() {

        final String expectedTerminalType = "someTerminalType";

        XmlPlace place = new XmlPlace();
        place.setTerminal_type(expectedTerminalType);

        assertEquals(expectedTerminalType, place.getTerminal_type());
    }

    @Test
    public void that_set_get_bike_numbers_succeeds() {

        final String expectedBikeNumbers = "someBikeNumbers";

        XmlPlace place = new XmlPlace();
        place.setBike_numbers(expectedBikeNumbers);

        assertEquals(expectedBikeNumbers, place.getBike_numbers());
    }

    @Test
    public void that_set_get_bike_types_succeeds() {

        final String expectedBikeTypes = "someBikeTypes";

        XmlPlace place = new XmlPlace();
        place.setBike_types(expectedBikeTypes);

        assertEquals(expectedBikeTypes, place.getBike_types());
    }

    // endregion

    // region XML Deserialization

    @Test
    public void that_empty_xml_deserialization_succeeds() throws Exception {

        final String xmlString = "<place></place>";

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlPlace);

        XmlPlace place = (XmlPlace) object;

        assertNotNull(place);
    }

    @Test
    public void that_xml_attribute_uid_deserialization_succeeds() throws Exception {

        final Integer expectedUid = 1;
        final String xmlString = String.format("<place uid=\"%s\"></place>", expectedUid.toString());

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlPlace);

        XmlPlace place = (XmlPlace) object;

        assertNotNull(place);
        assertEquals(expectedUid, place.getUid());
    }

    @Test
    public void that_xml_attribute_lat_deserialization_succeeds() throws Exception {

        final Double expectedLat = 50.7086;
        final String xmlString = String.format("<place lat=\"%s\"></place>", expectedLat.toString());

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlPlace);

        XmlPlace place = (XmlPlace) object;

        assertNotNull(place);
        assertEquals(expectedLat, place.getLat());
    }

    @Test
    public void that_xml_attribute_lng_deserialization_succeeds() throws Exception {

        final Double expectedLng = 10.6348;
        final String xmlString = String.format("<place lng=\"%s\"></place>", expectedLng.toString());

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlPlace);

        XmlPlace place = (XmlPlace) object;

        assertNotNull(place);
        assertEquals(expectedLng, place.getLng());
    }

    @Test
    public void that_xml_attribute_name_deserialization_succeeds() throws Exception {

        final String expectedName = "someName";
        final String xmlString = String.format("<place name=\"%s\"></place>", expectedName);

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlPlace);

        XmlPlace place = (XmlPlace) object;

        assertNotNull(place);
        assertEquals(expectedName, place.getName());
    }

    @Test
    public void that_xml_attribute_spot_deserialization_succeeds() throws Exception {

        final Integer expectedSpot = 1;
        final String xmlString = String.format("<place spot=\"%s\"></place>", expectedSpot.toString());

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlPlace);

        XmlPlace place = (XmlPlace) object;

        assertNotNull(place);
        assertEquals(expectedSpot, place.getSpot());
    }

    @Test
    public void that_xml_attribute_number_deserialization_succeeds() throws Exception {

        final Integer expectedNumber = 1;
        final String xmlString = String.format("<place number=\"%s\"></place>", expectedNumber.toString());

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlPlace);

        XmlPlace place = (XmlPlace) object;

        assertNotNull(place);
        assertEquals(expectedNumber, place.getNumber());
    }

    @Test
    public void that_xml_attribute_refresh_rate_deserialization_succeeds() throws Exception {

        final Integer expectedBikes = 1;
        final String xmlString = String.format("<place bikes=\"%s\"></place>", expectedBikes.toString());

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlPlace);

        XmlPlace place = (XmlPlace) object;

        assertNotNull(place);
        assertEquals(expectedBikes, place.getBikes());
    }


    @Test
    public void that_xml_attribute_terminal_type_deserialization_succeeds() throws Exception {

        final String expectedTerminalType = "someTerminalType";
        final String xmlString = String.format("<place terminal_type=\"%s\"></place>", expectedTerminalType);

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlPlace);

        XmlPlace place = (XmlPlace) object;

        assertNotNull(place);
        assertEquals(expectedTerminalType, place.getTerminal_type());
    }

    @Test
    public void that_xml_attribute_bike_numbers_deserialization_succeeds() throws Exception {

        final String expectedBikeNumbers = "someBikeNumbers";
        final String xmlString = String.format("<place bike_numbers=\"%s\"></place>", expectedBikeNumbers);

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlPlace);

        XmlPlace place = (XmlPlace) object;

        assertNotNull(place);
        assertEquals(expectedBikeNumbers, place.getBike_numbers());
    }

    @Test
    public void that_xml_attribute_bike_types_deserialization_succeeds() throws Exception {

        final String expectedBikeTypes = "someBikeTypes";
        final String xmlString = String.format("<place bike_types=\"%s\"></place>", expectedBikeTypes);

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlPlace);

        XmlPlace place = (XmlPlace) object;

        assertNotNull(place);
        assertEquals(expectedBikeTypes, place.getBike_types());
    }

    // endregion
}
