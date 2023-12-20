package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.example.database.methods.DbManupulate.*;

public class SimpleSQLiteDatabase {

    private static Connection connection = null;
    private static String pathDb = "jdbc:sqlite:D:/SQLiteProjects/SimpleDB/simple_database.db";

    public static void main(String[] args) throws Exception {

        connection = getConn();

        createTableGroups(connection);
        createTableStudents(connection);
        insertGroup(connection, 345);
        insertStudent(connection, 1,"Ivanov Ivan Ivanich", 25);
        connection.close();
    }

    private static Connection getConn() throws Exception {
        if (connection == null) {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(pathDb);
        }
        return connection;
    }
}
