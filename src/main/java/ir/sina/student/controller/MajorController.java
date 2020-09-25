package ir.sina.student.controller;

import ir.sina.student.model.Major;
import ir.sina.student.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MajorController {

    private MajorService majorService;

    @Autowired
    public MajorController(MajorService majorService){
        this.majorService = majorService;
    }

    @RequestMapping("/add-major")
    public String addStudentPage(Model model, Major major) {
        model.addAttribute("student", major);
        return "addMajor.html";

    }

}
