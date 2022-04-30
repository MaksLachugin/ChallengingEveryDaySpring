package ru.vsu.cs.lachugin.entities;

import java.sql.Date;

public class RepetitionEntity {
    private Long id;
    private ChallengeEntity challengeEntity;
    private Long count;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChallengeEntity getChallengeEntity() {
        return challengeEntity;
    }

    public void setChallengeEntity(ChallengeEntity challengeEntity) {
        this.challengeEntity = challengeEntity;
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

    public RepetitionEntity() {
    }
}
