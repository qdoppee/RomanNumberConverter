package be.qde.ronu.model.logic.converters;

import be.qde.ronu.model.data.RomanConversion;

import java.util.Optional;

/**
 * A RomanConverter allows to convertToString from one type of object to another type
 *
 * @param <From> The type of the source object for the conversion
 * @param <To>   The type of the converted object
 */
public interface RomanConverter<From, To> {

    /**
     * Convert the given From object to its corresponding To object
     *
     * @param toConvert The object to convertToString
     * @return A not nul Optional<To> the converted Object or empty if unable to convertToString
     */
    Optional<To> convert(From toConvert);

    /**
     * Check if this converter is able to execute
     * the specified conversion
     *
     * @param conversion the conversion to test for
     * @return true if this converter can do this conversion, false if not
     */
    boolean isAbleToConvert(RomanConversion conversion);

}
