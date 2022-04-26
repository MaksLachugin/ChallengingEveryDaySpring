package ru.vsu.cs.lachugin.models;

import java.util.Date;

public class Repetition {
    private Long id;
    private Long challenge_id;
    private Long count;
    private Date date;

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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Repetition() {
    }
}
