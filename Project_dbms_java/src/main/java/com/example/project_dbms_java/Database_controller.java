package com.example.project_dbms_java;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database_controller {
    public Connection databaselink;
    public Connection getDatabaselink(){
        String databasename ="sqldemo";
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
}
