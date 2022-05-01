package ru.vsu.cs.lachugin.entities;

import javax.persistence.*;
@Entity
@Table(name = "buttons")
public class ButtonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "challenge_id")
    private ChallengeEntity challengeEntity;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "num", nullable = false)
    private Long num;

    public ButtonEntity() {
    }

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
