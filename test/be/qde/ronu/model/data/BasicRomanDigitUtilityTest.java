package be.qde.ronu.model.data;

import be.qde.ronu.model.data.BasicRomanDigit;
import be.qde.ronu.model.data.BasicRomanDigitUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

@SuppressWarnings("ConstantConditions")
class BasicRomanDigitUtilityTest {

    @Test
    void getAllDigitMinToMax() {
        List<RomanDigit> digits = BasicRomanDigitUtility.getAllDigitMinToMax();
        for(int i = 0; i < digits.size() - 1; i++) {
            Assertions.assertTrue(digits.get(i).getValue() < digits.get(i+1).getValue());
        }
    }

    @Test
    void getAllDigitMaxToMin() {
        List<RomanDigit> digits = BasicRomanDigitUtility.getAllDigitMaxToMin();
        for(int i = 0; i < digits.size() - 1; i++) {
            Assertions.assertTrue(digits.get(i).getValue() > digits.get(i+1).getValue());
        }
    }

    @Test
    void getValueOf() {
        Assertions.assertEquals(BasicRomanDigit.ROMAN_DIGIT_I, BasicRomanDigitUtility.getValueOf('I').get());
        Assertions.assertEquals(BasicRomanDigit.ROMAN_DIGIT_V, BasicRomanDigitUtility.getValueOf('V').get());
        Assertions.assertEquals(BasicRomanDigit.ROMAN_DIGIT_X, BasicRomanDigitUtility.getValueOf('X').get());
        Assertions.assertEquals(BasicRomanDigit.ROMAN_DIGIT_L, BasicRomanDigitUtility.getValueOf('L').get());
        Assertions.assertEquals(BasicRomanDigit.ROMAN_DIGIT_C, BasicRomanDigitUtility.getValueOf('C').get());
        Assertions.assertEquals(BasicRomanDigit.ROMAN_DIGIT_D, BasicRomanDigitUtility.getValueOf('D').get());
        Assertions.assertEquals(BasicRomanDigit.ROMAN_DIGIT_M, BasicRomanDigitUtility.getValueOf('M').get());
        Assertions.assertFalse(BasicRomanDigitUtility.getValueOf('A').isPresent());
        Assertions.assertFalse(BasicRomanDigitUtility.getValueOf(null).isPresent());
    }

    @Test
    void areSubtractive() {
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_I, BasicRomanDigit.ROMAN_DIGIT_I));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_I, BasicRomanDigit.ROMAN_DIGIT_V));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_I, BasicRomanDigit.ROMAN_DIGIT_X));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_I, BasicRomanDigit.ROMAN_DIGIT_L));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_I, BasicRomanDigit.ROMAN_DIGIT_C));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_I, BasicRomanDigit.ROMAN_DIGIT_D));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_I, BasicRomanDigit.ROMAN_DIGIT_M));

        Assertions.assertTrue(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_V, BasicRomanDigit.ROMAN_DIGIT_I));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_V, BasicRomanDigit.ROMAN_DIGIT_V));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_V, BasicRomanDigit.ROMAN_DIGIT_X));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_V, BasicRomanDigit.ROMAN_DIGIT_L));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_V, BasicRomanDigit.ROMAN_DIGIT_C));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_V, BasicRomanDigit.ROMAN_DIGIT_D));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_V, BasicRomanDigit.ROMAN_DIGIT_M));

        Assertions.assertTrue(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_X, BasicRomanDigit.ROMAN_DIGIT_I));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_X, BasicRomanDigit.ROMAN_DIGIT_V));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_X, BasicRomanDigit.ROMAN_DIGIT_X));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_X, BasicRomanDigit.ROMAN_DIGIT_L));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_X, BasicRomanDigit.ROMAN_DIGIT_C));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_X, BasicRomanDigit.ROMAN_DIGIT_D));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_X, BasicRomanDigit.ROMAN_DIGIT_M));

        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_L, BasicRomanDigit.ROMAN_DIGIT_I));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_L, BasicRomanDigit.ROMAN_DIGIT_V));
        Assertions.assertTrue(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_L, BasicRomanDigit.ROMAN_DIGIT_X));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_L, BasicRomanDigit.ROMAN_DIGIT_L));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_L, BasicRomanDigit.ROMAN_DIGIT_C));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_L, BasicRomanDigit.ROMAN_DIGIT_D));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_L, BasicRomanDigit.ROMAN_DIGIT_M));

        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_C, BasicRomanDigit.ROMAN_DIGIT_I));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_C, BasicRomanDigit.ROMAN_DIGIT_V));
        Assertions.assertTrue(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_C, BasicRomanDigit.ROMAN_DIGIT_X));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_C, BasicRomanDigit.ROMAN_DIGIT_L));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_C, BasicRomanDigit.ROMAN_DIGIT_C));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_C, BasicRomanDigit.ROMAN_DIGIT_D));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_C, BasicRomanDigit.ROMAN_DIGIT_M));

        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_D, BasicRomanDigit.ROMAN_DIGIT_I));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_D, BasicRomanDigit.ROMAN_DIGIT_V));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_D, BasicRomanDigit.ROMAN_DIGIT_X));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_D, BasicRomanDigit.ROMAN_DIGIT_L));
        Assertions.assertTrue(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_D, BasicRomanDigit.ROMAN_DIGIT_C));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_D, BasicRomanDigit.ROMAN_DIGIT_D));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_D, BasicRomanDigit.ROMAN_DIGIT_M));

        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_M, BasicRomanDigit.ROMAN_DIGIT_I));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_M, BasicRomanDigit.ROMAN_DIGIT_V));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_M, BasicRomanDigit.ROMAN_DIGIT_X));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_M, BasicRomanDigit.ROMAN_DIGIT_L));
        Assertions.assertTrue(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_M, BasicRomanDigit.ROMAN_DIGIT_C));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_M, BasicRomanDigit.ROMAN_DIGIT_D));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_M, BasicRomanDigit.ROMAN_DIGIT_M));

        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(BasicRomanDigit.ROMAN_DIGIT_M, null));
        Assertions.assertFalse(BasicRomanDigitUtility.areSubtractive(null, null));
    }


}