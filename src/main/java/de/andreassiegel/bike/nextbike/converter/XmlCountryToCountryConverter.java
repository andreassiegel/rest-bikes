package de.andreassiegel.bike.nextbike.converter;

import java.util.ArrayList;

import de.andreassiegel.bike.nextbike.domain.Country;
import de.andreassiegel.bike.nextbike.domain.xml.XmlCountry;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import static de.andreassiegel.util.PojoUtil.anyFieldSet;

/**
 * Converter component for conversion from {@link XmlCountry} to {@link Country}.
 */
@Component
public class XmlCountryToCountryConverter implements Converter<XmlCountry, Country>, FormatterRegistrar {

    @Override
    public Country convert(XmlCountry source) {

        Assert.notNull(source, "source may not be null");

        return Country.builder()
            .code(source.getCountry())
            .domain(source.getDomain())
            .name(source.getCountry_name())
            .companies(anyFieldSet(source) ? new ArrayList<>() : null)
            .build();
    }

    @Override
    public void registerFormatters(FormatterRegistry registry) {

        registry.addConverter(this);
    }
}
