package be.qde.ronu.model.data;

import be.qde.ronu.model.logic.validators.RomanNumberValidator;

import java.util.*;

/**
 * This builder ensure that only VALID number are created.
 * The validation is delegated to the specified validator.
 */
public class BasicRomanNumberBuilder implements RomanNumberBuilder {

    private final List<RomanDigit> digits = new ArrayList<>();
    private final RomanNumberValidator<RomanDigit> validator;

    /**
     * Create a new number builder.
     *
     * @param validator the validator to use to check if number are valid or not
     */
    public BasicRomanNumberBuilder(RomanNumberValidator validator) {
        this.validator = Objects.nonNull(validator) ? validator : new DefaultValidator();
    }

    public BasicRomanNumberBuilder addDigits(RomanDigit... digits) {
        if (Objects.nonNull(digits)) {
            Collections.addAll(this.digits, digits);
        }
        return this;
    }

    public Optional<RomanNumber> buildAndClear() {
        Optional<RomanNumber> optNumber = Optional.empty();

        if (validator.validate(digits)) {
            optNumber = Optional.of(new BasicRomanNumber(digits));
        }
        digits.clear();

        return optNumber;
    }

    private class DefaultValidator implements RomanNumberValidator {

        @Override
        public boolean validate(List digits) {
            return true;
        }
    }

}
