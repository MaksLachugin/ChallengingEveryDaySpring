package ru.vsu.cs.lachugin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.vsu.cs.lachugin.models.Button;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ButtonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ButtonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Button> index() {

        return jdbcTemplate.query("SELECT * FROM \"Button\"",
                new BeanPropertyRowMapper<>(Button.class));
    }

    public Button show(int id) {
        return jdbcTemplate.query("SELECT * FROM \"Button\" Where id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Button.class)).stream().findAny().orElse(null);
    }

    public void save(Button button) {
        jdbcTemplate.update("INSERT INTO \"Button\" VALUES (DEFAULT, ?, ?, ?)",
                button.getChallenge_id(), button.getName(), button.getNum());
    }

    public void update(int id, Button updatedButton) {
        jdbcTemplate.update("UPDATE  \"Button\" Set challenge_id=?,name=?,  num=? where id=?",
                updatedButton.getChallenge_id(), updatedButton.getName(), updatedButton.getNum(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM \"Button\" where id=?", id);
    }
}
