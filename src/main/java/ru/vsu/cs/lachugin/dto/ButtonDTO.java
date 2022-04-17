package ru.vsu.cs.lachugin.dto;

import ru.vsu.cs.lachugin.entities.ButtonEntity;

import java.util.Set;

public class ButtonDTO {
    private Long id;
    private Long challenge_id;
    private String name;
    private Long num;

    public static ButtonDTO toModel(ButtonEntity buttonEntity) {
        ButtonDTO buttonDTO = new ButtonDTO();
        buttonDTO.setId(buttonEntity.getId());
        buttonDTO.setChallenge_id(buttonEntity.getChallenge_id());
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

    public Long getChallenge_id() {
        return challenge_id;
    }

    public void setChallenge_id(Long challenge_id) {
        this.challenge_id = challenge_id;
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
