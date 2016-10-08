package de.andreassiegel.bike.nextbike.converter;

import de.andreassiegel.bike.nextbike.domain.City;
import de.andreassiegel.bike.nextbike.domain.Company;
import de.andreassiegel.bike.nextbike.domain.GeoCoordinate;
import de.andreassiegel.bike.nextbike.domain.xml.XmlCity;
import de.andreassiegel.bike.nextbike.domain.xml.XmlCountry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import static de.andreassiegel.util.PojoUtil.anyFieldSet;

/**
 * Converter component for conversion from {@link XmlCountry} to {@link Company}.
 */
@Component
public class XmlCountryToCompanyConverter implements Converter<XmlCountry, Company>, FormatterRegistrar {

    private final CollectionConverter collectionConverter;

    @Autowired
    @Lazy
    public XmlCountryToCompanyConverter(CollectionConverter collectionConverter) {

        this.collectionConverter = collectionConverter;
    }

    @Override
    public Company convert(XmlCountry source) {

        Assert.notNull(source, "source may not be null");

        boolean anyFieldSet = anyFieldSet(source);

        return Company.builder()
            .name(source.getName())
            .location(anyFieldSet ? new GeoCoordinate(source.getLat(), source.getLng()) : null)
            .hotline(source.getHotline())
            .terms(source.getTerms())
            .website(source.getWebsite())
            .cities(anyFieldSet ? collectionConverter.convert(source.getCities(), XmlCity.class, City.class) : null)
            .build();
    }

    @Override
    public void registerFormatters(FormatterRegistry registry) {

        registry.addConverter(this);
    }
}
