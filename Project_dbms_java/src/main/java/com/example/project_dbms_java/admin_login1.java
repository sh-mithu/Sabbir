package com.example.project_dbms_java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class admin_login1 extends Login_page implements Initializable {

    @FXML
    private ChoiceBox<String> choicbox_login;
    private String[] employee_level= {"Admin","Genitors","Stuffs","Workers"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        user_nametxt.setText(value_set[0]);
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
    private Label user_nametxt;

    @FXML
    private TextField email_delete;
    public void Delete(ActionEvent event){
        String login_type=getEmployeelevel();
        new Database_controller().delete("DELETE FROM "+login_type+" WHERE email='"+email_delete.getText()+"';");
        new Database_controller().delete("DELETE FROM `login_information` WHERE email='"+email_delete.getText()+"';");
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Information Delete Successfull !");
        alert.show();

    }

    @FXML
    public void Log_out_button(ActionEvent event) {
        new page_open().Open_window(event,"","Login_page.fxml",717,523);
    }
    @FXML
    public void cancel(ActionEvent event) {
        new page_open().Open_window(event,"","admin_login.fxml",717,523);
    }

}