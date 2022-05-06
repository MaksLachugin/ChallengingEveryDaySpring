package ru.vsu.cs.lachugin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vsu.cs.lachugin.dto.RepetitionDTO;
import ru.vsu.cs.lachugin.entities.ChallengeEntity;
import ru.vsu.cs.lachugin.entities.ClientEntity;
import ru.vsu.cs.lachugin.entities.RepetitionEntity;
import ru.vsu.cs.lachugin.repositories.ChallengeRepo;
import ru.vsu.cs.lachugin.repositories.RepetitionRepo;
import ru.vsu.cs.lachugin.services.RepetitionService;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepetitionServiceImpl implements RepetitionService {
    private final RepetitionRepo repetitionRepo;
    private final ChallengeRepo challengeRepo;

    @Autowired
    public RepetitionServiceImpl(RepetitionRepo repetitionRepo, ChallengeRepo challengeRepo) {
        this.repetitionRepo = repetitionRepo;
        this.challengeRepo = challengeRepo;
    }

    @Transactional
    @Override
    public RepetitionDTO create(RepetitionEntity repetitionEntity) throws Exception {
        return RepetitionDTO.toModel(repetitionRepo.save(repetitionEntity));
    }

    @Transactional
    @Override
    public RepetitionDTO getById(Long id) throws Exception {
        return RepetitionDTO.toModel(repetitionRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого подхода не существует")));
    }

    @Transactional
    @Override
    public RepetitionDTO edit(Long id, RepetitionEntity repetitionEntityUpdated) throws Exception {
        RepetitionEntity repetitionEntity = repetitionRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого подхода не существует"));

        repetitionEntity.setCount(repetitionEntityUpdated.getCount());
        repetitionEntity.setDate(repetitionEntityUpdated.getDate());

        return RepetitionDTO.toModel(repetitionRepo.save(repetitionEntity));
    }

    @Transactional
    @Override
    public Long delete(Long id) throws Exception {
        RepetitionEntity repetitionEntity = repetitionRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого подхода не существует"));
        repetitionRepo.delete(repetitionEntity);
        return id;
    }

    @Transactional
    @Override
    public List<RepetitionDTO> getAll() throws Exception {
        List<RepetitionEntity> repetitionEntities = repetitionRepo.findAll();
        List<RepetitionDTO> repetitionDTOS = new ArrayList<>();
        for (RepetitionEntity repetitionEntity : repetitionEntities) {
            repetitionDTOS.add(RepetitionDTO.toModel(repetitionEntity));
        }
        return repetitionDTOS;
    }

    @Transactional
    @Override
    public List<RepetitionDTO> getAllByChallenge(ChallengeEntity challengeEntity) throws Exception {
        List<RepetitionEntity> repetitionEntities = repetitionRepo.findAllByChallengeEntity(challengeEntity);
        List<RepetitionDTO> repetitionDTOS = new ArrayList<>();
        for (RepetitionEntity repetitionEntity : repetitionEntities) {
            repetitionDTOS.add(RepetitionDTO.toModel(repetitionEntity));
        }
        return repetitionDTOS;
    }

    @Transactional
    @Override
    public List<RepetitionDTO> getAllByClient(ClientEntity clientEntity) throws Exception {
        List<ChallengeEntity> challengeEntities = challengeRepo.findAllByClient(clientEntity);
        List<RepetitionEntity> repetitionEntities = new ArrayList<>();
        for (ChallengeEntity challengeEntity : challengeEntities) {
            repetitionEntities.addAll(repetitionRepo.findAllByChallengeEntity(challengeEntity));
        }
        List<RepetitionDTO> repetitionDTOS = new ArrayList<>();
        for (RepetitionEntity repetitionEntity : repetitionEntities) {
            repetitionDTOS.add(RepetitionDTO.toModel(repetitionEntity));
        }
        return repetitionDTOS;
    }
}
