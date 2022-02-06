package com.example.project_dbms_java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

//import java.awt.*;

public class after_login extends Login_page implements Initializable {
    @FXML
    private Label user_nametxt;
    @FXML
    private Label emailtxt;
    @FXML
    private Label phonetxt;
    @FXML
    private Label addresstxt;
    @FXML
    private Label sabbir;
    public String name,email,phone,address;
    public static Label static_label;
    @FXML
    public void Log_out_button(ActionEvent event) {
        new page_open().Open_window(event,"","Login_page.fxml",717,523);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        user_nametxt.setText(value_set[0]);
        emailtxt.setText(value_set[1]);
        phonetxt.setText(value_set[2]);
        addresstxt.setText(value_set[3]);
    }
}
