package de.andreassiegel.bike.nextbike.domain;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Country domain object model.
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Country {

    private String name;

    private String domain;

    private String code;

    private Collection<Company> companies;
}
