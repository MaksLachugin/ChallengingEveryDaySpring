package ru.vsu.cs.lachugin.dto;

import ru.vsu.cs.lachugin.entities.ChallengeEntity;
import ru.vsu.cs.lachugin.entities.ClientEntity;

public class ClientDTO {
    private Long id;
    private String name;

    public static ClientDTO toModel(ClientEntity clientEntity) {
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId(clientEntity.getId());
        clientDTO.setName(clientEntity.getName());

        return clientDTO;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientDTO() {
    }
}
