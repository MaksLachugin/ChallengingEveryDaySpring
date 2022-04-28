package ru.vsu.cs.lachugin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.lachugin.dao.ClientDAO;
import ru.vsu.cs.lachugin.dao.RepetitionDAO;
import ru.vsu.cs.lachugin.models.Client;
import ru.vsu.cs.lachugin.models.Repetition;

import javax.validation.Valid;

@Controller
@RequestMapping("/repetitions")
public class RepetitionRestController {
    private final RepetitionDAO repetitionDAO;

    @Autowired
    public RepetitionRestController(RepetitionDAO repetitionDAO) {
        this.repetitionDAO = repetitionDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("repetitions", repetitionDAO.index());
        return "repetitions/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("repetition", repetitionDAO.show(id));
        return "repetitions/show";
    }

    @GetMapping("/new")
    public String newRepetition(Model model) {
        model.addAttribute("repetition", new Repetition());
        return "repetitions/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("repetition") @Valid Repetition repetition, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "repetitions/new";
        }
        repetitionDAO.save(repetition);
        return "redirect:/repetitions";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("repetition", repetitionDAO.show(id));
        return "repetitions/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("repetition") @Valid Repetition repetition, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "repetitions/edit";
        }
        repetitionDAO.update(id, repetition);
        return "redirect:/repetitions";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        repetitionDAO.delete(id);
        return "redirect:/repetitions";
    }
}
