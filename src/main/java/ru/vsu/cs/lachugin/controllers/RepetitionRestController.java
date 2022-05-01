package ru.vsu.cs.lachugin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.lachugin.entities.RepetitionEntity;
import ru.vsu.cs.lachugin.services.RepetitionService;
@RestController
@RequestMapping("/api/repetitions")
public class RepetitionRestController {

    private final RepetitionService repetitionService;

    @Autowired
    public RepetitionRestController(RepetitionService repetitionService) {
        this.repetitionService = repetitionService;
    }

    @GetMapping
    public ResponseEntity getAll(){
        try{
            return ResponseEntity.ok(repetitionService.getAll());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(repetitionService.getById(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody RepetitionEntity repetitionEntity){
        try {
            return ResponseEntity.ok(repetitionService.create(repetitionEntity));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable Long id, @RequestBody RepetitionEntity repetitionEntity){
        try {
            return ResponseEntity.ok(repetitionService.edit(id, repetitionEntity));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            return ResponseEntity.ok(repetitionService.delete(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }
}
