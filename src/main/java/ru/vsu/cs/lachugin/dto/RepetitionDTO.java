package ru.vsu.cs.lachugin.dto;

import ru.vsu.cs.lachugin.entities.RepetitionEntity;
import java.sql.Date;

public class RepetitionDTO {
    private Long id;
    private ChallengeDTO challengeDTO;
    private Long count;
    private Date date;

    public static RepetitionDTO toModel(RepetitionEntity repetitionEntity) {
        RepetitionDTO repetitionDTO = new RepetitionDTO();

        repetitionDTO.setId(repetitionEntity.getId());
        repetitionDTO.setChallengeDTO(ChallengeDTO.toModel(repetitionEntity.getChallenge()));
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

    public ChallengeDTO getChallengeDTO() {
        return challengeDTO;
    }

    public void setChallengeDTO(ChallengeDTO challengeDTO) {
        this.challengeDTO = challengeDTO;
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
