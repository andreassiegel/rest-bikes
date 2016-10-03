package de.andreassiegel.bike.nextbike.domain.xml;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/**
 * XML Element Object for Markers which is the root element in the nextbike XML.
 */
@Data
@XmlRootElement(name = "markers")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlMarkers {

    private Collection<XmlCountry> countries = new ArrayList<>();

    @XmlElement(name = "country")
    public void setCountry(XmlCountry country) {

        countries.add(country);
    }
}
