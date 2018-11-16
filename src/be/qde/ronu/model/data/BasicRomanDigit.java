package be.qde.ronu.model.data;

public enum BasicRomanDigit implements RomanDigit {

    ROMAN_DIGIT_I('I', 1),
    ROMAN_DIGIT_V('V', 5),
    ROMAN_DIGIT_X('X', 10),
    ROMAN_DIGIT_L('L', 50),
    ROMAN_DIGIT_C('C', 100),
    ROMAN_DIGIT_D('D', 500),
    ROMAN_DIGIT_M('M', 1000);

    private final Character symbol;
    private final Integer value;

    BasicRomanDigit(Character symbol, Integer value) {
        this.symbol = symbol;
        this.value = value;
    }

    public Character getSymbol() {
        return symbol;
    }

    public Integer getValue() {
        return value;
    }

}
