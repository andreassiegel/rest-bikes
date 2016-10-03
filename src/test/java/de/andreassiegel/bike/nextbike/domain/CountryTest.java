package de.andreassiegel.bike.nextbike.domain;

import java.util.Collection;
import java.util.Collections;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Country POJO test.
 */
public class CountryTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    // region POJO Test

    @Test
    public void that_builder_exists() {

        Country country = Country.builder()
            .build();

        assertNotNull(country);
    }

    @Test
    public void that_builder_works() {

        final String expectedName = "someName";
        final String expectedDomain = "someDomain";
        final String expectedCode = "someCode";
        final Collection<Company> expectedCompanies = Collections.singletonList(mock(Company.class));

        Country country = Country.builder()
            .name(expectedName)
            .domain(expectedDomain)
            .code(expectedCode)
            .companies(expectedCompanies)
            .build();

        assertEquals(expectedName, country.getName());
        assertEquals(expectedDomain, country.getDomain());
        assertEquals(expectedCode, country.getCode());
        assertEquals(expectedCompanies, country.getCompanies());
    }

    @Test
    public void that_set_name_succeeds() {

        final String expectedName = "someName";

        Country country = Country.builder()
            .build();
        country.setName(expectedName);

        assertEquals(expectedName, country.getName());
    }

    @Test
    public void that_set_domain_succeeds() {

        final String expectedDomain = "someDomain";

        Country country = Country.builder()
            .build();
        country.setDomain(expectedDomain);

        assertEquals(expectedDomain, country.getDomain());
    }

    @Test
    public void that_set_code_succeeds() {

        final String expectedCode = "someCode";

        Country country = Country.builder()
            .build();
        country.setCode(expectedCode);

        assertEquals(expectedCode, country.getCode());
    }

    @Test
    public void that_set_companies_succeeds() {

        final Collection<Company> expectedCompanies = Collections.singletonList(mock(Company.class));

        Country country = Country.builder()
            .build();
        country.setCompanies(expectedCompanies);

        assertEquals(expectedCompanies, country.getCompanies());
    }

    // endregion

    // region JSON Serialization

    @Test
    public void that_json_serialization_succeeds() throws JsonProcessingException {

        final String expectedName = "someName";
        final String expectedDomain = "someDomain";
        final String expectedCode = "someCode";
        final Collection<Company> expectedCompanies = Collections.singletonList(Company.builder()
                                                                                    .build());

        final String expectedJsonString = String.format("{\"name\":\"%s\",\"domain\":\"%s\",\"code\":\"%s\",\"companies\":%s}",
                                                        expectedName,
                                                        expectedDomain,
                                                        expectedCode,
                                                        objectMapper.writeValueAsString(expectedCompanies));

        Country country = Country.builder()
            .name(expectedName)
            .domain(expectedDomain)
            .code(expectedCode)
            .companies(expectedCompanies)
            .build();

        String jsonString = objectMapper.writeValueAsString(country);

        assertEquals(expectedJsonString, jsonString);
    }

    @Test
    public void that_json_serialization_excludes_null_values() throws JsonProcessingException {

        final String expectedJsonString = "{}";

        Country country = Country.builder()
            .build();

        String jsonString = objectMapper.writeValueAsString(country);

        assertEquals(expectedJsonString, jsonString);
    }

    // endregion
}
