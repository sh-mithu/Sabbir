package com.example.project_dbms_java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import java.awt.*;

public class after_login  {
    @FXML
    public Label user_nametxt;
    @FXML
    public Label emailtxt;
    @FXML
    public Label phonetxt;
    @FXML
    public Label addresstxt;
    @FXML
    private Label sabbir;
    public String name,email,phone,address;
    @FXML
    public void Log_out_button(ActionEvent event) {
        /*final Parent[] root = {null};

        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource());
            root[0] = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Log In");
        stage.setScene(new Scene(root[0], 717, 523));
        stage.show();*/
        new page_open().Open_window(event,"","Login_page.fxml",717,523);
    }
    /*void show_value_screen(String name,String email,String phone, String address){
        user_nametxt.setText(name);
        emailtxt.setText(email);
        phonetxt.setText(phone);
        addresstxt.setText(address);
    }*/
        /*user_nametxt.setText("Please Enter Email!");
        emailtxt.setText("email");
        phonetxt.setText("phone");
        addresstxt.setText("address");*/
    public void view(String table ,String user_email_login,String user_pass_login){

        Database_controller connectnew= new Database_controller();
        Connection connectiondb= connectnew.login();
        String query1= "SELECT full_name, email, password, phone_number, nid, date_of_birth, gender, present_address, permanent_address, designation FROM "+table+" WHERE email = '"+user_email_login+"' AND password ='"+user_pass_login+"'";

        try {
            Statement statement = connectiondb.createStatement();
            ResultSet get_value_from_db = statement.executeQuery(query1);
            while (get_value_from_db.next()) {
                String name1 = get_value_from_db.getString("full_name");
                email = get_value_from_db.getString("email");
                phone = get_value_from_db.getString("phone_number");
                address = get_value_from_db.getString("present_address");
                name=name1;
                System.out.println(name+"\n"+email+"\n"+phone+"\n"+address+"\n");
                System.out.println(name);

                //fshow_value_screen(name,email,phone,address);


            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

   /* @Override
    public void initialize(URL location, ResourceBundle resources) {
        sabbir.setText(name);
    }*/
}
