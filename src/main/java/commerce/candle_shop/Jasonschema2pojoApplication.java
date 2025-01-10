package commerce.candle_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Jasonschema2pojoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jasonschema2pojoApplication.class, args);
	}

}
