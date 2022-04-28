package ru.vsu.cs.lachugin.dao;

import org.springframework.stereotype.Component;
import ru.vsu.cs.lachugin.models.Button;
import ru.vsu.cs.lachugin.models.Client;
import ru.vsu.cs.lachugin.models.Repetition;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class RepetitionDAO extends BaseDAO {

    public List<Repetition> index() {
        List<Repetition> repetitions = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM \"Repetition\"";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Repetition repetition = new Repetition();

                repetition.setId(resultSet.getLong("id"));
                repetition.setChallenge_id(resultSet.getLong("challenge_id"));
                repetition.setCount(resultSet.getLong("count"));
                repetition.setDate(resultSet.getDate("date"));


                repetitions.add(repetition);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return repetitions;
    }

    public Repetition show(int id) {
        Repetition repetition = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM \"Repetition\" Where id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            repetition = new Repetition();

            repetition.setId(resultSet.getLong("id"));
            repetition.setChallenge_id(resultSet.getLong("challenge_id"));
            repetition.setCount(resultSet.getLong("count"));
            repetition.setDate(resultSet.getDate("date"));


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return repetition;
    }

    public void save(Repetition repetition) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO \"Repetition\" VALUES (DEFAULT, ?, ?, ?)");

            preparedStatement.setLong(1, repetition.getChallenge_id());
            preparedStatement.setLong(2, repetition.getCount());
            preparedStatement.setDate(3, repetition.getDate());


            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Repetition updatedRepetition) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE  \"Repetition\" Set challenge_id=?, count=?, date=? where id=?");

            preparedStatement.setLong(1, updatedRepetition.getChallenge_id());
            preparedStatement.setLong(2, updatedRepetition.getCount());
            preparedStatement.setDate(3, updatedRepetition.getDate());

            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM \"Repetition\" where id=?");

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
