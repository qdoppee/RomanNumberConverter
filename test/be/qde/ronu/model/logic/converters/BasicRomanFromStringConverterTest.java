package be.qde.ronu.model.logic.converters;

import be.qde.ronu.model.data.BasicRomanDigit;
import be.qde.ronu.model.data.BasicRomanNumberBuilder;
import be.qde.ronu.model.data.RomanNumber;
import be.qde.ronu.model.logic.validators.BasicRomanNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class BasicRomanFromStringConverterTest {

    @Test
    void convert() {
        BasicRomanFromStringConverter converter = new BasicRomanFromStringConverter(new BasicRomanNumberBuilder(new BasicRomanNumberValidator()));

        Optional<RomanNumber> optNumber = converter.convert("I");
        Assertions.assertTrue(optNumber.isPresent());
        Assertions.assertEquals(BasicRomanDigit.ROMAN_DIGIT_I, optNumber.get().getDigits().get(0));
        Assertions.assertEquals("I", optNumber.get().write());

        optNumber = converter.convert("IIII");
        Assertions.assertFalse(optNumber.isPresent());
    }
}