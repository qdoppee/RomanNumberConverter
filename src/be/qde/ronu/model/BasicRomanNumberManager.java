package be.qde.ronu.model;

import be.qde.ronu.model.data.*;
import be.qde.ronu.model.logic.converters.*;
import be.qde.ronu.model.logic.validators.BasicRomanNumberValidator;
import be.qde.ronu.model.logic.validators.RomanNumberValidator;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static be.qde.ronu.model.data.BasicRomanConversion.CONVERT_FROM_ROMAN;
import static be.qde.ronu.model.data.BasicRomanConversion.CONVERT_TO_ROMAN;

public class BasicRomanNumberManager implements RomanNumberManager {

    private static BasicRomanNumberManager numberManager = null;

    public static RomanNumberManager get() {
        if (Objects.isNull(numberManager)) {
            RomanNumberValidator numberBuilderValidator = new BasicRomanNumberValidator();

            List<RomanConverter> converters = new ArrayList<>();
            converters.add(new BasicRomanFromStringConverter(new BasicRomanNumberBuilder(numberBuilderValidator)));
            converters.add(new BasicRomanFromIntegerConverter(new BasicRomanNumberBuilder(numberBuilderValidator)));
            converters.add(new BasicRomanToStringConverter());
            converters.add(new BasicRomanToIntegerConverter());
            RomanConverterFactory factory = new BasicRomanConverterFactory(converters);

            BasicRomanNumberManager.numberManager = new BasicRomanNumberManager(factory);
        }
        return numberManager;
    }


    private RomanConverterFactory converterFactory;

    private BasicRomanNumberManager(RomanConverterFactory converterFactory) {
        assert Objects.nonNull(converterFactory) : "BasicRomanNumberManager requires a not null RomanConverterFactory";
        this.converterFactory = converterFactory;
    }

    @Override
    public Optional<RomanNumber> create(String romanNumberToConvert) {
        return convertTo(romanNumberToConvert, String.class);
    }

    @Override
    public Optional<RomanNumber> create(Integer romanNumberToConvert) {
        return convertTo(romanNumberToConvert, Integer.class);
    }

    @Override
    public Integer convertToInteger(RomanNumber romanNumberToConvert) {
        Optional convertedNumber = Optional.empty();

        if (Objects.nonNull(romanNumberToConvert)) {
            RomanConversion conversion = new BasicRomanConversion(Integer.class, CONVERT_FROM_ROMAN);
            convertedNumber = convert(conversion, romanNumberToConvert);
        }

        return convertedNumber.isPresent() ? (Integer)convertedNumber.get() : 0;
    }

    @Override
    public String convertToString(RomanNumber romanNumberToConvert) {
        final StringBuilder convertedNumber = new StringBuilder();

        if (Objects.nonNull(romanNumberToConvert)) {
            RomanConversion conversion = new BasicRomanConversion(String.class, CONVERT_FROM_ROMAN);
            Optional converted = convert(conversion, romanNumberToConvert);
            if (converted.isPresent()) {
                convertedNumber.append(converted.get());
            }
        }

        return convertedNumber.toString();
    }

    @SuppressWarnings("unchecked")
    private Optional convert(RomanConversion conversion, final Object toConvert) {
        Optional convertResult = Optional.empty();

        Optional<RomanConverter> converter = converterFactory.getConverterFor(conversion);
        if (converter.isPresent()
                && toConvert.getClass().equals(conversion.from())) {
            convertResult = converter.get().convert(toConvert);
        }

        return convertResult;
    }

    @SuppressWarnings("unchecked")
    private Optional<RomanNumber> convertTo(final Object toConvert, final Class objectClass) {
        Optional<RomanNumber> romanNumber = Optional.empty();

        if (Objects.nonNull(toConvert)) {
            RomanConversion conversion = new BasicRomanConversion(objectClass, CONVERT_TO_ROMAN);
            Optional<RomanConverter> converter = converterFactory.getConverterFor(conversion);
            if (converter.isPresent()) {
                romanNumber = converter.get().convert(toConvert);
            }
        }

        return romanNumber;
    }
}
