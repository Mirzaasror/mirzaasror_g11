package com.example.studen;

import com.example.mentor.Mentor;
import com.example.mentor.MentorDao;
//import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentCantroller {
    private final StudentDao studentDao;
    private final MentorDao mentorDao;
    @GetMapping
public String show_student(Model model){
        model.addAttribute("studentlar",studentDao.all_student());

        return "view_student";

    }
    @GetMapping("/add-student")
    public String add_form(Model model){
        model.addAttribute("mentor",mentorDao.allmentor());

        System.out.println(mentorDao.allmentor());
        return "add_form";

    }

    @PostMapping
    public String add_save(Student student){
        System.out.println(student);
        studentDao.save(student);
        return "redirect:/students";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("student",studentDao.studentById(id).get(0));
        model.addAttribute("mentor",mentorDao.allmentor());
        return "edit_from";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        studentDao.delete(id);
        return "redirect:/students";
    }
    @PostMapping("save")

    public String edit_save(Mentor mentor){
        mentorDao.editsave(mentor);
        return "redirect:/mentors";
    }
}
