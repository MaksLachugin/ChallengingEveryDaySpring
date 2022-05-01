package ru.vsu.cs.lachugin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.lachugin.entities.ClientEntity;
import ru.vsu.cs.lachugin.entities.RepetitionEntity;
import ru.vsu.cs.lachugin.services.ClientService;
import ru.vsu.cs.lachugin.services.RepetitionService;
@RestController
@RequestMapping("/api/clients")
public class ClientRestController {
    private final ClientService clientService;

    @Autowired
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity getAll(){
        try{
            return ResponseEntity.ok(clientService.getAll());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(clientService.getById(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ClientEntity clientEntity){
        try {
            return ResponseEntity.ok(clientService.create(clientEntity));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable Long id, @RequestBody ClientEntity clientEntity){
        try {
            return ResponseEntity.ok(clientService.edit(id, clientEntity));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            return ResponseEntity.ok(clientService.delete(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }
}
