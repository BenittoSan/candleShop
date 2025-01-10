package commerce.candle_shop.jsonToJavaFormater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class JsonToJavaConversionImp implements IJsonToJavaConversion {

    private static final Logger logger = LoggerFactory.getLogger(JsonToJavaConversionImp.class);

    @Override
    public LocalDate stringToLocalDate(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            return LocalDate.parse(s, formatter);
        }catch (DateTimeParseException e){
            logger.error("Invalid date format:{}",s,e);
            return null;
        }

    }
}
