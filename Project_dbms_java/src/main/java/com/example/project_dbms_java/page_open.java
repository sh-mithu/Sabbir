package com.example.project_dbms_java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
        stage.setScene(new Scene(root[0], sizew, sizeh));
        stage.show();
    }
    public void Open_window1(ActionEvent event,String title,String file, int sizew,int sizeh){
        final Parent[] root = {null};

        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource(file));
            root[0] = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root[0], sizew, sizeh));
        stage.show();
    }
    @FXML
    private Label alert_txt;
    public void alert_window(ActionEvent event,String txt){
        alert_txt.setText(txt);
        final Parent[] root = {null};

        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("alert_window.fxml"));
            root[0] = loader.load();
            Stage stage=new Stage();
            //Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
            //stage.setTitle(title);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root[0], 279,180 ));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //ok_hanlder(event);

    }
    @FXML
    public void ok_hanlder(ActionEvent event){
        System.exit(1);
    }
}
