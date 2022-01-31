package com.example.project_dbms_java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

public class Login_page implements Initializable {
    @FXML
    private Label login_success_text;
    @FXML
    private Button goto_signup;
    @FXML
    private Button Log_out;
    @FXML
    private TextField user_name_login;
    @FXML
    private TextField user_pass_login;

    @FXML
    private Label invalid_login;
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
        /*final Parent[] root = {null};

                try {
                    FXMLLoader loader= new FXMLLoader(getClass().getResource("signup_page.fxml"));
                    root[0] = loader.load();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Sign Up");
                stage.setScene(new Scene(root[0], 680, 540));
                stage.show();*/
        new page_open().Open_window(event,"Sign Up","signup_page.fxml",680, 540);
    }
    public void loginhandler(ActionEvent event){
        String a=getEmployeelevel();
        System.out.println(user_name_login.getText());
        System.out.println(user_pass_login.getText());
        if (user_name_login.getText().isBlank()==false && user_pass_login.getText().isBlank()){
            invalid_login.setText("Please Enter Password!");
        }
        else if (user_name_login.getText().isBlank() &&user_pass_login.getText().isBlank()==false){
            invalid_login.setText("Please Enter Email!");
        }
        else if (user_name_login.getText().isBlank() && user_pass_login.getText().isBlank()){
            invalid_login.setText("Please Enter Email and Password!");
        }
        else if(a.equals("admin")){
            connetion(a,"Admin",event);

        }
        else if(a.equals("genitors")){
            connetion(a,"Genitors",event);
        }
        else if(a.equals("stuffs")){
            connetion(a,"Stuffs",event);
        }
        else if(a.equals("workers")){
            connetion(a,"Workers",event);
        }
    }

    public void connetion(String a,String des, ActionEvent event){
        Database_controller connectnew= new Database_controller();
        Connection connectiondb= connectnew.getDatabaselink();
        String query= "SELECT count(1) FROM "+a+" WHERE Email = '" + user_name_login.getText() +"' AND Password = '"+user_pass_login.getText()+"' AND Designation = '"+des+"'";
        try {
            invalid_login.setText("");
            Statement statement = connectiondb.createStatement();
            ResultSet queryresult= statement.executeQuery(query);
            while(queryresult.next()){
                if(queryresult.getInt(1)==1){
                    new page_open().Open_window(event,"Loggedin Page","Logged_in.fxml",680, 540);
                }
                else {
                    invalid_login.setText("Invalid Login! Please Try again.");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void forget_password_handler(ActionEvent event){
        new forgetpassword().goto_forget_page(event);
    }
}
