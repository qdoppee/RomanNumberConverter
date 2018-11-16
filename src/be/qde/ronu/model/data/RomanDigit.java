package be.qde.ronu.model.data;

public interface RomanDigit {

    /**
     * Get the symbol used to write the digit
     *
     * @return A not null Character
     */
    Character getSymbol();

    /**
     * Get the decimal value of this digit
     * when this digit is not in a number
     *
     * @return A not null Integer
     */
    Integer getValue();

}
