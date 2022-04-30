package ru.vsu.cs.lachugin.entities;

public class ButtonEntity {
    private Long id;
    private ChallengeEntity challengeEntity;
    private String name;
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
