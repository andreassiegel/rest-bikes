package de.andreassiegel.bike.nextbike.domain;

import javax.validation.Validator;
import javax.validation.constraints.Size;

import lombok.Data;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * General validation tests.
 */
public class ValidatedTest {

    @Test(expected = NullPointerException.class)
    public void that_validation_does_not_get_to_method_for_null() {

        Validated validated = null;

        validated.isValid();
    }

    @Test
    public void that_validation_returns_false_for_invalid_constraint() {

        final InvalidConstraintObject object = new InvalidConstraintObject();

        assertFalse(object.isValid());
    }

    @Test
    public void that_init_validator_succeeds() {

        assertNotNull(Validated.initValidator());
        assertTrue(Validated.initValidator() instanceof Validator);
    }

    // region Helper Classes

    @Data
    private class InvalidConstraintObject extends Validated {

        @Size(max = -1)
        private String field;
    }

    // endregion
}
