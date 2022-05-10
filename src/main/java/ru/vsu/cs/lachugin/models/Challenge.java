package ru.vsu.cs.lachugin.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

public class Challenge extends BaseModel{
    private int id;
    private int client_id;
    @NotEmpty(message = "the name of the Challenge should be")
    @Size(min = 2, max = 50, message = "The name of the Challenge must be from 2 to 50 characters.")
    private String name;
    @NotNull(message = "The number of repetitions should be")
    @Min(value = 1, message = "The number of repetitions must be greater than zero")
    private int need;
    private int days;
    private Date start_date;


    public Challenge() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNeed() {
        return need;
    }

    public void setNeed(int need) {
        this.need = need;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    }
