package be.qde.ronu.model.logic.converters;

import be.qde.ronu.model.data.BasicRomanNumberBuilder;
import be.qde.ronu.model.data.RomanNumber;
import be.qde.ronu.model.logic.validators.BasicRomanNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

@SuppressWarnings("ConstantConditions")
class BasicRomanToIntegerConverterTest {

    @Test
    void convert() {
        BasicRomanToIntegerConverter toConverter = new BasicRomanToIntegerConverter();
        BasicRomanFromStringConverter fromConverter = new BasicRomanFromStringConverter(new BasicRomanNumberBuilder(new BasicRomanNumberValidator()));

        Map<Integer, String> testValues = getTestValues();
        for(Map.Entry<Integer,String> testValue : testValues.entrySet()) {
            Optional<RomanNumber> optNumber = fromConverter.convert(testValue.getValue());
            Assertions.assertEquals(testValue.getKey(), toConverter.convert(optNumber.get()).get());
        }
    }

    private Map<Integer,String> getTestValues(){
        Map<Integer,String> values = new HashMap<>();

        try(InputStream input = new FileInputStream("test_rsc/romanNumber.property")) {
            Properties prop = new Properties();
            prop.load(input);
            prop.forEach((key,value) -> values.put(Integer.valueOf((String)key), (String)value));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return values;
    }
}
