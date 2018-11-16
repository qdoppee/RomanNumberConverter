package be.qde.ronu.model.logic.converters;

import be.qde.ronu.model.data.BasicRomanNumberBuilder;
import be.qde.ronu.model.logic.validators.BasicRomanNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@SuppressWarnings("ConstantConditions")
class BasicRomanFromIntegerConverterTest {

    @Test
    void convert() {
        BasicRomanFromIntegerConverter converter = new BasicRomanFromIntegerConverter(new BasicRomanNumberBuilder(new BasicRomanNumberValidator()));
        Map<Integer, String> testValues = getTestValues();
        for(Map.Entry<Integer,String> testValue : testValues.entrySet()) {
            Assertions.assertEquals(testValue.getValue(), converter.convert(testValue.getKey()).get().write());
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