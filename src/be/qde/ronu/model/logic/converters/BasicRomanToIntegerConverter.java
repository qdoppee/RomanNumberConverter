package be.qde.ronu.model.logic.converters;

import be.qde.ronu.model.data.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class BasicRomanToIntegerConverter extends AbstractRomanConverter<RomanNumber, Integer> {

    /**
     * Convert the given From object to its corresponding To object
     *
     * @param numberToConvert The object to convertToString
     * @return A not nul and not empty Optional of Integer
     */
    public Optional<Integer> convert(RomanNumber numberToConvert){
        Optional<Integer> optConvertedNumber = Optional.empty();

        if (Objects.nonNull(numberToConvert)) {
            List<Integer> romanValues = convertDigitToValues(numberToConvert.getDigits());
            Integer computationResult = computeRomanValues(romanValues);
            if (computationResult > 0) {
                optConvertedNumber = Optional.of(computationResult);
            }
        }

        return optConvertedNumber;
    }

    @Override
    public boolean isAbleToConvert(RomanConversion conversion) {
        return isAbleToConvert(conversion, RomanNumber.class, Integer.class);
    }

    private List<Integer> convertDigitToValues(List<RomanDigit> romanDigits){
        return romanDigits.stream()
                          .map(RomanDigit::getSymbol)
                          .map(BasicRomanDigitUtility::getValueOf)
                          .filter(Optional::isPresent)
                          .map(Optional::get)
                          .map(RomanDigit::getValue)
                          .collect(Collectors.toList());
    }

    private Integer computeRomanValues(List<Integer> romanValues){
        Integer computeResult = 0;
        Integer previousValue = 0;

        for(int i = romanValues.size() - 1; i >= 0; i--){
            Integer currentValue = romanValues.get(i);

            if(currentValue < previousValue) {
                computeResult -= currentValue;
            } else {
                computeResult += currentValue;
                previousValue = currentValue;
            }
        }

        return computeResult;
    }
}
