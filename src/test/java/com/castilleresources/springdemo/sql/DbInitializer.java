package com.castilleresources.springdemo.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbInitializer {

    private static final String DB_URI = "jdbc:h2:mem:testdb";
    private static final String USER = "sa";
    private static final String PASS = "sa";
    private static final String BEFORE_SCRIPT = "INSERT INTO employees (id, email_address, first_name, last_name) VALUES (1, 'test1@gmail.com', 'Gordon', 'Freeman'), (2, 'test2@gmail.com', 'Duke', 'Nukem'), (3, 'test3@gmail.com', 'Serious', 'Sam');";
    private static final String AFTER_SCRIPT = "TRUNCATE TABLE employees;";

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URI,USER,PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void initDb() {
        executeSql(BEFORE_SCRIPT);
    }

    public void cleanDb() {
        executeSql(AFTER_SCRIPT);
    }

    private void executeSql(String sql){
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
