package de.andreassiegel.bike.nextbike.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Geo Coordinate model.
 */
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
public class GeoCoordinate {

    private Double latitude;

    private Double longitude;
}
