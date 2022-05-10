package ru.vsu.cs.lachugin.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.vsu.cs.lachugin.models.BaseModel;

import java.util.ArrayList;
import java.util.List;

abstract class BaseDAO<T extends BaseModel> implements IDAO<T> {
    final JdbcTemplate jdbcTemplate;
    final String tableName;
    final Class<T> classT;

    public BaseDAO(JdbcTemplate jdbcTemplate, String tableName, Class<T> classT) {
        this.jdbcTemplate = jdbcTemplate;
        this.tableName = tableName;
        this.classT = classT;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }


    public String getTableName() {
        return tableName;
    }


    public Class<T> getClassT() {
        return classT;
    }

    public BeanPropertyRowMapper<T> getBean() {
        return new BeanPropertyRowMapper<>(getClassT());
    }

    abstract public Object[] getParams(T obj);

    abstract public int[] getParamsTypes();

    abstract public Object[] getParamsWithId(T obj, int id);

    abstract public int[] getParamsTypesWithId();

    abstract public String getFormatForDefaultValues(); // (DEFAULT, ?, ?, ?)

    abstract public String getWhere();

    abstract public String getSet();


    public List<T> index() {
        return getJdbcTemplate().query(String.format("SELECT * FROM \"%s\"", getTableName()), getBean());
    }

    public T show(int id) {
        return getJdbcTemplate().query(String.format("SELECT * FROM \"%s\" Where id=?", getTableName()), new Object[]{id}, getBean()).stream().findAny().orElse(null);
    }

    public T save(T obj) {
        getJdbcTemplate().update(String.format("INSERT INTO \"%s\" VALUES %s", getTableName(), getFormatForDefaultValues()), getParams(obj), getParamsTypes());
        return findByParams(obj);
    }

    public T update(int id, T updatedObj) {
        String s = String.format("UPDATE  \"%s\" Set %s where id=?", getTableName(), getSet());
        Object[] t = getParamsWithId(updatedObj, id);
        int[] x = getParamsTypesWithId();
        getJdbcTemplate().update(String.format("UPDATE  \"%s\" Set %s where id=?", getTableName(), getSet()), getParamsWithId(updatedObj, id), getParamsTypesWithId());
        return show(id);
    }

    public T findByParams(T obj) {
        return getJdbcTemplate().query(String.format("SELECT * FROM \"%s\" Where %s", getTableName(), getWhere()), getParams(obj), getBean()).stream().findAny().orElse(null);
    }

    public T delete(int id) {
        T obj = show(id);
        getJdbcTemplate().update(String.format("DELETE FROM \"%s\" where id=?", getTableName()), id);
        return obj;
    }

    public void clean() {
        getJdbcTemplate().update(String.format("DELETE FROM \"%s\" WHERE id >= 1", getTableName()));
    }

    public List<T> saveAll(List<T> objs) {
        List<T> result = new ArrayList<>();
        for (T obj : objs) {
            result.add(save((obj)));
        }
        return result;
    }
}
