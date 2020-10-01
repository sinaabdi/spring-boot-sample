package ir.sina.student.controller;
import com.google.gson.Gson;
import ir.sina.student.model.Student;
import ir.sina.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String addStudentPage(@RequestBody Student student) {
        try {
            studentService.save(student);
            return  new  Gson().toJson(studentService.findAll());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return "Error";

    }

    @RequestMapping("/update")
    public String update(@RequestBody Student student) {
        if (student.getId() == 0) {
            return "student doesn't exist";
        }
        studentService.save(student);
        return  new  Gson().toJson(student);
    }

    @RequestMapping("/delete/{studentId}")
    public String delete(@PathVariable int studentId) {
        Student student = studentService.getById(studentId);
        if( student == null) {
            throw new RuntimeException("Student by this ID doesn't exist");
        }
        studentService.deleteById(studentId);

        return  new  Gson().toJson(studentService.findAll());
    }

    @RequestMapping("list")
    public String studentList() {
        return  new  Gson().toJson(studentService.findAll());
    }

}
