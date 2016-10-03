package de.andreassiegel.bike.nextbike.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Bounds object model.
 */
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Bounds {

    private GeoCoordinate southWest;

    private GeoCoordinate northEast;
}
