package org.example.bot;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConnectionBot {
    String URL="jdbc:postgresql://localhost:5432/Food";
    String USERNAME="postgres";
    String PASSWORD="1221";


    public Connection connection(){
        try {
            Connection connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
