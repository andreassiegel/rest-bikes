package de.andreassiegel.bike.nextbike.domain.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.xml.transform.StringSource;

import static java.util.Collections.emptyList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Country XML model tests.
 */
public class XmlCountryTest {

    private final Jaxb2Marshaller marshaller;

    public XmlCountryTest() {

        marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(XmlCountry.class);
    }

    // region POJO Tests

    @Test
    public void that_default_constructor_exists() {

        XmlCountry country = new XmlCountry();

        assertNotNull(country);
    }

    @Test
    public void that_get_lat_exists() {

        XmlCountry country = new XmlCountry();

        assertNull(country.getLat());
    }

    @Test
    public void that_get_lng_exists() {

        XmlCountry country = new XmlCountry();

        assertNull(country.getLng());
    }

    @Test
    public void that_get_zoom_exists() {

        XmlCountry country = new XmlCountry();

        assertNull(country.getZoom());
    }

    @Test
    public void that_get_name_exists() {

        XmlCountry country = new XmlCountry();

        assertNull(country.getName());
    }

    @Test
    public void that_get_hotline_exists() {

        XmlCountry country = new XmlCountry();

        assertNull(country.getHotline());
    }

    @Test
    public void that_get_domain_exists() {

        XmlCountry country = new XmlCountry();

        assertNull(country.getDomain());
    }

    @Test
    public void that_get_country_exists() {

        XmlCountry country = new XmlCountry();

        assertNull(country.getCountry());
    }

    @Test
    public void that_get_country_name_exists() {

        XmlCountry country = new XmlCountry();

        assertNull(country.getCountry_name());
    }

    @Test
    public void that_get_terms_exists() {

        XmlCountry country = new XmlCountry();

        assertNull(country.getTerms());
    }

    @Test
    public void that_get_policy_exists() {

        XmlCountry country = new XmlCountry();

        assertNull(country.getPolicy());
    }

    @Test
    public void that_get_website_exists() {

        XmlCountry country = new XmlCountry();

        assertNull(country.getWebsite());
    }

    @Test
    public void that_get_cities_exists() {

        XmlCountry country = new XmlCountry();

        assertNotNull(country.getCities());
    }

    @Test
    public void that_get_cities_returns_default() {

        XmlCountry country = new XmlCountry();

        assertEquals(emptyList(), country.getCities());
    }

    @Test
    public void that_set_get_lat_succeeds() {

        final Double expectedLat = 1.23;

        XmlCountry country = new XmlCountry();
        country.setLat(expectedLat);

        assertEquals(expectedLat, country.getLat());
    }

    @Test
    public void that_set_get_lng_succeeds() {

        final Double expectedLng = 1.23;

        XmlCountry country = new XmlCountry();
        country.setLng(expectedLng);

        assertEquals(expectedLng, country.getLng());
    }

    @Test
    public void that_set_get_zoom_succeeds() {

        final Integer expectedZoom = 1;

        XmlCountry country = new XmlCountry();
        country.setZoom(expectedZoom);

        assertEquals(expectedZoom, country.getZoom());
    }

    @Test
    public void that_set_get_name_succeeds() {

        final String expectedName = "someName";

        XmlCountry country = new XmlCountry();
        country.setName(expectedName);

        assertEquals(expectedName, country.getName());
    }

    @Test
    public void that_set_get_hotline_succeeds() {

        final String expectedHotline = "someHotline";

        XmlCountry country = new XmlCountry();
        country.setHotline(expectedHotline);

        assertEquals(expectedHotline, country.getHotline());
    }

    @Test
    public void that_set_get_domain_succeeds() {

        final String expectedDomain = "someDomain";

        XmlCountry country = new XmlCountry();
        country.setDomain(expectedDomain);

        assertEquals(expectedDomain, country.getDomain());
    }

    @Test
    public void that_set_get_country_succeeds() {

        final String expectedCountry = "someCountry";

        XmlCountry country = new XmlCountry();
        country.setCountry(expectedCountry);

        assertEquals(expectedCountry, country.getCountry());
    }

    @Test
    public void that_set_get_country_name_succeeds() {

        final String expectedCountryName = "someCountryName";

        XmlCountry country = new XmlCountry();
        country.setCountry_name(expectedCountryName);

        assertEquals(expectedCountryName, country.getCountry_name());
    }

    @Test
    public void that_set_get_terms_succeeds() {

        final String expectedTerms = "someTerms";

        XmlCountry country = new XmlCountry();
        country.setTerms(expectedTerms);

        assertEquals(expectedTerms, country.getTerms());
    }

    @Test
    public void that_set_get_policy_succeeds() {

        final String expectedPolicy = "somePolicy";

        XmlCountry country = new XmlCountry();
        country.setPolicy(expectedPolicy);

        assertEquals(expectedPolicy, country.getPolicy());
    }

    @Test
    public void that_set_get_website_succeeds() {

        final String expectedWebsite = "someWebsite";

        XmlCountry country = new XmlCountry();
        country.setWebsite(expectedWebsite);

        assertEquals(expectedWebsite, country.getWebsite());
    }

    @Test
    public void that_set_get_cities_succeeds() {

        final XmlCity mockCity = mock(XmlCity.class);
        final Collection<XmlCity> expectedCityList = new ArrayList(Arrays.asList(mockCity));

        XmlCountry country = new XmlCountry();

        country.setCities(expectedCityList);

        assertEquals(expectedCityList, country.getCities());

    }

    // endregion

    // region setCity() Method

    @Test
    public void that_set_city_succeeds() {

        final XmlCity mockCity = mock(XmlCity.class);

        XmlCountry country = new XmlCountry();
        country.setCity(mockCity);

        Collection<XmlCity> cityCollection = country.getCities();

        assertFalse(cityCollection.isEmpty());
        assertEquals(1, cityCollection.size());
        assertEquals(mockCity,
                     cityCollection.iterator()
                         .next());
    }

    // endregion

    // region XML Deserialization

    @Test
    public void that_empty_xml_deserialization_succeeds() throws Exception {

        final String xmlString = "<country></country>";

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCountry);

        XmlCountry country = (XmlCountry) object;

        assertNotNull(country);
    }

    @Test
    public void that_xml_attribute_lat_deserialization_succeeds() throws Exception {

        final Double expectedLat = 50.7086;
        final String xmlString = String.format("<country lat=\"%s\"></country>", expectedLat.toString());

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCountry);

        XmlCountry country = (XmlCountry) object;

        assertNotNull(country);
        assertEquals(expectedLat, country.getLat());
    }

    @Test
    public void that_xml_attribute_lng_deserialization_succeeds() throws Exception {

        final Double expectedLng = 10.6348;
        final String xmlString = String.format("<country lng=\"%s\"></country>", expectedLng.toString());

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCountry);

        XmlCountry country = (XmlCountry) object;

        assertNotNull(country);
        assertEquals(expectedLng, country.getLng());
    }

    @Test
    public void that_xml_attribute_zoom_deserialization_succeeds() throws Exception {

        final Integer expectedZoom = 1;
        final String xmlString = String.format("<country zoom=\"%s\"></country>", expectedZoom.toString());

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCountry);

        XmlCountry country = (XmlCountry) object;

        assertNotNull(country);
        assertEquals(expectedZoom, country.getZoom());
    }

    @Test
    public void that_xml_attribute_name_deserialization_succeeds() throws Exception {

        final String expectedName = "someName";
        final String xmlString = String.format("<country name=\"%s\"></country>", expectedName);

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCountry);

        XmlCountry country = (XmlCountry) object;

        assertNotNull(country);
        assertEquals(expectedName, country.getName());
    }

    @Test
    public void that_xml_attribute_hotline_deserialization_succeeds() throws Exception {

        final String expectedHotline = "someHotline";
        final String xmlString = String.format("<country hotline=\"%s\"></country>", expectedHotline);

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCountry);

        XmlCountry country = (XmlCountry) object;

        assertNotNull(country);
        assertEquals(expectedHotline, country.getHotline());
    }

    @Test
    public void that_xml_attribute_domain_deserialization_succeeds() throws Exception {

        final String expectedDomain = "someDomain";
        final String xmlString = String.format("<country domain=\"%s\"></country>", expectedDomain);

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCountry);

        XmlCountry country = (XmlCountry) object;

        assertNotNull(country);
        assertEquals(expectedDomain, country.getDomain());
    }

    @Test
    public void that_xml_attribute_country_deserialization_succeeds() throws Exception {

        final String expectedCountry = "someCountry";
        final String xmlString = String.format("<country country=\"%s\"></country>", expectedCountry);

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCountry);

        XmlCountry country = (XmlCountry) object;

        assertNotNull(country);
        assertEquals(expectedCountry, country.getCountry());
    }

    @Test
    public void that_xml_attribute_country_name_deserialization_succeeds() throws Exception {

        final String expectedCountryName = "someCountryName";
        final String xmlString = String.format("<country country_name=\"%s\"></country>", expectedCountryName);

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCountry);

        XmlCountry country = (XmlCountry) object;

        assertNotNull(country);
        assertEquals(expectedCountryName, country.getCountry_name());
    }

    @Test
    public void that_xml_attribute_terms_deserialization_succeeds() throws Exception {

        final String expectedTerms = "someTerms";
        final String xmlString = String.format("<country terms=\"%s\"></country>", expectedTerms);

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCountry);

        XmlCountry country = (XmlCountry) object;

        assertNotNull(country);
        assertEquals(expectedTerms, country.getTerms());
    }

    @Test
    public void that_xml_attribute_policy_deserialization_succeeds() throws Exception {

        final String expectedPolicy = "somePolicy";
        final String xmlString = String.format("<country policy=\"%s\"></country>", expectedPolicy);

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCountry);

        XmlCountry country = (XmlCountry) object;

        assertNotNull(country);
        assertEquals(expectedPolicy, country.getPolicy());
    }

    @Test
    public void that_xml_attribute_webite_deserialization_succeeds() throws Exception {

        final String expectedWebsite = "someWebsite";
        final String xmlString = String.format("<country website=\"%s\"></country>", expectedWebsite);

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCountry);

        XmlCountry country = (XmlCountry) object;

        assertNotNull(country);
        assertEquals(expectedWebsite, country.getWebsite());
    }

    @Test
    public void that_xml_children_deserialization_succeeds() throws Exception {

        final String xmlString = "<country><city></city><city></city></country>";

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlCountry);

        XmlCountry country = (XmlCountry) object;

        assertNotNull(country);
        assertNotNull(country.getCities());
        assertFalse(country.getCities()
                        .isEmpty());
        assertEquals(2,
                     country.getCities()
                         .size());
    }

    // endregion
}
