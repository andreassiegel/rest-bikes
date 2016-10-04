package de.andreassiegel.bike.nextbike.converter;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

/**
 * Utility component that wraps the {@link ConversionService} to provide an easier to use method for converting collections.
 */
@Component
public class CollectionConverter {

    private final ConversionService conversionService;

    @Autowired
    public CollectionConverter(ConversionService conversionService) {

        this.conversionService = conversionService;
    }

    /**
     * Uses the conversion service to convert a typed Collection into another typed Collection.
     *
     * @param collection the collection
     * @param sourceClass the class of the source type
     * @param targetClass the class of the target type
     * @param <S> the generic source type
     * @param <T> the generic target type
     * @return the converted typed collection
     */
    @SuppressWarnings("unchecked")
    public <S, T> Collection<T> convert(Collection<S> collection, Class sourceClass, Class targetClass) {

        if (collection == null) {
            return null;
        }

        TypeDescriptor sourceDescriptor = TypeDescriptor.collection(Collection.class, TypeDescriptor.valueOf(sourceClass));
        TypeDescriptor targetDescriptor = TypeDescriptor.collection(Collection.class, TypeDescriptor.valueOf(targetClass));

        Object conversionResult = conversionService.convert(collection, sourceDescriptor, targetDescriptor);

        return (Collection<T>) conversionResult;
    }
}
