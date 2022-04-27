package ru.vsu.cs.lachugin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.lachugin.dao.ButtonDAO;
import ru.vsu.cs.lachugin.models.Button;

import javax.validation.Valid;

@Controller
@RequestMapping("/buttons")
public class ButtonRestController {
    private final ButtonDAO buttonDAO;

    @Autowired
    public ButtonRestController(ButtonDAO buttonDAO) {
        this.buttonDAO = buttonDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("buttons", buttonDAO.index());
        return "buttons/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("button", buttonDAO.show(id));
        return "buttons/show";
    }

    @GetMapping("/new")
    public String newButton(Model model) {
        model.addAttribute("button", new Button());
        return "buttons/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("button") @Valid Button button, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "buttons/new";
        }
        buttonDAO.save(button);
        return "redirect:/buttons";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("button", buttonDAO.show(id));
        return "buttons/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("button") @Valid Button button, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "buttons/edit";
        }
        buttonDAO.update(id, button);
        return "redirect:/buttons";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        buttonDAO.delete(id);
        return "redirect:/buttons";
    }

}
