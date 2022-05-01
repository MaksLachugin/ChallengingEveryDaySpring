package ru.vsu.cs.lachugin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.lachugin.entities.ButtonEntity;
import ru.vsu.cs.lachugin.entities.ChallengeEntity;
import ru.vsu.cs.lachugin.entities.ClientEntity;

import java.sql.Date;
import java.util.List;

public interface ChallengeRepo extends JpaRepository<ChallengeEntity, Long> {

    List<ChallengeEntity> findAllByClient(ClientEntity clientEntity);
    List<ChallengeEntity> findAllByName(String name);
    List<ChallengeEntity> findAllByNeed(Long need);
    List<ChallengeEntity> findAllByDays(Long days);
    List<ChallengeEntity> findAllByStartDate(Date startDate);
}
