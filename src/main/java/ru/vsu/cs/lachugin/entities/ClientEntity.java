package ru.vsu.cs.lachugin.entities;

import ru.vsu.cs.lachugin.services.ClientService;

public class ClientEntity {
    private Long id;
    private String name;
    private String pass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public ClientEntity() {
    }
}
