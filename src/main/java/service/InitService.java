package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitService {

    public static void createTables() {
        String URL = "jdbc:sqlite:miracle.sqlite";
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS \"users\" (\"id\" INTEGER PRIMARY KEY  NOT NULL ,\"name\" TEXT DEFAULT (null) ,\"about\" TEXT DEFAULT (null))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
