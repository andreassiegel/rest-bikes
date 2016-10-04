package de.andreassiegel.bike.nextbike.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import de.andreassiegel.bike.nextbike.domain.City;
import de.andreassiegel.bike.nextbike.domain.xml.XmlCity;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

/**
 * Collection converter tests.
 */
@RunWith(MockitoJUnitRunner.class)
public class CollectionConverterTest {

    @Mock
    private ConversionService conversionService;

    @InjectMocks
    private CollectionConverter converter;

    @After
    public void tearDown() {

        reset(conversionService);
    }

    @Test
    public void that_convert_succeeds() {

        final Collection<XmlCity> collection = Arrays.asList(mock(XmlCity.class), mock(XmlCity.class));
        final Collection<City> expectedCollection = Arrays.asList(mock(City.class), mock(City.class));

        when(conversionService.convert(eq(collection), any(TypeDescriptor.class), any(TypeDescriptor.class))).thenReturn(expectedCollection);

        Collection<City> resultCollection = converter.convert(collection, XmlCity.class, City.class);

        assertEquals(expectedCollection, resultCollection);
    }

    @Test
    public void that_convert_succeeds_for_empty_collection() {

        final Collection<XmlCity> collection = new ArrayList<>();

        when(conversionService.convert(eq(collection), any(TypeDescriptor.class), any(TypeDescriptor.class))).thenReturn(Collections.emptyList());

        Collection<City> resultCollection = converter.convert(collection, XmlCity.class, City.class);

        assertNotNull(resultCollection);
        assertTrue(resultCollection.isEmpty());
    }

    @Test
    public void that_convert_returns_null_for_null() {

        final Collection<XmlCity> collection = null;

        Collection<City> resultCollection = converter.convert(collection, XmlCity.class, City.class);

        assertNull(resultCollection);
    }
}
