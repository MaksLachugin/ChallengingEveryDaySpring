package ru.vsu.cs.lachugin.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Button {
    private Long id;

    private Long challenge_id;
    @NotEmpty(message = "the name of the button should be")
    @Size(min = 2, max = 50, message = "The name of the button must be from 2 to 50 characters.")
    private String name;
    @NotNull(message = "The number of repetitions should be")
    @Min(value = 1, message = "The number of repetitions must be greater than zero")
    private Long num;

    public Button() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChallenge_id() {
        return challenge_id;
    }

    public void setChallenge_id(Long challenge_id) {
        this.challenge_id = challenge_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}
