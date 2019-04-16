package pl.lukas.jpa;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

    private static void createTableForStudent() throws SQLException, ClassNotFoundException {
        Connection connection = H2Config.getDBConnection();

        Statement statement = connection.createStatement();

        String createTable = "CREATE TABLE STUDENT(id int primary key, name varchar(255))";

        statement.execute(createTable);

        connection.commit();
    }
}
