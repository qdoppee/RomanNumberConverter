package be.qde.ronu.model.data;

import be.qde.ronu.model.logic.validators.BasicRomanNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@SuppressWarnings("ConstantConditions")
class BasicBasicRomanNumberBuilderTest {

    @Test
    void buildEmptyNumber() {
        BasicRomanNumberBuilder builder = new BasicRomanNumberBuilder(new BasicRomanNumberValidator());
        Optional<RomanNumber> optNumber = builder.buildAndClear();
        Assertions.assertFalse(optNumber.isPresent());
    }

    @Test
    void buildOneDigitNumber() {
        BasicRomanNumberBuilder builder = new BasicRomanNumberBuilder(new BasicRomanNumberValidator());
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_I);
        Optional<RomanNumber> optNumber = builder.buildAndClear();
        Assertions.assertEquals(optNumber.get().getDigits().get(0), BasicRomanDigit.ROMAN_DIGIT_I);

        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_V);
        optNumber = builder.buildAndClear();
        Assertions.assertEquals(optNumber.get().getDigits().get(0), BasicRomanDigit.ROMAN_DIGIT_V);

        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_X);
        optNumber = builder.buildAndClear();
        Assertions.assertEquals(optNumber.get().getDigits().get(0), BasicRomanDigit.ROMAN_DIGIT_X);

        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_L);
        optNumber = builder.buildAndClear();
        Assertions.assertEquals(optNumber.get().getDigits().get(0), BasicRomanDigit.ROMAN_DIGIT_L);

        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_C);
        optNumber = builder.buildAndClear();
        Assertions.assertEquals(optNumber.get().getDigits().get(0), BasicRomanDigit.ROMAN_DIGIT_C);

        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_D);
        optNumber = builder.buildAndClear();
        Assertions.assertEquals(optNumber.get().getDigits().get(0), BasicRomanDigit.ROMAN_DIGIT_D);

        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_M);
        optNumber = builder.buildAndClear();
        Assertions.assertEquals(optNumber.get().getDigits().get(0), BasicRomanDigit.ROMAN_DIGIT_M);
    }

    @Test
    void buildDoubleDigitNumber(){
        BasicRomanNumberBuilder builder = new BasicRomanNumberBuilder(new BasicRomanNumberValidator());
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_I, BasicRomanDigit.ROMAN_DIGIT_V);
        Optional<RomanNumber> optNumber = builder.buildAndClear();
        Assertions.assertEquals(optNumber.get().getDigits().get(0), BasicRomanDigit.ROMAN_DIGIT_I);
        Assertions.assertEquals(optNumber.get().getDigits().get(1), BasicRomanDigit.ROMAN_DIGIT_V);
    }

    @Test
    void buildLegalNumber() {
        BasicRomanNumberBuilder builder = new BasicRomanNumberBuilder(new BasicRomanNumberValidator());
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_M);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_M);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_M);
        Optional<RomanNumber> optNumber = builder.buildAndClear();
        Assertions.assertEquals(optNumber.get().getDigits().get(0), BasicRomanDigit.ROMAN_DIGIT_M);
        Assertions.assertEquals(optNumber.get().getDigits().get(1), BasicRomanDigit.ROMAN_DIGIT_M);
        Assertions.assertEquals(optNumber.get().getDigits().get(2), BasicRomanDigit.ROMAN_DIGIT_M);

        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_M);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_M);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_M);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_M);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_D);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_C);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_C);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_C);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_L);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_X);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_X);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_V);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_I);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_I);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_I);
        optNumber = builder.buildAndClear();
        Assertions.assertEquals(optNumber.get().getDigits().get(0), BasicRomanDigit.ROMAN_DIGIT_M);
        Assertions.assertEquals(optNumber.get().getDigits().get(1), BasicRomanDigit.ROMAN_DIGIT_M);
        Assertions.assertEquals(optNumber.get().getDigits().get(2), BasicRomanDigit.ROMAN_DIGIT_M);
        Assertions.assertEquals(optNumber.get().getDigits().get(3), BasicRomanDigit.ROMAN_DIGIT_M);
        Assertions.assertEquals(optNumber.get().getDigits().get(4), BasicRomanDigit.ROMAN_DIGIT_D);
        Assertions.assertEquals(optNumber.get().getDigits().get(5), BasicRomanDigit.ROMAN_DIGIT_C);
        Assertions.assertEquals(optNumber.get().getDigits().get(6), BasicRomanDigit.ROMAN_DIGIT_C);
        Assertions.assertEquals(optNumber.get().getDigits().get(7), BasicRomanDigit.ROMAN_DIGIT_C);
        Assertions.assertEquals(optNumber.get().getDigits().get(8), BasicRomanDigit.ROMAN_DIGIT_L);
        Assertions.assertEquals(optNumber.get().getDigits().get(9), BasicRomanDigit.ROMAN_DIGIT_X);
        Assertions.assertEquals(optNumber.get().getDigits().get(10), BasicRomanDigit.ROMAN_DIGIT_X);
        Assertions.assertEquals(optNumber.get().getDigits().get(11), BasicRomanDigit.ROMAN_DIGIT_V);
        Assertions.assertEquals(optNumber.get().getDigits().get(12), BasicRomanDigit.ROMAN_DIGIT_I);
        Assertions.assertEquals(optNumber.get().getDigits().get(13), BasicRomanDigit.ROMAN_DIGIT_I);
        Assertions.assertEquals(optNumber.get().getDigits().get(14), BasicRomanDigit.ROMAN_DIGIT_I);
    }

    @Test
    void buildIllegalNumber(){
        BasicRomanNumberBuilder builder = new BasicRomanNumberBuilder(new BasicRomanNumberValidator());
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_V);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_V);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_V);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_V);
        Optional<RomanNumber> optNumber = builder.buildAndClear();
        Assertions.assertFalse(optNumber.isPresent());

        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_L);
        builder.addDigits(BasicRomanDigit.ROMAN_DIGIT_C);
        optNumber = builder.buildAndClear();
        Assertions.assertFalse(optNumber.isPresent());
    }
}