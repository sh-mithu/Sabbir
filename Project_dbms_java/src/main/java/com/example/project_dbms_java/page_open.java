package com.example.project_dbms_java;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class page_open {
    public void Open_window(ActionEvent event,String title,String file, int sizew,int sizeh){
        final Parent[] root = {null};

        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource(file));
            root[0] = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root[0], sizew,sizeh ));
        stage.show();
    }
}
