package de.andreassiegel.bike.nextbike.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Bike domain object model.
 */
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Bike {

    private Integer id;
}
