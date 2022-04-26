package ru.vsu.cs.lachugin.dto;

import ru.vsu.cs.lachugin.entities.ButtonEntity;
import ru.vsu.cs.lachugin.entities.RepetitionEntity;

import java.util.Date;

public class RepetitionDTO {
    private Long id;
    private Long challenge_id;
    private Long count;
    private Date date;

    public static RepetitionDTO toModel(RepetitionEntity repetitionEntity) {
        RepetitionDTO repetitionDTO = new RepetitionDTO();

        repetitionDTO.setId(repetitionEntity.getId());
        repetitionDTO.setChallenge_id(repetitionEntity.getChallenge_id());
        repetitionDTO.setCount(repetitionEntity.getCount());
        repetitionDTO.setDate(repetitionEntity.getDate());

        return repetitionDTO;
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

    public RepetitionDTO() {
    }
}
