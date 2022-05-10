package ru.vsu.cs.lachugin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.vsu.cs.lachugin.models.Button;

import java.sql.Types;

@Component
public class ButtonDAO extends BaseDAO<Button> implements IDAO<Button> {
    public ButtonDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, "Button", Button.class);
    }

    @Override
    public Object[] getParams(Button button) {
        return new Object[]{button.getChallenge_id(), button.getName(), button.getNum()};
    }

    @Override
    public int[] getParamsTypes() {
        return new int[]{Types.INTEGER, Types.VARCHAR, Types.INTEGER};
    }

    @Override
    public Object[] getParamsWithId(Button button, int id) {
        Object[] objects = getParams(button);
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
        return "challenge_id=? AND name=? AND num=?";
    }

    @Override
    public String getSet() {
        return "challenge_id=?, name=?,  num=?";
    }
}
