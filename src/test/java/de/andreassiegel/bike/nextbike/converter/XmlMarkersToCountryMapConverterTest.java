package de.andreassiegel.bike.nextbike.converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import de.andreassiegel.bike.nextbike.domain.Company;
import de.andreassiegel.bike.nextbike.domain.Country;
import de.andreassiegel.bike.nextbike.domain.xml.XmlCountry;
import de.andreassiegel.bike.nextbike.domain.xml.XmlMarkers;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.convert.ConversionService;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * XmlMarkers to Map Converter tests.
 */
@RunWith(MockitoJUnitRunner.class)
public class XmlMarkersToCountryMapConverterTest {

    @Mock
    ConversionService conversionService;

    @InjectMocks
    XmlMarkersToCountryMapConverter converter;

    @After
    public void tearDown() {

        reset(conversionService);
    }

    @Test
    public void that_mocking_works() {

        assertNotNull(conversionService);
        assertNotNull(converter);
    }

    // region convert()

    @Test
    public void that_convert_for_different_countries_calls_conversion_service_correctly() {

        final String COUNTRY_1 = "country1";
        final String COUNTRY_2 = "country2";
        final String COUNTRY_3 = "country3";

        final XmlCountry xmlCountry1 = mock(XmlCountry.class);
        final XmlCountry xmlCountry2 = mock(XmlCountry.class);
        final XmlCountry xmlCountry3 = mock(XmlCountry.class);

        final Country country1 = mock(Country.class);
        final Country country2 = mock(Country.class);
        final Country country3 = mock(Country.class);

        final XmlMarkers xmlMarkers = new XmlMarkers();
        xmlMarkers.setCountries(Arrays.asList(xmlCountry1, xmlCountry2, xmlCountry3));

        when(xmlCountry1.getCountry()).thenReturn(COUNTRY_1);
        when(xmlCountry2.getCountry()).thenReturn(COUNTRY_2);
        when(xmlCountry3.getCountry()).thenReturn(COUNTRY_3);

        when(country1.getCode()).thenReturn(COUNTRY_1);
        when(country2.getCode()).thenReturn(COUNTRY_2);
        when(country3.getCode()).thenReturn(COUNTRY_3);

        when(conversionService.convert(any(XmlCountry.class), eq(Country.class))).thenReturn(country1, country2, country3);
        when(conversionService.convert(any(XmlCountry.class), eq(Company.class))).thenReturn(mock(Company.class));

        converter.convert(xmlMarkers);

        verify(conversionService, times(3)).convert(any(XmlCountry.class), eq(Country.class));
        verify(conversionService, times(3)).convert(any(XmlCountry.class), eq(Company.class));
        verifyNoMoreInteractions(conversionService);
    }

    @Test
    public void that_convert_for_different_countries_returns_correct_map() {

        final String COUNTRY_1 = "country1";
        final String COUNTRY_2 = "country2";
        final String COUNTRY_3 = "country3";

        final XmlCountry xmlCountry1 = mock(XmlCountry.class);
        final XmlCountry xmlCountry2 = mock(XmlCountry.class);
        final XmlCountry xmlCountry3 = mock(XmlCountry.class);

        final Country country1 = mock(Country.class);
        final Country country2 = mock(Country.class);
        final Country country3 = mock(Country.class);

        final XmlMarkers xmlMarkers = new XmlMarkers();
        xmlMarkers.setCountries(Arrays.asList(xmlCountry1, xmlCountry2, xmlCountry3));

        when(xmlCountry1.getCountry()).thenReturn(COUNTRY_1);
        when(xmlCountry2.getCountry()).thenReturn(COUNTRY_2);
        when(xmlCountry3.getCountry()).thenReturn(COUNTRY_3);

        when(country1.getCode()).thenReturn(COUNTRY_1);
        when(country2.getCode()).thenReturn(COUNTRY_2);
        when(country3.getCode()).thenReturn(COUNTRY_3);

        when(conversionService.convert(any(XmlCountry.class), eq(Country.class))).thenReturn(country1, country2, country3);
        when(conversionService.convert(any(XmlCountry.class), eq(Company.class))).thenReturn(mock(Company.class));

        Map<String, Country> countries = converter.convert(xmlMarkers);

        assertNotNull(countries);
        assertTrue(countries.containsKey(COUNTRY_1));
        assertTrue(countries.containsKey(COUNTRY_2));
        assertTrue(countries.containsKey(COUNTRY_3));
        assertEquals(3, countries.size());
    }

    @Test
    public void that_convert_for_same_countries_calls_conversion_service_correctly() {

        final String COUNTRY_1 = "country1";

        final XmlCountry xmlCountry1 = mock(XmlCountry.class);
        final XmlCountry xmlCountry2 = mock(XmlCountry.class);
        final XmlCountry xmlCountry3 = mock(XmlCountry.class);

        final Country country = mock(Country.class);

        final XmlMarkers xmlMarkers = new XmlMarkers();
        xmlMarkers.setCountries(Arrays.asList(xmlCountry1, xmlCountry2, xmlCountry3));

        when(xmlCountry1.getCountry()).thenReturn(COUNTRY_1);
        when(xmlCountry2.getCountry()).thenReturn(COUNTRY_1);
        when(xmlCountry3.getCountry()).thenReturn(COUNTRY_1);

        when(country.getCode()).thenReturn(COUNTRY_1);

        when(conversionService.convert(any(XmlCountry.class), eq(Country.class))).thenReturn(country);
        when(conversionService.convert(any(XmlCountry.class), eq(Company.class))).thenReturn(mock(Company.class));

        converter.convert(xmlMarkers);

        verify(conversionService, times(1)).convert(any(XmlCountry.class), eq(Country.class));
        verify(conversionService, times(3)).convert(any(XmlCountry.class), eq(Company.class));
        verifyNoMoreInteractions(conversionService);
    }

    @Test
    public void that_convert_for_same_countries_returns_correct_map() {

        final String COUNTRY_1 = "country1";

        final XmlCountry xmlCountry1 = mock(XmlCountry.class);
        final XmlCountry xmlCountry2 = mock(XmlCountry.class);
        final XmlCountry xmlCountry3 = mock(XmlCountry.class);

        final Country country = mock(Country.class);

        final XmlMarkers xmlMarkers = new XmlMarkers();
        xmlMarkers.setCountries(Arrays.asList(xmlCountry1, xmlCountry2, xmlCountry3));

        when(xmlCountry1.getCountry()).thenReturn(COUNTRY_1);
        when(xmlCountry2.getCountry()).thenReturn(COUNTRY_1);
        when(xmlCountry3.getCountry()).thenReturn(COUNTRY_1);

        when(country.getCode()).thenReturn(COUNTRY_1);

        when(conversionService.convert(any(XmlCountry.class), eq(Country.class))).thenReturn(country);
        when(conversionService.convert(any(XmlCountry.class), eq(Company.class))).thenReturn(mock(Company.class));

        Map<String, Country> countries = converter.convert(xmlMarkers);

        assertNotNull(countries);
        assertTrue(countries.containsKey(COUNTRY_1));
        assertEquals(1, countries.size());
    }

    @Test
    public void that_convert_succeeds_for_empty() {

        final XmlMarkers xmlMarkers = new XmlMarkers();
        final Map<String, Country> expectedMap = Collections.emptyMap();

        Map<String, Country> map = converter.convert(xmlMarkers);

        assertEquals(expectedMap, map);
    }

    @Test
    public void that_convert_succeeds_for_empty_countries() {

        final XmlMarkers xmlMarkers = new XmlMarkers();
        xmlMarkers.setCountries(Collections.emptyList());
        final Map<String, Country> expectedMap = Collections.emptyMap();

        Map<String, Country> map = converter.convert(xmlMarkers);

        assertEquals(expectedMap, map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void that_convert_fails_for_null() {

        final XmlMarkers xmlMarkers = null;

        converter.convert(xmlMarkers);
    }

    // endregion
}
