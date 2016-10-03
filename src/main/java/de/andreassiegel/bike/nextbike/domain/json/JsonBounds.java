package de.andreassiegel.bike.nextbike.domain.json;

import lombok.Data;

/**
 * JSON object for Bounds, as used in the bounds XML attributes returned by nextbike.
 */
@Data
public class JsonBounds {

    private JsonGeoReference south_west;

    private JsonGeoReference north_east;
}
