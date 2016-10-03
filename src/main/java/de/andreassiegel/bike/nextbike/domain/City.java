package de.andreassiegel.bike.nextbike.domain;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * City domain object model.
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class City {

    private Integer id;

    private GeoCoordinate location;

    private String name;

    private String alias;

    private Bounds bounds;

    private Collection<Station> stations;

    public Integer getStationsCount() {

        return (stations != null ? stations.size() : null);
    }
}
