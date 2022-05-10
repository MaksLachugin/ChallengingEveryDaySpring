package ru.vsu.cs.lachugin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.vsu.cs.lachugin.models.Challenge;

import java.util.List;

@Component
public class ChallengeDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ChallengeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Challenge> index() {

        return jdbcTemplate.query("SELECT * FROM \"Challenge\"", new BeanPropertyRowMapper<>(Challenge.class));
    }

    public Challenge show(int id) {
        return jdbcTemplate.query("SELECT * FROM \"Challenge\" Where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Challenge.class)).stream().findAny().orElse(null);
    }

    public Challenge save(Challenge challenge) {
        jdbcTemplate.update("INSERT INTO \"Challenge\" VALUES (DEFAULT, ?, ?, ?, ?, ?)", challenge.getClient_id(), challenge.getName(), challenge.getNeed(), challenge.getDays(), challenge.getStart_date());
        return jdbcTemplate.query("SELECT * FROM \"Challenge\" Where client_id=? AND name=? AND need=? AND days=? AND start_date=?", new Object[]{challenge.getClient_id(), challenge.getName(), challenge.getNeed(), challenge.getDays(), challenge.getStart_date()}, new BeanPropertyRowMapper<>(Challenge.class)).stream().findAny().orElse(null);
    }

    public Challenge update(int id, Challenge updatedChallenge) {
        jdbcTemplate.update("UPDATE  \"Challenge\" Set client_id=?, name=?,  need=?, days=?, start_date=? where id=?", updatedChallenge.getClient_id(), updatedChallenge.getName(), updatedChallenge.getNeed(), updatedChallenge.getDays(), updatedChallenge.getStart_date(), id);
        return show(id);
    }

    public Challenge delete(int id) {
        Challenge challenge = show(id);
        jdbcTemplate.update("DELETE FROM \"Challenge\" where id=?", id);
        return challenge;
    }
}
