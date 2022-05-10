package ru.vsu.cs.lachugin.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.lachugin.dao.ChallengeDAO;
import ru.vsu.cs.lachugin.models.Challenge;

@RestController
@RequestMapping("/api/challenges")
public class ChallengeRestController {
    private final ChallengeDAO challengeDAO;

    @Autowired
    public ChallengeRestController(ChallengeDAO challengeDAO) {
        this.challengeDAO = challengeDAO;
    }

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(challengeDAO.index());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(challengeDAO.show(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Challenge challenge) {
        try {
            return ResponseEntity.ok(challengeDAO.save(challenge));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable int id, @RequestBody Challenge challenge) {
        try {
            return ResponseEntity.ok(challengeDAO.update(id, challenge));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        try {
            return ResponseEntity.ok(challengeDAO.delete(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }
}
