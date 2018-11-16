package be.qde.ronu.model.data;

import java.util.Optional;

/**
 * Build a valid roman number
 */
public interface RomanNumberBuilder {

    /**
     * Add a digit to the number to build
     *
     * @param digits the digit to add
     * @return This instance of the builder
     */
    BasicRomanNumberBuilder addDigits(RomanDigit... digits);

    /**
     * Builder a valid RomanNumber if possible
     * and clear the builder to be able to create an other number
     *
     * @return A not null Optional containing a RomanNumber if the current
     * state of the builder allows to create a valid number
     * and an not null empty Optional in other cases
     */
    Optional<RomanNumber> buildAndClear();
}
