package ru.vsu.cs.lachugin.dto;

import ru.vsu.cs.lachugin.entities.ButtonEntity;

public class ButtonDTO {
    private Long id;
    private ChallengeDTO challengeDTO;
    private String name;
    private Long num;

    public static ButtonDTO toModel(ButtonEntity buttonEntity) {
        ButtonDTO buttonDTO = new ButtonDTO();
        buttonDTO.setId(buttonEntity.getId());
        buttonDTO.setChallengeDTO(ChallengeDTO.toModel(buttonEntity.getChallengeEntity()));
        buttonDTO.setName(buttonEntity.getName());
        buttonDTO.setNum(buttonEntity.getNum());
        return buttonDTO;
    }

    public ButtonDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChallengeDTO getChallengeDTO() {
        return challengeDTO;
    }

    public void setChallengeDTO(ChallengeDTO challengeDTO) {
        this.challengeDTO = challengeDTO;
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
