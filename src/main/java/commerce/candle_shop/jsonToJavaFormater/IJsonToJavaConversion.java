package commerce.candle_shop.jsonToJavaFormater;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


public interface IJsonToJavaConversion {

    LocalDate stringToLocalDate(String s);
}
