package ru.vsu.cs.lachugin.dao;

import ru.vsu.cs.lachugin.models.Button;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ButtonDAO {
    private static final String URL = "";
    private static final String USERNAME = "";
    private static final String PASS = "";
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

    public List<Button> index() {
        return null;
    }

    public Button show(int id) {
        return null;
    }

    public void save(Button button) {
    }

    public void update(int id, Button updatedButton) {
    }

    public void delete(int id) {
    }
}
