package de.andreassiegel.bike.nextbike.domain;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Station domain object model.
 */
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Station {

    private Integer id;

    private Integer number;

    private GeoCoordinate location;

    private String name;

    private String type;

    private Collection<Bike> bikes;

    public Integer getAvailableBikesCount() {

        return (bikes != null ? bikes.size() : null);
    }
}
