package be.qde.ronu.model;

import be.qde.ronu.model.data.RomanNumber;

import java.util.Optional;

public interface RomanNumberManager {

    /**
     * Create a RomanNumber from its String representation
     * <p>
     * Optional will be empty if the specified parameter
     * does not represent a valid RomanNumber or is null
     *
     * @param romanNumber the string representation of the number
     * @return A not null buy maybe empty Optional
     */
    Optional<RomanNumber> create(String romanNumber);

    /**
     * Create a RomanNumber from its Integer value
     * <p>
     * Optional will be empty if the specified parameter
     * does not represent a valid RomanNumber or is null
     *
     * @param romanNumber the Integer value of the number
     * @return A not null buy maybe empty Optional
     */
    Optional<RomanNumber> create(Integer romanNumber);

    /**
     * Convert the specified valid RomanNumber to String
     *
     * @param romanNumber the number to convert
     * @return A not null String that will be empty if parameter is null
     */
    String convertToString(RomanNumber romanNumber);

    /**
     * Convert the specified valid RomanNumber to Integer
     *
     * @param romanNumber the number to convert
     * @return A not null Integer representing the number or 0 if number is null
     */
    Integer convertToInteger(RomanNumber romanNumber);
}
