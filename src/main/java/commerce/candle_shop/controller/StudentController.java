package commerce.candle_shop.controller;



import commerce.candle_shop.model.customer.Customer;
import generated.StudentSchema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<StudentSchema> retriveStudent(){
        StudentSchema a = new StudentSchema().withAge(10.0).withCourse("asd").withName("bbb");


        return ResponseEntity.ok(a);
    }
    @GetMapping("customer")
    public ResponseEntity<Customer> retriveCustomer(){
        Customer c = new Customer(1,"name","lastname","cos@wp.pl", LocalDate.now());
        return ResponseEntity.ok(c);
    }
}
