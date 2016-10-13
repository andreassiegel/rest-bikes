package de.andreassiegel.bike.nextbike.converter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import de.andreassiegel.bike.nextbike.domain.Bike;
import de.andreassiegel.bike.nextbike.domain.GeoCoordinate;
import de.andreassiegel.bike.nextbike.domain.Station;
import de.andreassiegel.bike.nextbike.domain.xml.XmlPlace;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import static de.andreassiegel.util.PojoUtil.anyFieldSet;

/**
 * Converter component for conversion from {@link XmlPlace} to {@link Station}.
 */
@Component
public class XmlPlaceToStationConverter implements Converter<XmlPlace, Station>, FormatterRegistrar {

    @Override
    public Station convert(XmlPlace place) {

        Assert.notNull(place, "source may not be null");

        return Station.builder()
            .number(place.getNumber())
            .name(place.getName())
            .id(place.getUid())
            .type(place.getTerminal_type())
            .location(getGeoCoordinateFromXmlPlace(place))
            .bikes(anyFieldSet(place) ? getBikeCollectionFromString(place.getBike_numbers()) : null)
            .build();
    }

    protected Collection<Bike> getBikeCollectionFromString(String bikeNumbers) {

        if (StringUtils.isEmpty(bikeNumbers)) {
            return Collections.emptyList();
        }

        String[] bikeNumberStrings = bikeNumbers.replaceAll("\\s+", "")
            .split(",");

        return Arrays.stream(bikeNumberStrings)
            .map(Integer::parseInt)
            .map(Bike::new)
            .collect(Collectors.toList());
    }

    protected GeoCoordinate getGeoCoordinateFromXmlPlace(XmlPlace place) {

        if (place == null || place.getLat() == null || place.getLng() == null) {
            return null;
        }

        return new GeoCoordinate(place.getLat(), place.getLng());
    }

    @Override
    public void registerFormatters(FormatterRegistry registry) {

        registry.addConverter(this);
    }
}
