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
 * Markers XML model tests.
 */
public class XmlMarkersTest {

    private final Jaxb2Marshaller marshaller;

    public XmlMarkersTest() {

        marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(XmlMarkers.class);
    }

    // region POJO Tests

    @Test
    public void that_default_constructor_exists() {

        XmlMarkers markers = new XmlMarkers();

        assertNotNull(markers);
    }

    @Test
    public void that_get_countries_exists() {

        XmlMarkers markers = new XmlMarkers();

        assertNotNull(markers.getCountries());
    }

    @Test
    public void that_get_countries_returns_default() {

        XmlMarkers markers = new XmlMarkers();

        assertEquals(emptyList(), markers.getCountries());
    }

    @Test
    public void that_set_get_countries_succeeds() {

        final XmlCountry mockCountry = mock(XmlCountry.class);
        final Collection<XmlCountry> expectedCountryList = new ArrayList(Arrays.asList(mockCountry));

        XmlMarkers markers = new XmlMarkers();

        markers.setCountries(expectedCountryList);

        assertEquals(expectedCountryList, markers.getCountries());

    }

    // endregion

    // region setCountry() Method

    @Test
    public void that_set_country_succeeds() {

        final XmlCountry mockCountry = mock(XmlCountry.class);

        XmlMarkers markers = new XmlMarkers();
        markers.setCountry(mockCountry);

        Collection<XmlCountry> countryCollection = markers.getCountries();

        assertFalse(countryCollection.isEmpty());
        assertEquals(1, countryCollection.size());
        assertEquals(mockCountry,
                     countryCollection.iterator()
                         .next());
    }

    // endregion

    // region XML Deserialization

    @Test
    public void that_empty_xml_deserialization_succeeds() throws Exception {

        final String xmlString = "<markers></markers>";

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlMarkers);

        XmlMarkers markers = (XmlMarkers) object;

        assertNotNull(markers);
        assertNotNull(markers.getCountries());
        assertTrue(markers.getCountries()
                       .isEmpty());
    }

    @Test
    public void that_xml_deserialization_succeeds() throws Exception {

        final String xmlString = "<markers><country></country><country></country></markers>";

        Object object = marshaller.unmarshal(new StringSource(xmlString));

        assertNotNull(object);
        assertTrue(object instanceof XmlMarkers);

        XmlMarkers markers = (XmlMarkers) object;

        assertNotNull(markers);
        assertNotNull(markers.getCountries());
        assertFalse(markers.getCountries()
                        .isEmpty());
        assertEquals(2,
                     markers.getCountries()
                         .size());
    }

    // endregion
}
