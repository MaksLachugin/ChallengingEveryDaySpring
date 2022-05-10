package ru.vsu.cs.lachugin.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Button extends BaseModel{
    private int id;

    private int challenge_id;
    @NotEmpty(message = "the name of the button should be")
    @Size(min = 2, max = 50, message = "The name of the button must be from 2 to 50 characters.")
    private String name;
    @NotNull(message = "The number of repetitions should be")
    @Min(value = 1, message = "The number of repetitions must be greater than zero")
    private int num;

    public Button() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChallenge_id() {
        return challenge_id;
    }

    public void setChallenge_id(int challenge_id) {
        this.challenge_id = challenge_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Button{" +
                "id=" + id +
                ", challenge_id=" + challenge_id +
                ", name='" + name + '\'' +
                ", num=" + num +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Button button = (Button) o;
        return id == button.id && challenge_id == button.challenge_id && num == button.num && Objects.equals(name, button.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, challenge_id, name, num);
    }
}
