package de.andreassiegel.bike.nextbike.domain;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Company domain object model.
 */
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Company {

    private String name;

    private GeoCoordinate location;

    private String website;

    private String hotline;

    private String terms;

    private Collection<City> cities;
}
