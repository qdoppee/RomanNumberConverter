package be.qde.ronu.model.data;

import java.util.List;

/**
 * Represent a roman number
 */
public interface RomanNumber {

    /**
     * Return this roman number on a String
     * representing the way this number is written.
     *
     * @return A not null and not empty String
     */
    String write();

    /**
     * Get a not null, unmodifiable list of the
     * RomanDigit composing this number ordered
     * from left (bigger digits) to right (smaller digits)
     *
     * @return A not null, unmodifiable and ordered list of RomanDigit
     */
    List<RomanDigit> getDigits();
}
