package ru.vsu.cs.lachugin.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Client extends BaseModel{
    private int id;
    @NotEmpty(message = "the name of the Client should be")
    @Size(min = 2, max = 50, message = "The name of the Client must be from 2 to 50 characters.")
    private String name;
    @NotEmpty(message = "the password of the Client should be")
    @Size(min = 2, max = 50, message = "The password of the Client must be from 2 to 50 characters.")
    private String pass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(name, client.name) && Objects.equals(pass, client.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pass);
    }
}
