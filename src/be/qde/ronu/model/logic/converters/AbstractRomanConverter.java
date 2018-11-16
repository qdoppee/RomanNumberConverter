package be.qde.ronu.model.logic.converters;

import be.qde.ronu.model.data.RomanConversion;

import java.util.Objects;

abstract class AbstractRomanConverter<From, To> implements RomanConverter<From, To> {

    boolean isAbleToConvert(RomanConversion conversion, Class from, Class to) {
        return Objects.nonNull(conversion)
                && conversion.from().equals(from)
                && conversion.to().equals(to);
    }
}
