package ir.sina.student.controller;
import ir.sina.student.model.Major;
import ir.sina.student.model.Student;
import ir.sina.student.service.MajorService;
import ir.sina.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private MajorService majorService;


    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "index.html";
    }

    @RequestMapping("/add-student")
    public String addStudentPage(Model model, Student student) {
        model.addAttribute("student", student);
        model.addAttribute("majors", majorService.findAll());
        return "addStudent.html";

    }

    @PostMapping("/add")
    public String addStudentPage(@ModelAttribute("student") Student student, Model model) {
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
    public String update(@ModelAttribute("student") Student student, @ModelAttribute("major") Major major, Model model) {
        System.out.println(major.toString());
        System.out.println(student.toString());

        student.setMajor(major);
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
