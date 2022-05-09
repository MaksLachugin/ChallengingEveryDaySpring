package ru.vsu.cs.lachugin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.lachugin.dao.ChallengeDAO;
import ru.vsu.cs.lachugin.models.Challenge;

import javax.validation.Valid;

@Controller
@RequestMapping("/challenges")
public class ChallengeController {

    private final ChallengeDAO challengeDAO;

    @Autowired
    public ChallengeController(ChallengeDAO challengeDAO) {
        this.challengeDAO = challengeDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("challenges", challengeDAO.index());
        return "challenges/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("challenge", challengeDAO.show(id));
        return "challenges/show";
    }

    @GetMapping("/new")
    public String newChallenge(Model model) {
        model.addAttribute("challenge", new Challenge());
        return "challenges/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("challenge") @Valid Challenge challenge, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "challenges/new";
        }
        challengeDAO.save(challenge);
        return "redirect:/challenges";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("challenge", challengeDAO.show(id));
        return "challenges/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("button") @Valid Challenge challenge, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "challenges/edit";
        }
        challengeDAO.update(id, challenge);
        return "redirect:/challenges";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        challengeDAO.delete(id);
        return "redirect:/challenges";
    }
}
