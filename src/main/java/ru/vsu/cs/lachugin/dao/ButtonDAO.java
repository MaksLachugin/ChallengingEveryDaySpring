package ru.vsu.cs.lachugin.dao;

import org.springframework.stereotype.Component;
import ru.vsu.cs.lachugin.models.Button;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ButtonDAO extends BaseDAO {
    public List<Button> index() {
        List<Button> buttons = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM \"Button\"";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Button button = new Button();

                button.setId(resultSet.getLong("id"));
                button.setChallenge_id(resultSet.getLong("challenge_id"));
                button.setName(resultSet.getString("name"));
                button.setNum(resultSet.getLong("num"));

                buttons.add(button);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return buttons;
    }

    public Button show(int id) {
        Button button = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM \"Button\" Where id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            button = new Button();

            button.setId(resultSet.getLong("id"));
            button.setChallenge_id(resultSet.getLong("challenge_id"));
            button.setName(resultSet.getString("name"));
            button.setNum(resultSet.getLong("num"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return button;
    }

    public void save(Button button) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO \"Button\" VALUES (DEFAULT, ?, ?, ?)");

            preparedStatement.setLong(1, button.getChallenge_id());
            preparedStatement.setString(2, button.getName());
            preparedStatement.setLong(3, button.getNum());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Button updatedButton) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE  \"Button\" Set challenge_id=?,name=?,  num=? where id=?");

            preparedStatement.setLong(1, updatedButton.getChallenge_id());
            preparedStatement.setString(2, updatedButton.getName());
            preparedStatement.setLong(3, updatedButton.getNum());
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM \"Button\" where id=?");

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
