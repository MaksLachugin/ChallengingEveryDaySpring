package ru.vsu.cs.lachugin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.vsu.cs.lachugin.models.Button;
import ru.vsu.cs.lachugin.models.Challenge;
import ru.vsu.cs.lachugin.models.Repetition;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Component
public class RepetitionDAO extends BaseDAO<Repetition> implements IDAO<Repetition> {
    public RepetitionDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, "Repetition", Repetition.class);
    }

    @Override
    public Object[] getParams(Repetition repetition) {
        return new Object[]{repetition.getChallenge_id(), repetition.getCount(), repetition.getDate()};
    }

    @Override
    public int[] getParamsTypes() {
        return new int[]{Types.INTEGER, Types.INTEGER, Types.DATE};
    }

    @Override
    public Object[] getParamsWithId(Repetition repetition, int id) {
        Object[] objects = getParams(repetition);
        return new Object[]{objects[0], objects[1], objects[2], id};

    }

    @Override
    public int[] getParamsTypesWithId() {
        int[] paramsTypes = getParamsTypes();
        return new int[]{paramsTypes[0], paramsTypes[1], paramsTypes[2], Types.INTEGER};

    }

    @Override
    public String getFormatForDefaultValues() {
        return "(DEFAULT, ?, ?, ?)";
    }

    @Override
    public String getWhere() {
        return "challenge_id=? AND count=? AND date=?";
    }

    @Override
    public String getSet() {
        return "challenge_id=?, count=?, date=?";
    }
}