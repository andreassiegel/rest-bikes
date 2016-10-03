package de.andreassiegel.bike.nextbike.domain.xml;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/**
 * XML Element Object for Cities as in the nextbike XML.
 */
@Data
@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlCity {

    @XmlAttribute(name = "uid")
    private Integer uid;

    @XmlAttribute(name = "lat")
    private Double lat;

    @XmlAttribute(name = "lng")
    private Double lng;

    @XmlAttribute(name = "zoom")
    private Integer zoom;

    @XmlAttribute(name = "maps_icon")
    private String maps_icon;

    @XmlAttribute(name = "alias")
    private String alias;

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "num_places")
    private Integer num_places;

    @XmlAttribute(name = "refresh_rate")
    private Integer refresh_rate;

    @XmlAttribute(name = "bounds")
    private String bounds;

    private Collection<XmlPlace> places = new ArrayList<>();

    @XmlElement(name = "place")
    public void setPlace(XmlPlace place) {

        places.add(place);
    }
}
