package be.qde.ronu.model.logic.validators;

import be.qde.ronu.model.data.BasicRomanDigitUtility;
import be.qde.ronu.model.data.RomanDigit;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static be.qde.ronu.model.data.BasicRomanDigitUtility.areSubtractive;


public class BasicRomanNumberValidator implements RomanNumberValidator<RomanDigit> {

    public boolean validate(List<RomanDigit> digits) {
        return Objects.nonNull(digits)
                && !digits.isEmpty()
                && !hasToManyRepetition(digits)
                && !hasIllegalSubtract(digits)
                && !hasIllegalSubtractLocation(digits);
    }

    private boolean hasToManyRepetition(List<RomanDigit> digits) {
        boolean hasToManyRepetition = false;
        RomanDigit previousDigit = null;
        int nbrOfRepetition = 0;

        Iterator<RomanDigit> digitIterator = digits.iterator();
        while (digitIterator.hasNext() && !hasToManyRepetition) {
            RomanDigit currentDigit = digitIterator.next();

            nbrOfRepetition = currentDigit.equals(previousDigit) ? nbrOfRepetition + 1 : 1;
            hasToManyRepetition = nbrOfRepetition > BasicRomanDigitUtility.getMaxNumberOfIteration(currentDigit);

            previousDigit =  currentDigit;
        }

        return hasToManyRepetition;
    }

    private boolean hasIllegalSubtract(List<RomanDigit> digits){
        boolean hasInvalidSubtraction = false;

        for(int i = 0; i < digits.size() - 1; i++) {
            RomanDigit currDigit = digits.get(i);
            RomanDigit nextDigit = digits.get(i + 1);

            if(currDigit.getValue() < nextDigit.getValue()
                    && !areSubtractive(nextDigit, currDigit)){
                hasInvalidSubtraction = true;
            }
        }

        return hasInvalidSubtraction;
    }

    private boolean hasIllegalSubtractLocation(List<RomanDigit> digits){
        boolean hasIllegalSubtractLocation = false;

        for(int i = 1; (i < digits.size() - 2) && !hasIllegalSubtractLocation; i++) {
            RomanDigit prevDigit = digits.get(i - 1);
            RomanDigit currDigit = digits.get(i);
            RomanDigit nextDigit = digits.get(i + 1);

            // Illegal subtract location
            if (prevDigit.getValue() < currDigit.getValue() && nextDigit.getValue() >= currDigit.getValue()) {
                hasIllegalSubtractLocation = true;
            }
        }

        return hasIllegalSubtractLocation;
    }
}
