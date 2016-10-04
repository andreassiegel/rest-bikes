package de.andreassiegel.bike.nextbike.converter;

import de.andreassiegel.bike.nextbike.domain.Bounds;
import de.andreassiegel.bike.nextbike.domain.GeoCoordinate;
import de.andreassiegel.bike.nextbike.domain.json.JsonBounds;
import de.andreassiegel.bike.nextbike.domain.json.JsonGeoReference;
import lombok.extern.slf4j.Slf4j;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;

/**
 * Converter component for conversion from {@link JsonBounds} to {@link Bounds}.
 */
@Component
@Slf4j
public class JsonBoundsToBoundsConverter implements Converter<JsonBounds, Bounds>, FormatterRegistrar {

    @Override
    public Bounds convert(JsonBounds source) {

        Bounds.BoundsBuilder builder = Bounds.builder();

        if (source != null) {
            builder.northEast(getGeoCoordinateFromJsonGeoReference(source.getNorth_east()))
                .southWest(getGeoCoordinateFromJsonGeoReference(source.getSouth_west()));
        }

        return builder.build();
    }

    protected GeoCoordinate getGeoCoordinateFromJsonGeoReference(JsonGeoReference geoReference) {

        if (geoReference != null && geoReference.isValid()) {

            return new GeoCoordinate(geoReference.getLat(), geoReference.getLng());
        }

        return null;
    }

    @Override
    public void registerFormatters(FormatterRegistry registry) {

        registry.addConverter(this);
    }
}
