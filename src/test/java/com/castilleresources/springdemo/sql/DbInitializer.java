package com.castilleresources.springdemo.sql;

import java.sql.*;

public class DbInitializer {

    private static final String DB_URI = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false";
    private static final String USER = "sa";
    private static final String PASS = "sa";
    private static final String CREATE_TABLE = "CREATE TABLE EMPLOYEES (ID INT, EMAIL_ADDRESS VARCHAR, FIRST_NAME VARCHAR, LAST_NAME VARCHAR);";
    private static final String POPULATE_SCRIPT = "INSERT INTO EMPLOYEES (ID, EMAIL_ADDRESS, FIRST_NAME, LAST_NAME) VALUES (1, 'test1@gmail.com', 'Gordon', 'Freeman'), (2, 'test2@gmail.com', 'Duke', 'Nukem'), (3, 'test3@gmail.com', 'Serious', 'Sam');";
    private static final String AFTER_SCRIPT = "DROP TABLE EMPLOYEES;";

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
        executeSql(CREATE_TABLE);
    }

    public void populateDb(){
        executeSql(POPULATE_SCRIPT);
    }

    public void cleanDb() {
        executeSql(AFTER_SCRIPT);
    }

    private void executeSql(String sql){
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
