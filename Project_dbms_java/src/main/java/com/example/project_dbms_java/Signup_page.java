package com.example.project_dbms_java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.sql.Connection;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Signup_page implements Initializable {
    @FXML
    private Button sign_up_button;
    //choice box
    @FXML
    private ChoiceBox<String> choicbox_signup_button;
    private String[] employee_level= {"admin","genitors","stuffs","workers"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choicbox_signup_button.getItems().addAll(employee_level);
        choicbox_signup_button.setOnAction(this::getEmployeelevel_signup);
    }
    //void signup
    public String getEmployeelevel_signup(ActionEvent event){
            String chooseemployee = choicbox_signup_button.getValue();
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
/*
 START Import FXML File
*/
    @FXML
    private TextField nametxt;
    @FXML
    private TextField emailtxt;
    @FXML
    private TextField passwordtxt;
    @FXML
    private TextField phonetxt;
    @FXML
    private DatePicker date;
    @FXML
    private CheckBox malecheck;
    @FXML
    private CheckBox femalecheck;
    @FXML
    private CheckBox othercheck;
    @FXML
    private TextField nidtxt;
    @FXML
    private TextField presentaddresstxt;
    @FXML
    private TextField permanentaddresstxt;
    @FXML
    private Label invalid_signup;
    @FXML
    public void sign_up_button_handler(ActionEvent event) {
        String a=getEmployeelevel_signup(event);
        String name=nametxt.getText();
        String email=emailtxt.getText();
        if (emailtxt.getText().isBlank() || nidtxt.getText().isBlank()||passwordtxt.getText().isBlank()||nametxt.getText().isBlank()){
            invalid_signup.setText("Please Fill up all Information!");
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
        goto_after_login(event);
    }

    @FXML
    public void back_button(ActionEvent event){
        new after_login().Log_out_button(event);
    }


    public void connetion(String a,String des, ActionEvent event){
     /*   Database_controller connectnew= new Database_controller();
        Connection connectiondb= connectnew.getDatabaselink();
        String query= "INSERT INTO `workers`(`full_name`, `email`, `password`, `phone_number`, `date_of_birth`, `nid_number`, `gender`, `present_address`, `permanent_address`, `designation`) VALUES (?,?,?,?,?,?,?,?,?,?);
    try {
        invalid_signup.setText("");
            Statement statement = connectiondb.prepareStatement(query);
            ResultSet queryresult= statement.executeQuery(query);
            while(queryresult.next()){
                if(queryresult.getInt(1)==1){
                    final Parent[] root = {null};
                    try {
                        FXMLLoader loader= new FXMLLoader(getClass().getResource("Logged_in.fxml"));
                        root[0] = loader.load();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle("Sign Up");
                    stage.setScene(new Scene(root[0], 680, 540));
                    stage.show();
                }
                else {
                    invalid_signup.setText("Invalid Login! Please Try again.");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/
    }


    public void goto_after_login(ActionEvent event){
        new page_open().Open_window(event,"","after_signup.fxml",340, 180);
    }

}
