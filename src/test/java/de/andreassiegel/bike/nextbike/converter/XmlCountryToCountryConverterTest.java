package de.andreassiegel.bike.nextbike.converter;

import java.util.Collections;

import de.andreassiegel.bike.nextbike.domain.Country;
import de.andreassiegel.bike.nextbike.domain.xml.XmlCountry;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * XmlCountry to Country Converter tests.
 */
public class XmlCountryToCountryConverterTest {

    XmlCountryToCountryConverter converter = new XmlCountryToCountryConverter();

    // region convert()

    @Test
    public void that_convert_succeeds() {

        final String domain = "someDomain";
        final String countryField = "someCountryCode";
        final String country_name = "someCountryName";

        final XmlCountry xmlCountry = new XmlCountry();
        xmlCountry.setCountry_name(country_name);
        xmlCountry.setCountry(countryField);
        xmlCountry.setDomain(domain);

        final Country expectedCountry = Country.builder()
            .name(country_name)
            .code(countryField)
            .domain(domain)
            .companies(Collections.emptyList())
            .build();

        Country country = converter.convert(xmlCountry);

        assertEquals(expectedCountry, country);
    }

    @Test
    @Ignore
    public void that_convert_succeeds_for_empty() {

        final XmlCountry xmlCountry = new XmlCountry();

        final Country expectedCountry = Country.builder()
            .build();

        Country country = converter.convert(xmlCountry);

        assertEquals(expectedCountry, country);
    }

    @Test(expected = IllegalArgumentException.class)
    public void that_convert_fails_for_null() {

        final XmlCountry xmlCountry = null;

        converter.convert(xmlCountry);
    }

    // endregion
}
