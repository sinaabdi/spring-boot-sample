package ir.sina.student.controller;

import com.google.gson.Gson;
import ir.sina.student.model.Major;
import ir.sina.student.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("major")
public class MajorController {
    @Autowired
    private MajorService majorService;

    @RequestMapping("list")
    public String majorList(Model model) {
        return new Gson().toJson(majorService.findAll());
    }

    @RequestMapping("/add")
    public String addStudentPage(@RequestBody Major major) {
        majorService.save(major);
        return new Gson().toJson(majorService.findAll());
    }

    @RequestMapping("delete/{id}")
    public String deleteMajor(@PathVariable int id) {
        majorService.deleteById(id);

        return new Gson().toJson(majorService.findAll());
    }

}
