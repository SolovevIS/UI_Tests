package ru.db.junit.utils;

import ru.db.junit.tests.TestsDB;

import java.sql.*;
import java.util.UUID;

public class UtilsDB {

    public UtilsDB() {

    }

    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/test/resources/db/mydatabase.db");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Statement getStatement(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            return statement;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet executeSelect(Statement statement, String query) {
        try {
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void closeResources(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int executeUpdate(Statement statement, String query) {
        try {
            int rowAffectedByQuery = statement.executeUpdate(query);
            return rowAffectedByQuery;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String generateRandomUUID(String keyFromMap){
        String uuid = UUID.randomUUID().toString();
        TestsDB.map.put(keyFromMap, uuid);
        return uuid;
    }

    public int returnLastId(ResultSet resultSet){
        int id = 0;
        try {
            while (resultSet.next()){
                id = resultSet.getInt("id");
            }
            return id;
        } catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }
}
