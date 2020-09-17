package ir.sina.student.controller;
import ir.sina.student.model.Student;
import ir.sina.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "index.html";
    }

    @RequestMapping("/add-student")
    public String addStudentPage(Model model, Student student) {
        model.addAttribute("student", student);
        return "addStudent.html";

    }

    @PostMapping("/add")
    public String addStudentPage(@ModelAttribute("student") Student student, HttpServletRequest request, Model model) {
        studentService.save(student);

        model.addAttribute("students", studentService.findAll());
        return "redirect:/";
    }

    @RequestMapping("/update-student/{studentId}")
    public String updateStudentPage(@PathVariable int studentId, Model model) {
        Student student = studentService.getById(studentId);

        if (student == null) {
            throw  new RuntimeException("Student by this ID doesn't exist");
        }
        model.addAttribute("student", student);
        return "updateStudent.html";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("student") Student student, Model model) {
        studentService.save(student);

        model.addAttribute("students", studentService.findAll());
        return "redirect:/";
    }

    @RequestMapping("/delete/{studentId}")
    public String delete(@PathVariable int studentId, Model model) {
        Student student = studentService.getById(studentId);
        if( student == null) {
            throw new RuntimeException("Student by this ID doesn't exist");
        }
        studentService.deleteById(studentId);

        model.addAttribute("students", studentService.findAll());
        return "redirect:/";
    }

}
