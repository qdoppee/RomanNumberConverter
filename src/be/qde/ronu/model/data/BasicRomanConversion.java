package be.qde.ronu.model.data;

import java.util.Objects;

/**
 * A conversion to or from a BasicRomanNumber
 */
public class BasicRomanConversion implements RomanConversion {

    public static final boolean CONVERT_FROM_ROMAN = true;
    public static final boolean CONVERT_TO_ROMAN = false;


    private final Class from;
    private final Class to;

    /**
     * Create a new conversion
     *
     * @param convertType the Class to convert to / from
     * @param convertFrom if true : conversion is from convertType -> RomanNumber
     *                    if else : conversion is RomanNumber to -> convertType
     */
    public BasicRomanConversion(Class convertType, boolean convertFrom) {
        convertType = Objects.nonNull(convertType) ? convertType : RomanNumber.class;
        from = convertFrom ? BasicRomanNumber.class : convertType;
        to = convertFrom ? convertType : BasicRomanNumber.class;
    }

    public Class from() {
        return from;
    }

    public Class to() {
        return to;
    }

    /**
     * Two BasicRomanConversion are equals if
     * the from & to Class are equals
     *
     * @param obj the obj to test for equality
     * @return true if equals, false if not
     */
    public boolean equals(Object obj) {
        boolean isEquals = false;

        if (!Objects.isNull(obj) && (!(obj instanceof BasicRomanNumber))) {
            BasicRomanConversion conversion = (BasicRomanConversion) obj;
            isEquals = conversion.from().equals(this.from) && conversion.to().equals(this.to);
        }

        return isEquals;
    }

}
