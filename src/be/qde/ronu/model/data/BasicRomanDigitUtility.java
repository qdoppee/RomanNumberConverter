package be.qde.ronu.model.data;

import java.util.*;

import static be.qde.ronu.model.data.BasicRomanDigit.*;

public class BasicRomanDigitUtility {

    public static List<RomanDigit> getAllDigitMinToMax() {
        return getAllDigits(Comparator.comparingInt(RomanDigit::getValue));
    }

    public static List<RomanDigit> getAllDigitMaxToMin() {
        return getAllDigits((digit1, digit2) -> digit2.getValue() - digit1.getValue());
    }

    /**
     * Check if a digit can be subtract to an other digit
     *
     * @param digit           the first operand of the subtract
     * @param digitToSubtract the second operand of the subtract
     * @return true if the subtraction is valid, false if not
     */
    public static boolean areSubtractive(RomanDigit digit, RomanDigit digitToSubtract) {
        boolean areSubtractive = false;

        if(ROMAN_DIGIT_I.equals(digitToSubtract)) {
            areSubtractive = ROMAN_DIGIT_V.equals(digit) || ROMAN_DIGIT_X.equals(digit);
        } else if (ROMAN_DIGIT_X.equals(digitToSubtract)) {
            areSubtractive = ROMAN_DIGIT_L.equals(digit) || ROMAN_DIGIT_C.equals(digit);
        } else if (ROMAN_DIGIT_C.equals(digitToSubtract)) {
            areSubtractive = ROMAN_DIGIT_D.equals(digit) || ROMAN_DIGIT_M.equals(digit);
        }

        return areSubtractive;
    }

    /**
     * Get the BasicRomanDigit corresponding to the specified symbol
     *
     * @param symbol the symbol of the digit to get
     * @return An not null Optional with BasicRomanDigit if any digit match the given symbol
     */
    public static Optional<RomanDigit> getValueOf(Character symbol) {
        RomanDigit result = null;

        for (RomanDigit currentDigit : getAllDigits(null)) {
            if (currentDigit.getSymbol().equals(symbol)) {
                result = currentDigit;
                break;
            }
        }

        return Optional.ofNullable(result);
    }

    public static int getMaxNumberOfIteration(RomanDigit digit) {
        final int maxNumberOfIteration;

        if(ROMAN_DIGIT_V.equals(digit) || ROMAN_DIGIT_L.equals(digit) || ROMAN_DIGIT_D.equals(digit)){
            maxNumberOfIteration = 1;
        } else if (ROMAN_DIGIT_M.equals(digit)) {
            maxNumberOfIteration = 4;
        } else {
            maxNumberOfIteration = 3;
        }

        return maxNumberOfIteration;
    }

    private static List<RomanDigit> getAllDigits(Comparator<RomanDigit> sorter) {
        List<RomanDigit> allDigits = Arrays.asList(BasicRomanDigit.values());
        allDigits.sort(sorter);
        return allDigits;
    }

}