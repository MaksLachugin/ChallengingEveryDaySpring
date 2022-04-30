package ru.vsu.cs.lachugin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.lachugin.entities.ChallengeEntity;
import ru.vsu.cs.lachugin.entities.RepetitionEntity;

import java.sql.Date;
import java.util.List;

public interface RepetitionRepo extends JpaRepository<RepetitionEntity, Long> {
    List<RepetitionEntity> findAllByChallengeEntity(ChallengeEntity challengeEntity);
    List<RepetitionEntity> findAllByCount(Long count);
    List<RepetitionEntity> findAllByDate(Date date);
}
