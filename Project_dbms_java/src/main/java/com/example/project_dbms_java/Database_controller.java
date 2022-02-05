package com.example.project_dbms_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database_controller {
    public Connection databaselink;
    public Connection getDatabaselink(){
        String databasename ="employee_managment_system";
        String databaseuser ="root";
        String databasepass ="Sabbir";
        String url ="jdbc:mysql://localhost/"+databasename;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink=DriverManager.getConnection(url,databaseuser,databasepass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaselink;
    }

    public void save_value(String sql)
    {
        String databasename ="employee_managment_system";
        String databaseuser ="root";
        String databasepass ="Sabbir";
        String url ="jdbc:mysql://localhost/"+databasename;
        String s_url="jdbc:mysql://localhost:3306/";
        try{
            Connection conn = DriverManager.getConnection(s_url, databaseuser, databasepass);
            Statement statement = conn.createStatement();
            conn = DriverManager.getConnection(url, databaseuser, databasepass);
            statement = conn.createStatement();
            statement.execute(sql);
            statement.close();
            conn.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public Connection login() {
        //Connection connection;
        String databasename = "employee_managment_system";
        String databaseuser = "root";
        String databasepass = "Sabbir";
        String url = "jdbc:mysql://localhost:3306/" + databasename;
        String s_url = "jdbc:mysql://localhost:3306/";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(s_url, databaseuser, databasepass);
            Statement statement = connection.createStatement();
            connection = DriverManager.getConnection(url, databaseuser, databasepass);
            //statement = conn.createStatement();

            /*statement.close();
            conn.close();*/

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void update(String sql) {
        String databasename = "employee_managment_system";
        String databaseuser = "root";
        String databasepass = "Sabbir";
        String url = "jdbc:mysql://localhost/" + databasename;
        String s_url = "jdbc:mysql://localhost/";
        try {
            Connection conn = DriverManager.getConnection(s_url, databaseuser, databasepass);
            Statement statement = conn.createStatement();
            conn = DriverManager.getConnection(url, databaseuser, databasepass);
            statement = conn.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
