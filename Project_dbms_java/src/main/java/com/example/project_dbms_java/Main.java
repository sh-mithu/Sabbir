package com.example.project_dbms_java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("forgetpassword_sentcode.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 717, 523);
        stage.setTitle("Login Page");
        //scene.getStylesheets().add("styles.css");
        stage.setScene(scene);
        stage.show();
    }
    public static void main() {
        launch();
    }
}