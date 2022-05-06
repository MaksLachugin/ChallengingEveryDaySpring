package ru.vsu.cs.lachugin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vsu.cs.lachugin.dto.ClientDTO;
import ru.vsu.cs.lachugin.entities.ClientEntity;
import ru.vsu.cs.lachugin.repositories.ClientRepo;
import ru.vsu.cs.lachugin.services.ClientService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;

    @Autowired
    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Transactional
    @Override
    public ClientDTO create(ClientEntity clientEntity) throws Exception {
        return ClientDTO.toModel(clientRepo.save(clientEntity));
    }

    @Transactional
    @Override
    public ClientDTO getById(Long id) throws Exception {
        return ClientDTO.toModel(clientRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого клиента не существует")));
    }

    @Transactional
    @Override
    public ClientDTO edit(Long id, ClientEntity clientEntityUpdated) throws Exception {
        ClientEntity clientEntity = clientRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого клиента не существует"));

        clientEntity.setName(clientEntityUpdated.getName());
        clientEntity.setPass(clientEntityUpdated.getPass());

        return ClientDTO.toModel(clientRepo.save(clientEntity));
    }

    @Transactional
    @Override
    public Long delete(Long id) throws Exception {
        ClientEntity buttonEntity = clientRepo.findById(id)
                .orElseThrow(() -> new Exception("Такого пользователя не существует"));
        clientRepo.delete(buttonEntity);
        return id;
    }

    @Transactional
    @Override
    public List<ClientDTO> getAll() throws Exception {
        List<ClientEntity> clientEntities = clientRepo.findAll();
        List<ClientDTO> clientDTOS = new ArrayList<>();
        for (ClientEntity clientEntity : clientEntities) {
            clientDTOS.add(ClientDTO.toModel(clientEntity));
        }
        return clientDTOS;
    }
}
