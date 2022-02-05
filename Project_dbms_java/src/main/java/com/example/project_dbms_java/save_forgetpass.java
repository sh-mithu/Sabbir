package com.example.project_dbms_java;

public class save_forgetpass {
  /*  @FXML
    private TextField reset_codetxt;
    @FXML
    private TextField passwordtxt;
    @FXML
    private TextField c_passwordtxt;
    @FXML
    private Label invalide_code;

    public  void save_handler_value(ActionEvent event,int code,String email) {
        new page_open().Open_window(event,"","forgetpassword.fxml",717,523);
        System.out.println(code);
        String recode=String.valueOf(code);
        String s=reset_codetxt.getText();
        System.out.println(s);

        if(s.equals(recode)){
            if(passwordtxt.getText().isBlank()||c_passwordtxt.getText().isBlank()){
                invalide_code.setText("Please, Fill up passwords!");
            }
            else if(passwordtxt.getText()!= c_passwordtxt.getText()){
                invalide_code.setText("Please, match both passwords!");
            }
            else if(passwordtxt.getText().equals(c_passwordtxt.getText())){
                String query="UPDATE `login_information` SET `Password`='"+passwordtxt.getText()+"' WHERE `Email`='"+email+"';";
                new Database_controller().update(query);
                //save_handler(event);
            }

        }
        else{
            invalide_code.setText("Invalide Code");
        }
    }

    public void save_handler(ActionEvent event) {
        new page_open().Open_window(event,"Log In","Login_page.fxml",717, 523);
    }*/


}
