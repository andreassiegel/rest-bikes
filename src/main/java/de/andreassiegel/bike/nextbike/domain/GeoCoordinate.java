package de.andreassiegel.bike.nextbike.domain;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Geo Coordinate model.
 */
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
public class GeoCoordinate extends Validated {

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;
}
