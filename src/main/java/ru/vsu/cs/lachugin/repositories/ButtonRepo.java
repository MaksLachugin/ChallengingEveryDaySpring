package ru.vsu.cs.lachugin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.lachugin.entities.ButtonEntity;
import ru.vsu.cs.lachugin.entities.ChallengeEntity;

import java.util.List;

public interface ButtonRepo extends JpaRepository<ButtonEntity, Long> {
    ButtonEntity findByName(String name);
    ButtonEntity findByNum(Long num);
    ButtonEntity findAllByNum(Long num);
    List<ButtonEntity> findAllByChallengeEntity(ChallengeEntity challengeEntity);
}
