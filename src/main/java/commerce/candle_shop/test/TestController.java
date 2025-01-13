package commerce.candle_shop.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TestController {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(path="/basicauth")
    public String basicAuthCheck() {
        return "Success";
    }


    @GetMapping("/spring")
    public String testConnection(){
        logger.info("testConnection");
        return "Hello to backend";
    }
}
