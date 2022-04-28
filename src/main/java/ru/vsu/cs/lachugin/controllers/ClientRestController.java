package ru.vsu.cs.lachugin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.lachugin.dao.ClientDAO;
import ru.vsu.cs.lachugin.models.Client;

import javax.validation.Valid;

@Controller
@RequestMapping("/clients")
public class ClientRestController {

    private final ClientDAO clientDAO;

    @Autowired
    public ClientRestController(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("clients", clientDAO.index());
        return "clients/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("client", clientDAO.show(id));
        return "clients/show";
    }

    @GetMapping("/new")
    public String newChallenge(Model model) {
        model.addAttribute("client", new Client());
        return "clients/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("client") @Valid Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "clients/new";
        }
        clientDAO.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("client", clientDAO.show(id));
        return "clients/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("client") @Valid Client client, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "clients/edit";
        }
        clientDAO.update(id, client);
        return "redirect:/clients";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        clientDAO.delete(id);
        return "redirect:/clients";
    }

}