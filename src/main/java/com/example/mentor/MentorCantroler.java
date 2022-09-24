package com.example.mentor;

import com.example.unversty.UnverstiyDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mentors")
public class MentorCantroler {
    private final UnverstiyDao unverstiyDao;
    private final MentorDao mentorDao;
    @GetMapping
    public String show_mantors(Model model){
        model.addAttribute("mentors",mentorDao.allmentors());
        System.out.println(mentorDao.allmentors());
        return "view_mentor";
    }
    @GetMapping("add_mentor")
    public String add_mentor_from(Model model){
        model.addAttribute("unvers" ,unverstiyDao.all_unver());

        return "add_form_mentor";
    }

    @PostMapping
      public String add_mentor(Mentor mentor){
        mentorDao.save(mentor);
        return "redirect:/mentors";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("mentor",mentorDao.mentorById(id).get(0));
        model.addAttribute("unver",unverstiyDao.all_unver());
        return "edit_from_mentor";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        mentorDao.delete(id);
        return "redirect:/mentors";
    }

}
