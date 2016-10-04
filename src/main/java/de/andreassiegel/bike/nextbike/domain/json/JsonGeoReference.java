package de.andreassiegel.bike.nextbike.domain.json;

import javax.validation.constraints.NotNull;

import de.andreassiegel.bike.nextbike.domain.Validated;
import lombok.Data;

/**
 * JSON object for Geo References, as used in the JSON String of the bounds XML attributes returned by nextbike.
 */
@Data
public class JsonGeoReference extends Validated {

    @NotNull
    private Double lat;

    @NotNull
    private Double lng;
}
