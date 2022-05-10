package ru.vsu.cs.lachugin.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.lachugin.dao.RepetitionDAO;
import ru.vsu.cs.lachugin.models.Repetition;

@RestController
@RequestMapping("/api/repetitions")
public class RepetitionRestController {

    private final RepetitionDAO repetitionDAO;

    @Autowired
    public RepetitionRestController(RepetitionDAO repetitionDAO) {
        this.repetitionDAO = repetitionDAO;
    }

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(repetitionDAO.index());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(repetitionDAO.show(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Repetition repetition) {
        try {
            return ResponseEntity.ok(repetitionDAO.save(repetition));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable int id, @RequestBody Repetition repetition) {
        try {
            return ResponseEntity.ok(repetitionDAO.update(id, repetition));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        try {
            return ResponseEntity.ok(repetitionDAO.delete(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }
}
