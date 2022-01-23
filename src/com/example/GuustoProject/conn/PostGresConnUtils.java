package com.example.GuustoProject.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class PostGresConnUtils {
 
 public static Connection getPostGresConnection()
         throws ClassNotFoundException, SQLException {
	 // Note: Change the connection parameters accordingly.
     String hostName = "ec2-18-210-233-138.compute-1.amazonaws.com";
     String dbName = "d1g3i9uoeombm0";
     String userName = "vwjxrgmribomxm";
     String password = "d9eee6361d1f4e5431e644b90c2a610936a4aaccf38665644082a961581921bd";
     return getPostGresConnection(hostName, dbName, userName, password);
 }
 
 public static Connection getPostGresConnection(String hostName, String dbName,
         String userName, String password) throws SQLException,
         ClassNotFoundException {
   
     Class.forName("org.postgresql.Driver");
 
     // URL Connection for PostGreSQL:
     // Example: 
     // jdbc:mysql://localhost:3306/simplehr
     String connectionURL = "jdbc:postgresql://" + hostName + ":5432/" + dbName + "?sslmode=require";
 
     Connection conn = DriverManager.getConnection(connectionURL, userName,
             password);
     return conn;
 }
}