package ru.vsu.cs.lachugin.services;

import ru.vsu.cs.lachugin.dto.RepetitionDTO;
import ru.vsu.cs.lachugin.entities.ChallengeEntity;
import ru.vsu.cs.lachugin.entities.ClientEntity;
import ru.vsu.cs.lachugin.entities.RepetitionEntity;

import java.util.List;

public interface RepetitionService {
    RepetitionDTO create(RepetitionEntity repetitionEntity) throws Exception;

    RepetitionDTO getById(Long id) throws Exception;

    RepetitionDTO edit(Long id, RepetitionEntity repetitionEntityUpdated) throws Exception;

    Long delete(Long id) throws Exception;

    List<RepetitionDTO> getAll() throws Exception;

    List<RepetitionDTO> getAllByChallenge(ChallengeEntity challengeEntity) throws Exception;


    List<RepetitionDTO> getAllByClient(ClientEntity clientEntity) throws Exception;


}
