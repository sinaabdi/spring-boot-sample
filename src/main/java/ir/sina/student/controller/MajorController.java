package ir.sina.student.controller;

import ir.sina.student.model.Major;
import ir.sina.student.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MajorController {
    @Autowired
    private MajorService majorService;

    @RequestMapping("major/list")
    public String majorList(Model model) {
        model.addAttribute("majors", majorService.findAll());

        return "majorsList.html";
    }

    @RequestMapping("/add-major")
    public String addStudentPage(Model model, Major major) {
        model.addAttribute("student", major);
        return "addMajor.html";
    }

    @RequestMapping("/major/update")
    public String addMajor(Major major, Model model){
        majorService.save(major);
        model.addAttribute("majors", majorService.findAll());
        return "redirect:/major/list";
    }

    @RequestMapping("major/delete/{id}")
    public String deleteMajor(@PathVariable int id, Model model) {
        majorService.deleteById(id);
        model.addAttribute("majors", majorService.findAll());

        return "redirect:/major/list";
    }

}
