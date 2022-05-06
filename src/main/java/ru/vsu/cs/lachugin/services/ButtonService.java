package ru.vsu.cs.lachugin.services;

import ru.vsu.cs.lachugin.dto.ButtonDTO;
import ru.vsu.cs.lachugin.entities.ButtonEntity;
import ru.vsu.cs.lachugin.entities.ChallengeEntity;

import java.util.List;

public interface ButtonService {
    ButtonDTO create(ButtonEntity buttonEntity) throws Exception;

    ButtonDTO getById(Long id) throws Exception;

    ButtonDTO edit(Long id, ButtonEntity buttonEntityUpdated) throws Exception;

    Long delete(Long id) throws Exception;

    List<ButtonDTO> getAll() throws Exception;

    List<ButtonDTO> getAllByChallenge(ChallengeEntity challengeEntity) throws Exception;
}
