package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application {
    public static void main(String[] args) throws SQLException {

        String user = "root";
        String password = "12345";

        Properties properties = new Properties();

        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        Engine engine = new Engine(connection);

         engine.run();

    }
}
