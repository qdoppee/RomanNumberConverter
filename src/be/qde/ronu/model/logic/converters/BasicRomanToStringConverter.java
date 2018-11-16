package be.qde.ronu.model.logic.converters;

import be.qde.ronu.model.data.BasicRomanNumber;
import be.qde.ronu.model.data.RomanConversion;
import be.qde.ronu.model.data.RomanNumber;

import java.util.Optional;

public class BasicRomanToStringConverter extends AbstractRomanConverter<BasicRomanNumber, String> {

    /**
     * Convert the given BasicRomanNumber to its corresponding String
     *
     * @param numberToConvert The object to convertToString
     * @return A not nul and not empty Optional of Integer
     */
    public Optional<String> convert(BasicRomanNumber numberToConvert) {
        return Optional.of(numberToConvert.write());
    }

    @Override
    public boolean isAbleToConvert(RomanConversion conversion) {
        return isAbleToConvert(conversion, RomanNumber.class, String.class);
    }
}
