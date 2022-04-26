package ru.vsu.cs.lachugin.models;

public class Button {
    private Long id;
    private Long challenge_id;
    private String name;
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
