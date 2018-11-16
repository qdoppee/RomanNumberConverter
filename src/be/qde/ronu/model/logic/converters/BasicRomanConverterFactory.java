package be.qde.ronu.model.logic.converters;

import be.qde.ronu.model.data.RomanConversion;

import java.util.*;

public class BasicRomanConverterFactory implements RomanConverterFactory {

    private final List<RomanConverter> converters = new ArrayList<>();

    public BasicRomanConverterFactory(List<RomanConverter> converters) {
        if (Objects.nonNull(converters)){
            this.converters.addAll(converters);
        }
    }

    public Optional<RomanConverter> getConverterFor(final RomanConversion conversion) {
        return converters.stream()
                  .filter(converter -> converter.isAbleToConvert(conversion))
                  .findAny();
    }
}
