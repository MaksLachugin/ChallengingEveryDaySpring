package ru.vsu.cs.lachugin.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.vsu.cs.lachugin.models.Challenge;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChallengeDAO extends BaseDAO<Challenge> implements IDAO<Challenge> {
    public ChallengeDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, "Challenge", Challenge.class);
    }

    @Override
    public Object[] getParams(Challenge challenge) {
        return new Object[]{challenge.getClient_id(), challenge.getName(), challenge.getNeed(), challenge.getDays(), challenge.getStart_date()};
    }

    @Override
    public int[] getParamsTypes() {
        return new int[]{Types.INTEGER, Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.DATE};
    }

    @Override
    public Object[] getParamsWithId(Challenge challenge, int id) {
        Object[] objects = getParams(challenge);
        return new Object[]{objects[0], objects[1], objects[2], objects[3], objects[4], id};

    }

    @Override
    public int[] getParamsTypesWithId() {
        int[] paramsTypes = getParamsTypes();
        return new int[]{paramsTypes[0], paramsTypes[1], paramsTypes[2], paramsTypes[3], paramsTypes[4], Types.INTEGER};

    }

    @Override
    public String getFormatForDefaultValues() {
        return "(DEFAULT, ?, ?, ?, ?, ?)";
    }

    @Override
    public String getWhere() {
        return "client_id=? AND name=? AND need=? AND days=? AND start_date=?";
    }

    @Override
    public String getSet() {
        return "client_id=?, name=?,  need=?, days=?, start_date=?";
    }
}
