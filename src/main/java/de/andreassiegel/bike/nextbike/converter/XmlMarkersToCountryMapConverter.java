package de.andreassiegel.bike.nextbike.converter;

import java.util.HashMap;
import java.util.Map;

import de.andreassiegel.bike.nextbike.domain.Company;
import de.andreassiegel.bike.nextbike.domain.Country;
import de.andreassiegel.bike.nextbike.domain.xml.XmlCountry;
import de.andreassiegel.bike.nextbike.domain.xml.XmlMarkers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * <p>Converter component for conversion from {@link XmlMarkers} to {@link Map}.</p>
 * <p>The converter turns the XML into a map of {@link Country} objects. The country code is used as map key.</p>
 */
@Component
public class XmlMarkersToCountryMapConverter implements Converter<XmlMarkers, Map<String, Country>>, FormatterRegistrar {

    private final ConversionService conversionService;

    @Autowired
    @Lazy
    public XmlMarkersToCountryMapConverter(ConversionService conversionService) {

        this.conversionService = conversionService;
    }

    @Override
    public Map<String, Country> convert(XmlMarkers markers) {

        Assert.notNull(markers, "source may not be null");

        Map<String, Country> countries = new HashMap<>();

        for (XmlCountry element : markers.getCountries()) {

            Country country;
            if (!countries.containsKey(element.getCountry())) {
                country = conversionService.convert(element, Country.class);
            } else {
                country = countries.get(element.getCountry());
            }

            country.getCompanies()
                .add(conversionService.convert(element, Company.class));

            countries.put(country.getCode(), country);
        }

        return countries;
    }

    @Override
    public void registerFormatters(FormatterRegistry registry) {

        registry.addConverter(this);
    }
}
