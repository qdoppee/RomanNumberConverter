package be.qde.ronu.model.logic.validators;

import be.qde.ronu.model.data.RomanDigit;

import java.util.List;

/**
 * Validate a roman number based on its digits.
 *
 * @param <T> The implementation of the roman digit
 */
public interface RomanNumberValidator<T extends RomanDigit> {

     /**
     * Check if a List of RomanDigit could make a valid number
     *
     * @param digits The list of digit to validate
     * @return true if the digit can be use to create a valid number
     */
    boolean validate(List<T> digits);
}
