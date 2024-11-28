package demo_jasonchema2pojo.jasonschema2pojo.controller;



import generated.StudentSchema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<StudentSchema> retriveStudent(){
        StudentSchema a = new StudentSchema().withAge(10.0).withCourse("asd").withName("bbb");
        return ResponseEntity.ok(new StudentSchema());
    }
}
