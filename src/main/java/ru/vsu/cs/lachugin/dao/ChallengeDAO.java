package ru.vsu.cs.lachugin.dao;

import org.springframework.stereotype.Component;
import ru.vsu.cs.lachugin.models.Button;
import ru.vsu.cs.lachugin.models.Challenge;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class ChallengeDAO extends BaseDAO {

    public List<Challenge> index() {
        List<Challenge> challenges = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM \"Challenge\"";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Challenge challenge = new Challenge();

                challenge.setId(resultSet.getLong("id"));
                challenge.setClient_id(resultSet.getLong("client_id"));
                challenge.setName(resultSet.getString("name"));
                challenge.setNeed(resultSet.getLong("need"));
                challenge.setDays(resultSet.getLong("days"));
                challenge.setStart_date(resultSet.getDate("start_date"));

                challenges.add(challenge);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return challenges;
    }

    public Challenge show(int id) {
        Challenge challenge = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM \"Challenge\" Where id=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            challenge = new Challenge();

            challenge.setId(resultSet.getLong("id"));
            challenge.setClient_id(resultSet.getLong("client_id"));
            challenge.setName(resultSet.getString("name"));
            challenge.setNeed(resultSet.getLong("need"));
            challenge.setDays(resultSet.getLong("days"));
            challenge.setStart_date(resultSet.getDate("start_date"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return challenge;
    }

    public void save(Challenge challenge) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO \"Challenge\" VALUES (DEFAULT, ?, ?, ?, ?, ?)");
            preparedStatement.setLong(1, challenge.getClient_id());
            preparedStatement.setString(2, challenge.getName());
            preparedStatement.setLong(3, challenge.getNeed());
            preparedStatement.setLong(4, challenge.getDays());
            preparedStatement.setDate(5, challenge.getStart_date());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Challenge updatedChallenge) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE  \"Challenge\" Set client_id=?,name=?,  need=?, days=?, start_date=? where id=?");
            preparedStatement.setLong(1, updatedChallenge.getClient_id());
            preparedStatement.setString(2, updatedChallenge.getName());
            preparedStatement.setLong(3, updatedChallenge.getNeed());
            preparedStatement.setLong(4, updatedChallenge.getDays());
            preparedStatement.setDate(5, updatedChallenge.getStart_date());
            preparedStatement.setLong(6, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM \"Challenge\" where id=?");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
