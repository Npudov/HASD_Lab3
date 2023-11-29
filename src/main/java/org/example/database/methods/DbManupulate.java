package org.example.database.methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManupulate {

    public static void createTable(Connection conn, String tableName) throws SQLException {
        String createSql = "CREATE TABLE " + tableName +  " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "age Integer NOT NULL)";
        Statement stmt = conn.createStatement();
        stmt.execute(createSql);
    }

    public static void insertStudent(Connection conn, String name, int age) throws SQLException {
        String insertQuery = "INSERT INTO Students (name, age) VALUES (?, ?)";
        PreparedStatement prepstmt = conn.prepareStatement(insertQuery);
        prepstmt.setString(1, name);
        prepstmt.setInt(2, age);
        prepstmt.executeUpdate();

    }

    public static void deleteTableStudents(Connection conn) throws SQLException {
        String deleteTable = "DROP TABLE Students";
        Statement stmt = conn.createStatement();
        stmt.execute(deleteTable);
    }
}
