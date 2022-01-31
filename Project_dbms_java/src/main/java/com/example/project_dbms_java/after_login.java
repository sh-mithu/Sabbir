package com.example.project_dbms_java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class after_login {
    @FXML
    public void Log_out_button(ActionEvent event) {
        final Parent[] root = {null};

        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Login_page.fxml"));
            root[0] = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Log In");
        stage.setScene(new Scene(root[0], 717, 523));
        stage.show();
    }
}
