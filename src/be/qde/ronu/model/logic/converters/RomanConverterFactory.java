package be.qde.ronu.model.logic.converters;

import be.qde.ronu.model.data.RomanConversion;

import java.util.Optional;

public interface RomanConverterFactory {

    Optional<RomanConverter> getConverterFor(RomanConversion conversion);

}
