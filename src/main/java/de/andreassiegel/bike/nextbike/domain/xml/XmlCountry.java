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
 * XML Element Object for Countries as in the nextbike XML.
 */
@Data
@XmlRootElement(name = "country")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlCountry {

    @XmlAttribute(name = "lat")
    private Double lat;

    @XmlAttribute(name = "lng")
    private Double lng;

    @XmlAttribute(name = "zoom")
    private Integer zoom;

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "hotline")
    private String hotline;

    @XmlAttribute(name = "domain")
    private String domain;

    @XmlAttribute(name = "country")
    private String country;

    @XmlAttribute(name = "country_name")
    private String country_name;

    @XmlAttribute(name = "terms")
    private String terms;

    @XmlAttribute(name = "policy")
    private String policy;

    @XmlAttribute(name = "website")
    private String website;

    private Collection<XmlCity> cities = new ArrayList<>();

    @XmlElement(name = "city")
    public void setCity(XmlCity city) {

        cities.add(city);
    }
}
