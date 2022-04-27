package ru.vsu.cs.lachugin.dao;

import ru.vsu.cs.lachugin.models.Button;
import ru.vsu.cs.lachugin.models.Challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ChallengeDAO extends BaseDAO{

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

    public List<Challenge> index() {
        return null;
    }

    public Challenge show(int id) {
        return null;
    }

    public void save(Challenge challenge) {
    }

    public void update(int id, Challenge updatedChallenge) {
    }

    public void delete(int id) {
    }
}
