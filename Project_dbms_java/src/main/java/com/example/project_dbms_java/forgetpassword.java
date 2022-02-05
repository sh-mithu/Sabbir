package com.example.project_dbms_java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;


public class forgetpassword {
    @FXML
    private TextField email_txt_forgetpass;
    @FXML
    private TextField reset_codetxt;
    @FXML
    private TextField passwordtxt;
    @FXML
    private TextField c_passwordtxt;
    @FXML
    private Label invalide_code;
    public static String[] code_string={"null12","innocent.noreply@gmail.com"};


    public void goto_forget_page(ActionEvent event){
        new page_open().Open_window(event,"","forgetpassword_sentcode.fxml",717,523);
    }
    public void back_login_to_forget(ActionEvent event){
        new page_open().Open_window(event,"Log In","Login_page.fxml",717, 523);
    }



    @FXML
    public void send_code_handler(ActionEvent event) throws Exception {
         String re_mail=email_txt_forgetpass.getText();
         code_string[1]=re_mail;
         String code=random_code();

        //System.out.println(code_string[0]);

        send_mail.sendmail(re_mail,code);
        new page_open().Open_window(event,"","forgetpassword.fxml",717,523);
        //System.out.println(a);
    }



    public static String random_code(){
        Random random = new Random();
        int code = random.nextInt(1000000);
        String a=(String.format("%06d", code));
        System.out.println(a);
        /*int i=Integer.parseInt(a);*/
        code_string[0]=a;
        return a;
    }

    public void save_handler(ActionEvent event) {
        String a=reset_codetxt.getText();
        if(reset_codetxt.getText().equals(code_string[0])){

            if(passwordtxt.getText().isBlank()||c_passwordtxt.getText().isBlank()){
                invalide_code.setText("Please, Fill up passwords!");
            }
            else if(passwordtxt.getText().equals(c_passwordtxt.getText())){
                String query="UPDATE `login_information` SET `Password`='"+passwordtxt.getText()+"' WHERE `Email`='"+code_string[1]+"';";
                new Database_controller().update(query);
                new page_open().Open_window(event,"Log In","Login_page.fxml",717, 523);
            }
            else{
                invalide_code.setText("Please, match both passwords!");
            }

        }
        else{
            invalide_code.setText("Invalide Code");
        }
    }
}
