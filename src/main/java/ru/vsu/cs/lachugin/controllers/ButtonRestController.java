package ru.vsu.cs.lachugin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.lachugin.entities.ButtonEntity;
import ru.vsu.cs.lachugin.services.ButtonService;
@RestController
@RequestMapping("/api/buttons")
public class ButtonRestController {
    private final ButtonService buttonService;

    @Autowired
    public ButtonRestController(ButtonService buttonService) {
        this.buttonService = buttonService;
    }

    @GetMapping
    public ResponseEntity getAll(){
        try{
            return ResponseEntity.ok(buttonService.getAll());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(buttonService.getById(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ButtonEntity buttonEntity){
        try {
            return ResponseEntity.ok(buttonService.create(buttonEntity));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable Long id, @RequestBody ButtonEntity buttonEntity){
        try {
            return ResponseEntity.ok(buttonService.edit(id, buttonEntity));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            return ResponseEntity.ok(buttonService.delete(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }
}
