package ru.vsu.cs.lachugin.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Client {
    private Long id;
    @NotEmpty(message = "the name of the Client should be")
    @Size(min = 2, max = 50, message = "The name of the Client must be from 2 to 50 characters.")
    private String name;
    @NotEmpty(message = "the password of the Client should be")
    @Size(min = 2, max = 50, message = "The password of the Client must be from 2 to 50 characters.")
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

    public Client() {
    }
}
