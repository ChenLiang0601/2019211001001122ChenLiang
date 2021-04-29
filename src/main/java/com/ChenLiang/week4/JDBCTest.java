package com.ChenLiang.week4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] a)throws SQLException,ClassNotFoundException{
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;databaseName=userdb";
        String username="CL";
        String password="123456";
        Class.forName(driver);
        Connection con= DriverManager.getConnection(url,username,password);
        System.out.println(con);
    }
}
