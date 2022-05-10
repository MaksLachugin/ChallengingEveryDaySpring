package ru.vsu.cs.lachugin.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Objects;

public class Repetition extends BaseModel {
    private int id;
    private int challenge_id;
    @NotNull(message = "The number of repetitions should be")
    @Min(value = 1, message = "The number of repetitions must be greater than zero")
    private int count;
    private Date date;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
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

    @Override
    public String toString() {
        return "Repetition{" +
                "id=" + id +
                ", challenge_id=" + challenge_id +
                ", count=" + count +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repetition that = (Repetition) o;
        return id == that.id && challenge_id == that.challenge_id && count == that.count && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, challenge_id, count, date);
    }
}
