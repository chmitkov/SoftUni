package com.minkov;

import com.minkov.db.EntityDbContext;
import com.minkov.db.base.DbContext;
import com.minkov.entities.Department;
import com.minkov.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    private static final String CONNECTION_STRING =
            "jdbc:mysql://localhost:3306/soft_uni_simple";

    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Connection connection = getConnection();

        DbContext<User> usersDbContext =
                getDbContext(connection, User.class);

        DbContext<Department> departmentDbContext =
                getDbContext(connection, Department.class);


        User ivan = new User("Ivan", "Ivanov");

        User pena = new User("Pena", "Todorova");

        User go = new User("gosho", "Ivanov");


//        usersDbContext.persist(user);
//        usersDbContext.persist(ivan);
//        usersDbContext.persist(go);

        //Test

        //usersDbContext.persist(pena);

        //Test
       // usersDbContext.delete("id = 2");

        //Test
       User find = usersDbContext.findById(4);
       System.out.println(find.getFirstName());

        //  connection.close();
    }

    private static <T> DbContext<T> getDbContext(Connection connection, Class<T> klass) throws SQLException {
        return new EntityDbContext<>(connection, klass);
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                CONNECTION_STRING,
                "root",
                "12345"
        );
    }
}
