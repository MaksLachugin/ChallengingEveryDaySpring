package ru.vsu.cs.lachugin.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class Repetition {
    private Long id;
    private Long challenge_id;
    @NotNull(message = "The number of repetitions should be")
    @Min(value = 1, message = "The number of repetitions must be greater than zero")
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
