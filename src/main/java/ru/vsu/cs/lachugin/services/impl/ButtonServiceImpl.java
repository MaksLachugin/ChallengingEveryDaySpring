package ru.vsu.cs.lachugin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vsu.cs.lachugin.dto.ButtonDTO;
import ru.vsu.cs.lachugin.entities.ButtonEntity;
import ru.vsu.cs.lachugin.entities.ChallengeEntity;
import ru.vsu.cs.lachugin.repositories.ButtonRepo;
import ru.vsu.cs.lachugin.repositories.ChallengeRepo;
import ru.vsu.cs.lachugin.services.ButtonService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ButtonServiceImpl implements ButtonService {
    private final ButtonRepo buttonRepo;
    private final ChallengeRepo challengeRepo;

    @Autowired
    public ButtonServiceImpl(ButtonRepo buttonRepo, ChallengeRepo challengeRepo) {
        this.buttonRepo = buttonRepo;
        this.challengeRepo = challengeRepo;
    }

    @Transactional
    @Override
    public ButtonDTO create(ButtonEntity buttonEntity) throws Exception {
        return ButtonDTO.toModel(buttonRepo.save(buttonEntity));
    }

    @Transactional
    @Override
    public ButtonDTO getById(Long id) throws Exception {
        return ButtonDTO.toModel(buttonRepo.findById(id)
                .orElseThrow(() -> new Exception("Такой кнопки не существует")));
    }

    @Transactional
    @Override
    public ButtonDTO edit(Long id, ButtonEntity buttonEntityUpdated) throws Exception {
        ButtonEntity buttonEntity = buttonRepo.findById(id)
                .orElseThrow(() -> new Exception("Такой кнопки не существует"));
        challengeRepo.findById(buttonEntityUpdated.getChallengeEntity().getId())
                .orElseThrow(() -> new Exception("Такого вызова не существует"));

        buttonEntity.setName(buttonEntityUpdated.getName());
        buttonEntity.setNum(buttonEntityUpdated.getNum());
        buttonEntity.setChallengeEntity(buttonEntityUpdated.getChallengeEntity());

        return ButtonDTO.toModel(buttonRepo.save(buttonEntity));
    }

    @Transactional
    @Override
    public Long delete(Long id) throws Exception {
        ButtonEntity buttonEntity = buttonRepo.findById(id)
                .orElseThrow(() -> new Exception("Такой кнопки не существует"));
        buttonRepo.delete(buttonEntity);
        return id;
    }

    @Transactional
    @Override
    public List<ButtonDTO> getAll() throws Exception {
        List<ButtonEntity> buttonEntities = buttonRepo.findAll();
        List<ButtonDTO> ButtonDTOS = new ArrayList<>();
        for (ButtonEntity buttonEntity : buttonEntities) {
            ButtonDTOS.add(ButtonDTO.toModel(buttonEntity));
        }
        return ButtonDTOS;
    }

    @Transactional
    @Override
    public List<ButtonDTO> getAllByChallenge(ChallengeEntity challengeEntity) throws Exception {
        List<ButtonEntity> buttonEntities = buttonRepo.findAllByChallengeEntity(challengeEntity);
        List<ButtonDTO> ButtonDTOS = new ArrayList<>();
        for (ButtonEntity buttonEntity : buttonEntities) {
            ButtonDTOS.add(ButtonDTO.toModel(buttonEntity));
        }
        return ButtonDTOS;
    }
}
