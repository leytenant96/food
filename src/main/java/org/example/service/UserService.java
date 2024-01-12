package org.example.service;

import org.example.bot.ConnectionBot;
import org.example.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService extends ConnectionBot {

    @Override
    public Connection connection() {
        return super.connection();
    }

    // find user

    public User findByChatId(Long chatId) {
        User user = null;
        try {
            PreparedStatement statement = connection().prepareStatement("SELECT *FROM users WHERE chatId=?");
            statement.setLong(1, chatId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = User.builder()
                        .chatId(resultSet.getLong("chatId"))
                        .action(resultSet.getString("action"))
                        .phoneNumber(resultSet.getString("phoneNumber"))
                        .build();
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//save User
    public boolean saveUser(Long chatId) {
        try {
            PreparedStatement statement = connection().prepareStatement("INSERT INTO users(chatId) VALUES (?)");
            statement.setLong(1, chatId);
            return !statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
