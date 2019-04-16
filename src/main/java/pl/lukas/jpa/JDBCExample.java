package pl.lukas.jpa;

import pl.lukas.jpa.domain.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCExample {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        createTableForStudent();
        Student student1 = new Student(1, "Paweł");
        Student student2 = new Student(2, "Marek");

        insertStudent(student1);
        insertStudent(student2);


    }

    private static void createTableForStudent() throws SQLException, ClassNotFoundException {
        Connection connection = H2Config.getDBConnection();

        Statement statement = connection.createStatement();

        String createTable = "CREATE TABLE STUDENT(id int primary key, name varchar(255))";

        statement.execute(createTable);

        connection.commit();
    }

    private static void insertStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection connection = H2Config.getDBConnection();

        Statement statement = connection.createStatement();

        String insert = "INSERT INTO STUDENT VALUES(" + student.getId() + ",\'" + student.getName() + "\')";

        statement.execute(insert);

        connection.commit();

    }

    private static List<Student> getStudents(){
        List<Student> students = new ArrayList<Student>();
    }
}
