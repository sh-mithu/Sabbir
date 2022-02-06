package com.example.project_dbms_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
    static final String DB_URL = "jdbc:mysql://localhost/employee_managment_system";
    static final String USER = "root";
    static final String PASS = "";
    //static final String QUERY = "SELECT id, first, last, age FROM Registration";
    static final String query1= "SELECT phone_number FROM admin WHERE email = 'sabbir@gmail.com'";


    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query1);
        ) {
            while(rs.next()){
                //Display values
                /*System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Age: " + rs.getInt("age"));*/
                System.out.print(", Phone Number: " + rs.getString("phone_number"));
                //System.out.println(", Last: " + rs.getString("last"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}