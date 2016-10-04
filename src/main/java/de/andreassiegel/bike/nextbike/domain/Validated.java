package de.andreassiegel.bike.nextbike.domain;

import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Abstract class that adds a {@code isValid()} method to extending classes. This enables instances of these classes to validate themselves without
 * the need for a separate validator.
 */
public abstract class Validated {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    @JsonIgnore
    public boolean isValid() {

        try {
            return validator.validate(this)
                .isEmpty();
        } catch (IllegalArgumentException | ValidationException ignored) {
        }

        return false;
    }
}
