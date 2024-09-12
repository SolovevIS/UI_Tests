package ru.db.junit.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
import ru.db.junit.utils.UtilsDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class TestsDB {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    public static Map<String, String> map = new HashMap<>();
    private final static String basicQuery = "select * from employees";

    @Before
    public void setUp(){
        UtilsDB utilsDB = new UtilsDB();
        connection = utilsDB.getConnection();
        statement = utilsDB.getStatement(connection);
    }
    @After
    public void close(){
        UtilsDB utilsDB = new UtilsDB();
        utilsDB.closeResources(connection, statement, resultSet);
    }

    @Test
    public void basicSelect(){
        String query = "select * from employees";
        UtilsDB utils = new UtilsDB();
        resultSet = utils.executeSelect(statement, query);
        try {
            while (resultSet.next()){
                System.out.println("{Id = " + resultSet.getInt("id")
                + ", Name = " + resultSet.getString("name")
                + ", Position = " + resultSet.getString("position")
                + ", Salary = " + resultSet.getDouble("salary") + "}");
            }
        } catch (SQLException e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void basicInsert(){
        Random random = new Random();
        UtilsDB utils = new UtilsDB();
        String key = String.valueOf(random.nextInt());
        String query = "insert into employees (name, position, salary) VALUES ('" + key + "', 'DefinentlyNotActor', " + random.nextDouble() + ")";
        int resultRows = utils.executeUpdate(statement, query);
        System.out.println("Rows affected = " + resultRows + " by query = " + query);
        Assert.assertEquals(1, resultRows);
    }

    @Test
    public void basicDeleteLast(){
        UtilsDB utils = new UtilsDB();
        resultSet = utils.executeSelect(statement, basicQuery);
        String query = "delete from employees where id = " + utils.returnLastId(resultSet);
        int resultRows = utils.executeUpdate(statement, query);
        System.out.println("Rows affected = " + resultRows + "by query = " + query);
        Assert.assertEquals(1, resultRows);
    }

    @Test
    public void basicUpdate(){
        UtilsDB utils = new UtilsDB();
        String query = "update employees set name = 'Janet' where id = 1";
        int resultRows = utils.executeUpdate(statement, query);
        System.out.println("Rows affected = " + resultRows + " by query = " + query);
        Assert.assertEquals(1, resultRows);
    }
}
