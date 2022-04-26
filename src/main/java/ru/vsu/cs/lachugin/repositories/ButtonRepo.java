package ru.vsu.cs.lachugin.repositories;

import ru.vsu.cs.lachugin.entities.ButtonEntity;
import ru.vsu.cs.lachugin.entities.ChallengeEntity;

import java.util.List;

public interface ButtonRepo {
    ButtonEntity findByName(String name);
    ButtonEntity findAllByNum(Long num);
    List<ButtonEntity> findAllByChallenge(ChallengeEntity challengeEntity);
}
