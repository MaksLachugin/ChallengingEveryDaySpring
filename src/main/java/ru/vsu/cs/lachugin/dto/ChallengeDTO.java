package ru.vsu.cs.lachugin.dto;

import ru.vsu.cs.lachugin.entities.ChallengeEntity;

import java.util.Date;

public class ChallengeDTO {
    private Long id;
    private ClientDTO clientDTO;
    private String name;
    private Long need;
    private Long days;
    private Date startDate;

    public static ChallengeDTO toModel(ChallengeEntity challengeEntity) {
        ChallengeDTO challengeDTO = new ChallengeDTO();
        challengeDTO.setId(challengeEntity.getId());
        challengeDTO.setClientDTO(ClientDTO.toModel(challengeEntity.getClientEntity()));
        challengeDTO.setName(challengeEntity.getName());
        challengeDTO.setNeed(challengeEntity.getNeed());
        challengeDTO.setDays(challengeEntity.getDays());
        challengeDTO.setStartDate(challengeEntity.getStartDate());

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

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
