package be.qde.ronu.model.data;

import be.qde.ronu.model.data.BasicRomanDigit;
import be.qde.ronu.model.data.BasicRomanNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasicRomanNumberTest {

    @Test
    void toStringTest() {
        BasicRomanNumber romanNumber = new BasicRomanNumber();
        Assertions.assertTrue(romanNumber.write().isEmpty());

        romanNumber.addDigit(BasicRomanDigit.ROMAN_DIGIT_C);
        Assertions.assertEquals("C", romanNumber.write());

        romanNumber.addDigit(BasicRomanDigit.ROMAN_DIGIT_X);
        Assertions.assertEquals("CX", romanNumber.write());
    }
}