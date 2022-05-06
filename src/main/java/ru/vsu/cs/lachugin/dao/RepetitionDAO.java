package ru.vsu.cs.lachugin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.vsu.cs.lachugin.models.Repetition;

import java.util.List;

@Component
public class RepetitionDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RepetitionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Repetition> index() {

        return jdbcTemplate.query("SELECT * FROM \"Repetition\"",
                new BeanPropertyRowMapper<>(Repetition.class));
    }

    public Repetition show(int id) {
        return jdbcTemplate.query("SELECT * FROM \"Repetition\" Where id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Repetition.class)).stream().findAny().orElse(null);
    }

    public void save(Repetition repetition) {
        jdbcTemplate.update("INSERT INTO \"Repetition\" VALUES (DEFAULT, ?, ?, ?)",
                repetition.getChallenge_id(), repetition.getCount(), repetition.getDate());
    }

    public void update(int id, Repetition updatedRepetition) {
        jdbcTemplate.update("UPDATE  \"Repetition\" Set challenge_id=?, count=?, date=? where id=?",
                updatedRepetition.getChallenge_id(), updatedRepetition.getCount(), updatedRepetition.getDate(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM \"Repetition\" where id=?", id);
    }
}