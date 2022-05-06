package ru.vsu.cs.lachugin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vsu.cs.lachugin.dto.ChallengeDTO;
import ru.vsu.cs.lachugin.entities.ChallengeEntity;
import ru.vsu.cs.lachugin.entities.ClientEntity;
import ru.vsu.cs.lachugin.repositories.ChallengeRepo;
import ru.vsu.cs.lachugin.repositories.ClientRepo;
import ru.vsu.cs.lachugin.services.ChallengeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeServiceImpl implements ChallengeService {

    private final ChallengeRepo challengeRepo;
    private final ClientRepo clientRepo;

    @Autowired
    public ChallengeServiceImpl(ChallengeRepo challengeRepo, ClientRepo clientRepo) {
        this.challengeRepo = challengeRepo;
        this.clientRepo = clientRepo;
    }


    @Transactional
    @Override
    public ChallengeDTO create(ChallengeEntity challengeEntity) throws Exception {
        return ChallengeDTO.toModel(challengeRepo.save(challengeEntity));
    }

    @Transactional
    @Override
    public ChallengeDTO getById(Long id) throws Exception {
        return ChallengeDTO.toModel(challengeRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого вызова не существует")));
    }

    @Transactional
    @Override
    public ChallengeDTO edit(Long id, ChallengeEntity challengeEntityUpdated) throws Exception {
        ChallengeEntity challengeEntity = challengeRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого доктора не существует"));
        clientRepo.findById(challengeEntityUpdated.getClient().getId())
                .orElseThrow(() -> new Exception("Такого клиента не существует"));

        challengeEntity.setName(challengeEntityUpdated.getName());
        challengeEntity.setClient(challengeEntityUpdated.getClient());
        challengeEntity.setNeed(challengeEntityUpdated.getNeed());
        challengeEntity.setDays(challengeEntityUpdated.getDays());
        challengeEntity.setStartDate(challengeEntityUpdated.getStartDate());

        return ChallengeDTO.toModel(challengeRepo.save(challengeEntity));
    }

    @Transactional
    @Override
    public Long delete(Long id) throws Exception {
        ChallengeEntity challengeEntity = challengeRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого вызова не существует"));
        challengeRepo.delete(challengeEntity);
        return id;
    }

    @Transactional
    @Override
    public List<ChallengeDTO> getAll() throws Exception {
        List<ChallengeEntity> challengeEntities = challengeRepo.findAll();
        List<ChallengeDTO> challengeDTOS = new ArrayList<>();
        for (ChallengeEntity challengeEntity : challengeEntities) {
            challengeDTOS.add(ChallengeDTO.toModel(challengeEntity));
        }
        return challengeDTOS;
    }

    @Transactional
    @Override
    public List<ChallengeDTO> getAllByClient(ClientEntity clientEntity) throws Exception {
        List<ChallengeEntity> challengeEntities = challengeRepo.findAllByClient(clientEntity);
        List<ChallengeDTO> challengeDTOS = new ArrayList<>();
        for (ChallengeEntity challengeEntity : challengeEntities) {
            challengeDTOS.add(ChallengeDTO.toModel(challengeEntity));
        }
        return challengeDTOS;
    }
}
