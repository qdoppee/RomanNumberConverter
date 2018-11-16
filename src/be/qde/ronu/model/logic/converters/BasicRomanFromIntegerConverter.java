package be.qde.ronu.model.logic.converters;

import be.qde.ronu.model.data.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static be.qde.ronu.model.data.BasicRomanDigitUtility.*;

/**
 * Convert Integer to BasicRomanNumber
 */
public class BasicRomanFromIntegerConverter extends AbstractRomanConverter<Integer, RomanNumber> {

    private RomanNumberBuilder builder;

    /**
     * Create a new converter of Integer to Roman Number.
     *
     * @param builder A not null BasicRomanNumberBuilder
     */
    public BasicRomanFromIntegerConverter(RomanNumberBuilder builder) {
        assert Objects.nonNull(builder) : "BasicRomanFromIntegerConverter requires a not null BasicRomanNumberBuilder";
        this.builder = builder;
    }

    /**
     * Convert the specified integer to its equivalent roman number.
     *
     * The number to convert must be a integer >= 0 and <= 3888)
     *
     * @param numberToConvert An integer >= 0 and <= 3888
     * @return the equivalent roman number or empty value if numberToConvert does not match requirement
     */
    public Optional<RomanNumber> convert(Integer numberToConvert) {
        if (Objects.nonNull(numberToConvert)) {

            List<RomanDigit> allRomanDigits = getAllDigitMaxToMin();
            for (RomanDigit romanDigit : allRomanDigits) {
                // Single digit value is a value represented by a single symbol ('X','V',.. )
                numberToConvert = convertSingleDigitValues(romanDigit, numberToConvert);
                // Two digit value is a value equals to the subtraction of two symbol ('IV','XL',.. )
                numberToConvert = convertDoubleDigitValues(romanDigit, numberToConvert);
            }
        }

        return builder.buildAndClear();
    }

    @Override
    public boolean isAbleToConvert(RomanConversion conversion) {
        return isAbleToConvert(conversion, Integer.class, RomanNumber.class);
    }

    private Integer convertDoubleDigitValues(RomanDigit mainDigit, Integer numberToConvert) {
        for (RomanDigit currentDigit : getAllDigitMinToMax()) {
            int difference = mainDigit.getValue() - currentDigit.getValue();
            if (areSubtractive(mainDigit, currentDigit) && difference <= numberToConvert) {
                builder.addDigits(currentDigit, mainDigit);
                numberToConvert -= (mainDigit.getValue() - currentDigit.getValue());
                break;
            }
        }

        return numberToConvert;
    }

    private Integer convertSingleDigitValues(RomanDigit romanDigit, Integer numberToConvert) {
        int quotient = numberToConvert / romanDigit.getValue();

        while (quotient > 0) {
            builder.addDigits(romanDigit);
            numberToConvert -= romanDigit.getValue();
            quotient = numberToConvert / romanDigit.getValue();
        }

        return numberToConvert;
    }

}
