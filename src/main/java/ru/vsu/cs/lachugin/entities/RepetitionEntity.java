package ru.vsu.cs.lachugin.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "repetition")
public class RepetitionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "challenge_id")
    private ChallengeEntity challenge;
    @Column(name = "count", nullable = false)
    private Long count;
    @Column(name = "date", nullable = false)
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChallengeEntity getChallenge() {
        return challenge;
    }

    public void setChallenge(ChallengeEntity challenge) {
        this.challenge = challenge;
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
