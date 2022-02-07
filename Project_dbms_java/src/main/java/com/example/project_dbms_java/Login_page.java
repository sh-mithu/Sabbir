package com.example.project_dbms_java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;



public class Login_page implements Initializable {
    @FXML
    private Label login_success_text;
    @FXML
    private Button goto_signup;
    @FXML
    private Button Log_out;
    @FXML
    private TextField user_email_login;
    @FXML
    private PasswordField user_pass_login;
    //private TextField user_pass_login;

    @FXML
    private Label invalid_login;


    public static String[] value_set={"","","",""};
    //choice box
    @FXML
    private ChoiceBox<String> choicbox_login;
    private String[] employee_level= {"Admin","Genitors","Stuffs","Workers"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choicbox_login.getItems().addAll(employee_level);
        choicbox_login.setOnAction(event -> getEmployeelevel());
    }
    //End choice ebox

    public String getEmployeelevel() {
        String chooseemployee = choicbox_login.getValue();
        String a = null;
        if (chooseemployee.equals("Admin")) {
            a = "admin";

        }
        else if (chooseemployee.equals("Genitors")) {
            a = "genitors";
        }
        else if (chooseemployee.equals("Stuffs")) {
            a = "stuffs";
        }
        else if (chooseemployee.equals("Workers")) {
            a = "workers";
        }
        return a;
    }


    @FXML
    void signup_handler(ActionEvent event) {
        new page_open().Open_window(event,"Sign Up","signup_page.fxml",680, 540);
    }


    public void loginhandler(ActionEvent event) throws SQLException {
        String a=getEmployeelevel();
        System.out.println(user_email_login.getText());
        System.out.println(user_pass_login.getText());
        if (!user_email_login.getText().isBlank() && user_pass_login.getText().isBlank()){
            invalid_login.setText("Please Enter Password!");
        }
        else if (user_email_login.getText().isBlank() && !user_pass_login.getText().isBlank()){
            invalid_login.setText("Please Enter Email!");
        }
        else if (user_email_login.getText().isBlank() && user_pass_login.getText().isBlank()){
            invalid_login.setText("Please Enter Email and Password!");
        }
        else if(a.equals("admin")){
            connetion(event,"Admin");
        }
        else if(a.equals("genitors")){
            connetion(event,"Genitors");
        }
        else if(a.equals("stuffs")){
            connetion(event,"Stuffs");
        }
        else if(a.equals("workers")){
            connetion(event,"Workers");
        }
    }

    public void connetion(ActionEvent event,String table) throws SQLException{

        Database_controller connectnew= new Database_controller();
        Connection connectiondb= connectnew.login();
        String query= "SELECT count(1) FROM login_information WHERE Email = '" + user_email_login.getText() +"' AND Password = '"+user_pass_login.getText()+"' AND Designation = '"+table+"'";

        try {
            invalid_login.setText("");
            //Statement statement = connectiondb.createStatement();
            Statement statement = connectiondb.createStatement();
            ResultSet queryresult= statement.executeQuery(query);
            while(queryresult.next()){
                if(queryresult.getInt(1)==1){
                    view_information(table ,user_email_login.getText(), user_pass_login.getText());
                    //System.out.println(value_set[0]+"\n"+value_set[1]);
                    if(table.equals("Admin")){
                        new page_open().Open_window(event,"Loggedin Page","admin_login.fxml",717, 523);
                    }else{
                        new page_open().Open_window(event,"Loggedin Page","Logged_in.fxml",717, 523);
                    }


                    /*Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("");
                    alert.show();*/
                }
                else {
                    invalid_login.setText("Invalid Login! Please Try again.");
                }
            }
            queryresult.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void view_information(String table ,String user_email_login,String user_pass_login){

        Database_controller connectnew= new Database_controller();
        Connection connectiondb= connectnew.login();
        String query1= "SELECT full_name, email, password, phone_number, nid, date_of_birth, gender, present_address, permanent_address, designation FROM "+table+" WHERE email = '"+user_email_login+"' AND password ='"+user_pass_login+"'";

        try {
            Statement statement = connectiondb.createStatement();
            ResultSet get_value_from_db = statement.executeQuery(query1);
            while (get_value_from_db.next()) {
                String name = get_value_from_db.getString("full_name");
                String email = get_value_from_db.getString("email");
                String phone = get_value_from_db.getString("phone_number");
                String address = get_value_from_db.getString("present_address");
                value_set[0]=name;
                value_set[1]=email;
                value_set[2]=phone;
                value_set[3]=address;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void forget_password_handler(ActionEvent event){
        new forgetpassword().goto_forget_page(event);
    }


    @FXML
    void shakil_fb(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/profile.php?id=100036971298466"));
    }
    @FXML
    void hasib_fb(ActionEvent event)throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/dev.hasibulislam999"));
    }
    @FXML
    void subru_fb(ActionEvent event)throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/subrina.urmi.37"));
    }
    @FXML
    void sabbir_fb(ActionEvent event)throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/Tonmoy.0.you"));
    }
    @FXML
    void shakil_git(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://github.com/Shakil-Mahmud-Programmer"));
    }
    @FXML
    void sabbir_git(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://github.com/sh-mithu"));
    }

}