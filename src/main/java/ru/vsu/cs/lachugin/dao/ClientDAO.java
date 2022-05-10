package ru.vsu.cs.lachugin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.vsu.cs.lachugin.models.Button;
import ru.vsu.cs.lachugin.models.Challenge;
import ru.vsu.cs.lachugin.models.Client;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClientDAO extends BaseDAO<Client> implements IDAO<Client> {

    public ClientDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, "Client", Client.class);
    }

    @Override
    public Object[] getParams(Client client) {
        return new Object[]{client.getName(), client.getPass()};
    }

    @Override
    public int[] getParamsTypes() {
        return new int[]{Types.VARCHAR, Types.VARCHAR};
    }

    @Override
    public Object[] getParamsWithId(Client Client, int id) {
        Object[] objects = getParams(Client);
        return new Object[]{objects[0], objects[1], id};

    }

    @Override
    public int[] getParamsTypesWithId() {
        int[] paramsTypes = getParamsTypes();
        return new int[]{paramsTypes[0], paramsTypes[1], Types.INTEGER};

    }

    @Override
    public String getFormatForDefaultValues() {
        return "(DEFAULT, ?, ?)";
    }

    @Override
    public String getWhere() {
        return "name=? AND pass=?";
    }

    @Override
    public String getSet() {
        return "name=?, pass=?";
    }
}