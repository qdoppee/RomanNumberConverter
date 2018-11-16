package be.qde.ronu.model.logic.converters;

import be.qde.ronu.model.data.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class BasicRomanFromStringConverter extends AbstractRomanConverter<String, RomanNumber> {

    private final RomanNumberBuilder builder;

    public BasicRomanFromStringConverter(RomanNumberBuilder builder) {
        assert Objects.nonNull(builder) : "BasicRomanFromStringConverter requires a not null BasicRomanNumberBuilder";
        this.builder = builder;
    }

    /**
     * Convert the specified stringNumber to its equivalent roman number.
     *
     * @param stringNumber a valid string representation of a roman number
     * @return The equivalent roman number or empty optional if stringNumber does not represent a valid roman number
     */
    public Optional<RomanNumber> convert(String stringNumber) {
        Optional<RomanNumber> optNumber = Optional.empty();

        if (Objects.nonNull(stringNumber) && isAllCharacterDigits(stringNumber)) {
            List<RomanDigit> digits = convertToDigits(stringNumber);
            optNumber = buildNumber(digits);
        }

        return optNumber;
    }

    @Override
    public boolean isAbleToConvert(RomanConversion conversion) {
        return isAbleToConvert(conversion, String.class, RomanNumber.class);
    }

    private Optional<RomanNumber> buildNumber(List<RomanDigit> digits) {
        digits.forEach(builder::addDigits);
        return builder.buildAndClear();
    }


    private boolean isAllCharacterDigits(String stringNumber) {
        return stringNumber.chars()
                .mapToObj(intDigit -> (char) intDigit)
                .map(BasicRomanDigitUtility::getValueOf)
                .allMatch(Optional::isPresent);
    }

    private List<RomanDigit> convertToDigits(String stringNumber) {
        return stringNumber.chars()
                .mapToObj(intDigit -> (char) intDigit)
                .map(BasicRomanDigitUtility::getValueOf)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
