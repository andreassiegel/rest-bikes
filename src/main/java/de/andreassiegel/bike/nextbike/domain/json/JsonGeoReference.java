package de.andreassiegel.bike.nextbike.domain.json;

import lombok.Data;

/**
 * JSON object for Geo References, as used in the JSON String of the bounds XML attributes returned by nextbike.
 */
@Data
public class JsonGeoReference {

    private Double lat;

    private Double lng;
}
