package com.example.project_dbms_java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class Signup_page implements Initializable {
    @FXML
    private Button sign_up_button;
    //choice box
    @FXML
    private ChoiceBox<String> choicbox_signup_button;
    private String[] employee_level= {"Admin","Genitors","Stuffs","Workers"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choicbox_signup_button.getItems().addAll(employee_level);
        choicbox_signup_button.setOnAction(event -> getEmployeelevel_signup());
    }
    //void signup
    public String getEmployeelevel_signup(){
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
    private TextField gendertxt;
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


        String a=getEmployeelevel_signup();

        Date datein=new Date();
        String name=nametxt.getText();
        String email=emailtxt.getText();
        String pass=passwordtxt.getText();
        //int phone= Integer.parseInt(phonetxt.getText());
        //int phone=Integer.valueOf(phonetxt.getText());
        String phone=phonetxt.getText();
        LocalDate date_set=date.getValue();
        String nid=nidtxt.getText();
        String pre_address=presentaddresstxt.getText();
        String par_address=permanentaddresstxt.getText();
        String gender=gendertxt.getText();

         Database_controller controller=new Database_controller();
        /*String query_loginfo="INSERT INTO `login_information`(`Email`, `Password`, `Designation`) VALUES ('"+email+"','"+pass+"','"+a+"')";
        controller.save_value("INSERT INTO workers VALUES ("+"'"+name+"'"+","+"'"+email+"'"+","+"'"+pass+"'"+","+"'"+phone+"'"+","+date_set+","+"'"+nid+"'"+","+"'"+gender+"'"+","+"'"+pre_address+"'"+","+"'"+par_address+"'"+","+"'"+a+"'"+");");
        //controller.save_value(query_loginfo);
        goto_after_login(event);
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("");
        alert.show();*/

        if (emailtxt.getText().isBlank() || nidtxt.getText().isBlank()||passwordtxt.getText().isBlank()||nametxt.getText().isBlank()){
            invalid_signup.setText("Please Fill up all Information!");
        }
        else if(a.equals("admin")){
            String query_allinfo=("INSERT INTO admin VALUES ('"+name+"','"+email+"','"+pass+"','"+phone+"','"+nid+"','"+date_set+"','"+gender+"','"+pre_address+"','"+par_address+"','"+a+"');");

            String query_loginfo="INSERT INTO `login_information`(`Email`, `Password`, `Designation`) VALUES ('"+email+"','"+pass+"','Admin')";
            controller.save_value(query_allinfo);
            controller.save_value(query_loginfo);
            goto_after_login(event);
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("");
            alert.show();

        }
        else if(a.equals("genitors")){
            String query_allinfo=("INSERT INTO genitors VALUES ('"+name+"','"+email+"','"+pass+"','"+phone+"','"+nid+"','"+date_set+"','"+gender+"','"+pre_address+"','"+par_address+"','"+a+"');");

            String query_loginfo="INSERT INTO `login_information`(`Email`, `Password`, `Designation`) VALUES ('"+email+"','"+pass+"','Genitors')";
            controller.save_value(query_allinfo);
            controller.save_value(query_loginfo);
            goto_after_login(event);
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("");
            alert.show();
        }
        else if(a.equals("stuffs")){
            String query_allinfo=("INSERT INTO stuffs VALUES ('"+name+"','"+email+"','"+pass+"','"+phone+"','"+nid+"','"+date_set+"','"+gender+"','"+pre_address+"','"+par_address+"','"+a+"');");

            String query_loginfo="INSERT INTO `login_information`(`Email`, `Password`, `Designation`) VALUES ('"+email+"','"+pass+"','Stuffs')";
            controller.save_value(query_allinfo);
            controller.save_value(query_loginfo);
            goto_after_login(event);
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("");
            alert.show();
        }
        else if(a.equals("workers")){
            String query_allinfo=("INSERT INTO workers VALUES ('"+name+"','"+email+"','"+pass+"','"+phone+"','"+nid+"','"+date_set+"','"+gender+"','"+pre_address+"','"+par_address+"','"+a+"');");

            String query_loginfo="INSERT INTO `login_information`(`Email`, `Password`, `Designation`) VALUES ('"+email+"','"+pass+"','"+a+"')";
            controller.save_value(query_allinfo);
            controller.save_value(query_loginfo);
            goto_after_login(event);
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("");
            alert.show();
        }

    }

    @FXML
    public void back_button(ActionEvent event){
        new page_open().Open_window(event,"","Login_page.fxml",717,523);
    }

    public void goto_after_login(ActionEvent event){
        new page_open().Open_window(event,"","after_signup.fxml",717, 523);
    }

}