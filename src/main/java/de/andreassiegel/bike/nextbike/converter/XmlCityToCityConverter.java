package de.andreassiegel.bike.nextbike.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.andreassiegel.bike.nextbike.domain.Bounds;
import de.andreassiegel.bike.nextbike.domain.City;
import de.andreassiegel.bike.nextbike.domain.GeoCoordinate;
import de.andreassiegel.bike.nextbike.domain.Station;
import de.andreassiegel.bike.nextbike.domain.json.JsonBounds;
import de.andreassiegel.bike.nextbike.domain.xml.XmlCity;
import de.andreassiegel.bike.nextbike.domain.xml.XmlPlace;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;

/**
 * Converter component for conversion from {@link XmlCity} to {@link City}.
 */
@Component
@Slf4j
public class XmlCityToCityConverter implements Converter<XmlCity, City>, FormatterRegistrar {

    private final ConversionService conversionService;
    private final CollectionConverter collectionConverter;

    @Autowired
    @Lazy
    public XmlCityToCityConverter(ConversionService conversionService, CollectionConverter collectionConverter) {

        this.conversionService = conversionService;
        this.collectionConverter = collectionConverter;
    }

    @Override
    public City convert(XmlCity city) {

        City.CityBuilder builder = City.builder();

        if (city != null) {
            builder
                .id(city.getUid())
                .name(city.getName())
                .alias(city.getAlias())
                .bounds(parseBoundsFromJson(city.getBounds()))
                .stations(collectionConverter.convert(city.getPlaces(), XmlPlace.class, Station.class))
                .location(getGeoCoordinateFromXmlCity(city));
        }

        return builder.build();
    }

    protected Bounds parseBoundsFromJson(String input) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return conversionService.convert(objectMapper.readValue(input, JsonBounds.class), Bounds.class);
        } catch (Exception e) {
            log.warn("Skipping invalid JSON input for City Bounds: {}", e.toString());
        }

        return null;
    }

    protected GeoCoordinate getGeoCoordinateFromXmlCity(XmlCity city) {

        if (city.getLat() == null || city.getLng() == null) {
            return null;
        }

        return new GeoCoordinate(city.getLat(), city.getLng());
    }

    @Override
    public void registerFormatters(FormatterRegistry registry) {

        registry.addConverter(this);
    }
}
