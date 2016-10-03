package de.andreassiegel.bike.nextbike.domain.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/**
 * XML Element Object for Places as in the nextbike XML.
 */
@Data
@XmlRootElement(name = "place")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlPlace {

    @XmlAttribute(name = "uid")
    private Integer uid;

    @XmlAttribute(name = "lat")
    private Double lat;

    @XmlAttribute(name = "lng")
    private Double lng;

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "spot")
    private Integer spot;

    @XmlAttribute(name = "number")
    private Integer number;

    @XmlAttribute(name = "bikes")
    private Integer bikes;

    @XmlAttribute(name = "terminal_type")
    private String terminal_type;

    @XmlAttribute(name = "bike_numbers")
    private String bike_numbers;

    @XmlAttribute(name = "bike_types")
    private String bike_types;
}
