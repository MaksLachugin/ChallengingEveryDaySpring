package ru.vsu.cs.lachugin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.lachugin.entities.ClientEntity;

public interface ClientRepo extends JpaRepository<ClientEntity, Long> {
    ClientEntity findClientEntityByName(String name);
}
