package ru.vsu.cs.lachugin.services;

import ru.vsu.cs.lachugin.dto.ChallengeDTO;
import ru.vsu.cs.lachugin.dto.ClientDTO;
import ru.vsu.cs.lachugin.entities.ChallengeEntity;
import ru.vsu.cs.lachugin.entities.ClientEntity;

import java.util.List;

public interface ChallengeService {
    ChallengeDTO create(ChallengeEntity challengeEntity) throws Exception;

    ChallengeDTO getById(Long id) throws Exception;

    ChallengeDTO edit(Long id, ChallengeEntity challengeEntityUpdated) throws Exception;

    Long delete(Long id) throws Exception;

    List<ChallengeDTO> getAll() throws Exception;

    List<ChallengeDTO> getAllByClient(ClientEntity clientEntity) throws Exception;
}
