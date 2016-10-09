package de.andreassiegel.bike.nextbike.converter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import de.andreassiegel.bike.nextbike.domain.City;
import de.andreassiegel.bike.nextbike.domain.Company;
import de.andreassiegel.bike.nextbike.domain.GeoCoordinate;
import de.andreassiegel.bike.nextbike.domain.xml.XmlCity;
import de.andreassiegel.bike.nextbike.domain.xml.XmlCountry;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

/**
 * XmlCountry to Company Converter tests.
 */
@RunWith(MockitoJUnitRunner.class)
public class XmlCountryToCompanyConverterTest {

    @Mock
    private CollectionConverter collectionConverter;

    @InjectMocks
    private XmlCountryToCompanyConverter converter;

    @After
    public void tearDown() {

        reset(collectionConverter);
    }

    @Test
    public void that_mocking_works() {

        assertNotNull(collectionConverter);
        assertNotNull(converter);
    }

    // region convert()

    @Test
    public void that_convert_succeeds() {

        final String name = "someName";
        final String website = "someWebiste";
        final String terms = "someTerms";
        final Double latitude = 1.0;
        final Double longitude = 2.0;
        final String hotline = "someHotline";
        final Collection<XmlCity> cities = Arrays.asList(new XmlCity());

        final Collection expectedCities = Arrays.asList(City.builder()
                                                            .build());

        final XmlCountry xmlCountry = new XmlCountry();
        xmlCountry.setName(name);
        xmlCountry.setWebsite(website);
        xmlCountry.setTerms(terms);
        xmlCountry.setLat(latitude);
        xmlCountry.setLng(longitude);
        xmlCountry.setHotline(hotline);
        xmlCountry.setCities(cities);

        when(collectionConverter.convert(eq(cities), eq(XmlCity.class), eq(City.class))).thenReturn(expectedCities);

        final Company expectedCompany = Company.builder()
            .name(name)
            .website(website)
            .terms(terms)
            .location(new GeoCoordinate(latitude, longitude))
            .hotline(hotline)
            .cities(expectedCities)
            .build();

        Company company = converter.convert(xmlCountry);

        assertEquals(expectedCompany, company);
    }

    @Test
    public void that_convert_succeeds_without_cities() {

        final String name = "someName";
        final String website = "someWebiste";
        final String terms = "someTerms";
        final Double latitude = 1.0;
        final Double longitude = 2.0;
        final String hotline = "someHotline";

        final XmlCountry xmlCountry = new XmlCountry();
        xmlCountry.setName(name);
        xmlCountry.setWebsite(website);
        xmlCountry.setTerms(terms);
        xmlCountry.setLat(latitude);
        xmlCountry.setLng(longitude);
        xmlCountry.setHotline(hotline);

        when(collectionConverter.convert(eq(null), eq(XmlCity.class), eq(City.class))).thenReturn(null);

        final Company expectedCompany = Company.builder()
            .name(name)
            .website(website)
            .terms(terms)
            .location(new GeoCoordinate(latitude, longitude))
            .hotline(hotline)
            .cities(Collections.emptyList())
            .build();

        Company company = converter.convert(xmlCountry);

        assertEquals(expectedCompany, company);
    }

    @Test
    @Ignore
    public void that_convert_succeeds_for_empty() {

        final XmlCountry xmlCountry = new XmlCountry();

        when(collectionConverter.convert(eq(null), eq(XmlCity.class), eq(City.class))).thenReturn(null);

        final Company expectedCompany = Company.builder()
            .build();

        Company company = converter.convert(xmlCountry);

        assertEquals(expectedCompany, company);
    }

    @Test(expected = IllegalArgumentException.class)
    public void that_convert_fails_for_null() {

        XmlCountry xmlCountry = null;

        converter.convert(xmlCountry);
    }

    // endregion
}
