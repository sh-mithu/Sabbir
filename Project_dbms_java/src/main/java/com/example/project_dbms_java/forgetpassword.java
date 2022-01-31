package com.example.project_dbms_java;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class forgetpassword {

    @FXML
    public void save_handler(ActionEvent event){
        new page_open().Open_window(event,"Log In","Login_page.fxml",717, 523);
    }


    public void goto_forget_page(ActionEvent event){
        new page_open().Open_window(event,"","forgetpassword_sentcode.fxml",717,523);
    }

    @FXML
    public void send_code_handler(ActionEvent event){
        new page_open().Open_window(event,"","forgetpassword.fxml",368,268);
    }
}
