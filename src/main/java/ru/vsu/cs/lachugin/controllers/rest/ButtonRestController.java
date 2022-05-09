package ru.vsu.cs.lachugin.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.lachugin.dao.ButtonDAO;
import ru.vsu.cs.lachugin.models.Button;

import java.util.List;

@RestController
@RequestMapping("/api/buttons")
public class ButtonRestController {
    private final ButtonDAO buttonDAO;

    @Autowired
    public ButtonRestController(ButtonDAO buttonDAO) {
        this.buttonDAO = buttonDAO;
    }

    @GetMapping

    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(buttonDAO.index());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(buttonDAO.show(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Button button) {
        try {
            return ResponseEntity.ok(buttonDAO.save(button));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable int id, @RequestBody Button button) {
        try {

            return ResponseEntity.ok(buttonDAO.update(id, button));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        try {
            return ResponseEntity.ok(buttonDAO.delete(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }
}