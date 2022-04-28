package ru.vsu.cs.lachugin.dao;

import org.springframework.stereotype.Component;
import ru.vsu.cs.lachugin.models.Button;
import ru.vsu.cs.lachugin.models.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class ClientDAO extends BaseDAO{

    public List<Client> index() {
        List<Client> clients = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM \"Client\"";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Client client = new Client();

                client.setId(resultSet.getLong("id"));
                client.setName(resultSet.getString("name"));
                client.setPass(resultSet.getString("pass"));

                clients.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clients;
    }

    public Client show(int id) {
        Client client = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM \"Client\" Where id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            client = new Client();

            client.setId(resultSet.getLong("id"));
            client.setName(resultSet.getString("name"));
            client.setPass(resultSet.getString("pass"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return client;
    }

    public void save(Client client) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO \"Client\" VALUES (DEFAULT, ?, ?)");

            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getPass());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Client updatedClient) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE  \"Client\" Set name=?,pass=? where id=?");

            preparedStatement.setString(1, updatedClient.getName());
            preparedStatement.setString(2, updatedClient.getPass());
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM \"Client\" where id=?");

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
