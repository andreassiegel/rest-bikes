package de.andreassiegel.bike.nextbike.domain;

import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.extern.slf4j.Slf4j;

/**
 * Abstract class that adds a {@code isValid()} method to extending classes. This enables instances of these classes to validate themselves without
 * the need for a separate validator.
 */
@Slf4j
public abstract class Validated {

    private static final Validator validator = initValidator();

    @JsonIgnore
    public boolean isValid() {

        try {
            return validator.validate(this)
                .isEmpty();
        } catch (ValidationException e) {
            log.error("Unexpected exception during validation of {}: {}", this, e.toString());
        }

        return false;
    }

    protected static Validator initValidator() {

        return Validation.buildDefaultValidatorFactory()
            .getValidator();
    }
}
