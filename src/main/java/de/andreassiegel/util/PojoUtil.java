package de.andreassiegel.util;

import java.lang.reflect.Field;
import java.util.Collection;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.util.Assert.notNull;

/**
 * Utility class for static operations on POJOs.
 */
@Slf4j
public class PojoUtil {

    /**
     * <p>Checks if any of an object's field is set. {@link Collection} fields are only considered as set if they contains at least one item.</p>
     * <p>This method is using Reflections to access the declared fields.</p>
     *
     * @param object the object
     * @return {@code true} if any field is set, {@code false} otherwise
     */
    public static boolean anyFieldSet(Object object) {

        notNull(object, "object may not be null");

        for (Field field : object.getClass()
            .getDeclaredFields()) {
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(object);
            } catch (IllegalAccessException e) {
                log.warn("Error accessing field {} of object {}: {}", field, object, e.toString());
            }
            if ((value != null && !(value instanceof Collection)) || value != null && !((Collection) value).isEmpty()) {
                return true;
            }
        }

        return false;
    }
}
