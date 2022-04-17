package ru.vsu.cs.lachugin.dto;

import ru.vsu.cs.lachugin.entities.ButtonEntity;
import ru.vsu.cs.lachugin.entities.ChallengeEntity;

import java.util.Date;

public class ChallengeDTO {
    private Long id;
    private Long user_id;
    private String name;
    private Long need;
    private Long days;
    private Date start_date;
    private Date finish_date;

    public static ChallengeDTO toModel(ChallengeEntity challengeEntity) {
        ChallengeDTO challengeDTO = new ChallengeDTO();
        challengeDTO.setId(challengeEntity.getId());
        challengeDTO.setUser_id(challengeEntity.getUser_id());
        challengeDTO.setName(challengeEntity.getName());
        challengeDTO.setNeed(challengeEntity.getNeed());
        challengeDTO.setDays(challengeEntity.getDays());
        challengeDTO.setStart_date(challengeEntity.getStart_date());
        challengeDTO.setFinish_date(challengeEntity.getFinish_date());
        return challengeDTO;
    }

    public ChallengeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNeed() {
        return need;
    }

    public void setNeed(Long need) {
        this.need = need;
    }

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(Date finish_date) {
        this.finish_date = finish_date;
    }
}
