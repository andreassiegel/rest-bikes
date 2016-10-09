package de.andreassiegel.util;

import java.util.Arrays;
import java.util.Collections;

import de.andreassiegel.bike.nextbike.domain.xml.XmlCity;
import de.andreassiegel.bike.nextbike.domain.xml.XmlCountry;

import org.junit.*;
import org.omg.CORBA.Object;

import static de.andreassiegel.util.PojoUtil.anyFieldSet;
import static org.junit.Assert.*;

/**
 * POJO utility tests.
 */
public class PojoUtilTest {

    private static SecurityManager securityManager;

    @BeforeClass
    public static void setUp() {

        securityManager = System.getSecurityManager();
    }

    @After
    public void tearDown() {

        System.setSecurityManager(securityManager);
    }

    // region anyFieldSet()

    @Test
    @Ignore
    public void that_any_field_set_returns_false_for_empty() {

        final XmlCountry xmlCountry = new XmlCountry();

        assertFalse(anyFieldSet(xmlCountry));
    }

    @Test
    @Ignore
    public void that_any_field_set_returns_false_for_empty_cities_collection() {

        final XmlCountry xmlCountry = new XmlCountry();
        xmlCountry.setCities(Collections.emptyList());

        assertFalse(anyFieldSet(xmlCountry));
    }

    @Test
    public void that_any_field_set_returns_true_for_name() {

        final XmlCountry xmlCountry = new XmlCountry();
        xmlCountry.setName("someName");

        assertTrue(anyFieldSet(xmlCountry));
    }

    @Test
    public void that_any_field_set_returns_true_for_cities_collection() {

        final XmlCountry xmlCountry = new XmlCountry();
        xmlCountry.setCities(Arrays.asList(new XmlCity()));

        assertTrue(anyFieldSet(xmlCountry));
    }

    @Test(expected = IllegalArgumentException.class)
    public void that_any_field_set_fails_for_null() {

        Object object = null;

        anyFieldSet(object);
    }

    // endregion
}
