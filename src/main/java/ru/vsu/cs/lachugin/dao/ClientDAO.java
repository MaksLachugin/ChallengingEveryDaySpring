package ru.vsu.cs.lachugin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.vsu.cs.lachugin.models.Button;
import ru.vsu.cs.lachugin.models.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClientDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Client> index() {
        return jdbcTemplate.query("SELECT * FROM \"Client\"",
                new BeanPropertyRowMapper<>(Client.class));
    }

    public Client show(int id) {
        return jdbcTemplate.query("SELECT * FROM \"Client\" Where id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Client.class)).stream().findAny().orElse(null);
    }

    public void save(Client client) {
        jdbcTemplate.update("INSERT INTO \"Client\" VALUES (DEFAULT, ?, ?)",
                client.getName(), client.getPass());
    }

    public void update(int id, Client updatedClient) {
        jdbcTemplate.update("UPDATE  \"Client\" Set name=?,pass=? where id=?",
                updatedClient.getName(), updatedClient.getPass(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM \"Client\" where id=?", id);
    }
}