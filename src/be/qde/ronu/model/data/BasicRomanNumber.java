package be.qde.ronu.model.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BasicRomanNumber implements RomanNumber {

    private final List<RomanDigit> digits = new ArrayList<>();

    BasicRomanNumber() {
    }

    BasicRomanNumber(List<RomanDigit> digits) {
        if (Objects.nonNull(digits))
            this.digits.addAll(digits);
    }

    public void addDigit(BasicRomanDigit digit) {
        digits.add(digit);
    }

    public List<RomanDigit> getDigits() {
        return Collections.unmodifiableList(digits);
    }

    /**
     * Get the representation of this number
     * as if it was written.
     *
     * @return A not null String
     */
    public String write() {
        return digits.stream()
                .map(RomanDigit::getSymbol)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object obj) {
        if (Objects.isNull(obj)) {
            return false;
        }

        if (!(obj instanceof RomanNumber)) {
            return false;
        }

        RomanNumber number = (RomanNumber) obj;
        return digits.equals(number.getDigits());
    }

    @Override
    public String toString() {
        return String.format("BasicRomanNumber[ %s ]", digits.toString());
    }
}
