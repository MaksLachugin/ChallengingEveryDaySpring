package ru.vsu.cs.lachugin.services;

import ru.vsu.cs.lachugin.dto.ButtonDTO;
import ru.vsu.cs.lachugin.dto.ClientDTO;
import ru.vsu.cs.lachugin.entities.ButtonEntity;
import ru.vsu.cs.lachugin.entities.ClientEntity;

import java.util.List;

public interface ButtonService {
    ButtonDTO create(ButtonEntity buttonEntity) throws Exception;
    ButtonDTO getById(Long id) throws Exception;
    ButtonDTO edit(Long id, ButtonService buttonEntityUpdated) throws Exception;
    Long delete(Long id) throws Exception;
    List<ButtonDTO> getAll() throws Exception;
}
