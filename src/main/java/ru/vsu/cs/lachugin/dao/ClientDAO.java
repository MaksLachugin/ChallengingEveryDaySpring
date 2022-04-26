package ru.vsu.cs.lachugin.dao;

import ru.vsu.cs.lachugin.models.Button;
import ru.vsu.cs.lachugin.models.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ClientDAO {
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

    public List<Client> index() {
        return null;
    }

    public Client show(int id) {
        return null;
    }

    public void save(Client client) {
    }

    public void update(int id, Client updatedClient) {
    }

    public void delete(int id) {
    }
}
