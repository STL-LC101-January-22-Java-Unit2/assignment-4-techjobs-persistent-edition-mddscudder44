package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "All Skills");
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSKill,
                                      Errors errors, Model model) {
        if(errors.hasErrors()) {
            return "skills/add";
        }
        skillRepository.save(newSKill);
        return "redirect:";
    }

    @GetMapping("view/{employerId}")
    public String displayViewSkill(Model model, @PathVariable int employerId) {
        Optional optEmployer = skillRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Skill employer = (Skill) optEmployer.get();
            model.addAttribute("skill", employer);
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }


}
