package de.andreassiegel.bike.nextbike.domain;

import java.util.Arrays;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * Company POJO test.
 */
public class CompanyTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    // region POJO Test

    @Test
    public void that_builder_exists() {

        Company company = Company.builder()
            .build();

        assertNotNull(company);
    }

    @Test
    public void that_builder_works() {

        final String expectedName = "someName";
        final GeoCoordinate expectedLocation = mock(GeoCoordinate.class);
        final String expectedWebsite = "someWebsite";
        final String expectedHotline = "someHotline";
        final String expectedTerms = "someTerms";
        final Collection<City> expectedCities = Arrays.asList(mock(City.class));

        Company company = Company.builder()
            .name(expectedName)
            .location(expectedLocation)
            .website(expectedWebsite)
            .hotline(expectedHotline)
            .terms(expectedTerms)
            .cities(expectedCities)
            .build();

        assertEquals(expectedName, company.getName());
        assertEquals(expectedLocation, company.getLocation());
        assertEquals(expectedWebsite, company.getWebsite());
        assertEquals(expectedHotline, company.getHotline());
        assertEquals(expectedTerms, company.getTerms());
        assertEquals(expectedCities, company.getCities());
    }

    @Test
    public void that_set_name_succeeds() {

        final String expectedName = "someName";

        Company company = Company.builder()
            .build();
        company.setName(expectedName);

        assertEquals(expectedName, company.getName());
    }

    @Test
    public void that_set_location_succeeds() {

        final GeoCoordinate expectedLocation = mock(GeoCoordinate.class);

        Company company = Company.builder()
            .build();
        company.setLocation(expectedLocation);

        assertEquals(expectedLocation, company.getLocation());
    }

    @Test
    public void that_set_website_succeeds() {

        final String expectedWebsite = "someWebsite";

        Company company = Company.builder()
            .build();
        company.setWebsite(expectedWebsite);

        assertEquals(expectedWebsite, company.getWebsite());
    }

    @Test
    public void that_set_hotline_succeeds() {

        final String expectedHotline = "someHotline";

        Company company = Company.builder()
            .build();
        company.setHotline(expectedHotline);

        assertEquals(expectedHotline, company.getHotline());
    }

    @Test
    public void that_set_terms_succeeds() {

        final String expectedTerms = "someTerms";

        Company company = Company.builder()
            .build();
        company.setTerms(expectedTerms);

        assertEquals(expectedTerms, company.getTerms());
    }

    @Test
    public void that_set_cities_succeeds() {

        final Collection<City> expectedCities = Arrays.asList(mock(City.class));

        Company company = Company.builder()
            .build();
        company.setCities(expectedCities);

        assertEquals(expectedCities, company.getCities());
    }

    // endregion

    // region JSON Serialization

    @Test
    public void that_json_serialization_succeeds() throws JsonProcessingException {

        final String expectedName = "someName";
        final GeoCoordinate expectedLocation = new GeoCoordinate(null, null);
        final String expectedWebsite = "someWebsite";
        final String expectedHotline = "someHotline";
        final String expectedTerms = "someTerms";
        final Collection<City> expectedCities = Arrays.asList(City.builder()
                                                                  .build());

        final String expectedJsonString = String.format(
            "{\"name\":\"%s\",\"location\":%s,\"website\":\"%s\",\"hotline\":\"%s\",\"terms\":\"%s\",\"cities\":%s}",
            expectedName,
            objectMapper.writeValueAsString(expectedLocation),
            expectedWebsite,
            expectedHotline,
            expectedTerms,
            objectMapper.writeValueAsString(expectedCities));

        Company company = Company.builder()
            .name(expectedName)
            .location(expectedLocation)
            .website(expectedWebsite)
            .hotline(expectedHotline)
            .terms(expectedTerms)
            .cities(expectedCities)
            .build();

        String jsonString = objectMapper.writeValueAsString(company);

        assertEquals(expectedJsonString, jsonString);
    }

    @Test
    public void that_json_serialization_excludes_null_values() throws JsonProcessingException {

        final String expectedJsonString = "{}";

        Company company = Company.builder()
            .build();

        String jsonString = objectMapper.writeValueAsString(company);

        assertEquals(expectedJsonString, jsonString);
    }

    // endregion
}
