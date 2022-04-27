package ru.vsu.cs.lachugin.dao;

import ru.vsu.cs.lachugin.models.Button;
import ru.vsu.cs.lachugin.models.Repetition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class RepetitionDAO extends BaseDAO {

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Repetition> index() {
        return null;
    }

    public Repetition show(int id) {
        return null;
    }

    public void save(Repetition repetition) {
    }

    public void update(int id, Repetition updatedRepetition) {
    }

    public void delete(int id) {
    }
}
