package Controller;


import Model.Account;
import Model.AccountRecord;
import Model.Login;
import Model.LoginRecord;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;



public  class PatientLoginController implements Initializable {
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;


    @FXML
    private JFXButton signInBtn;

    @FXML
    private Label errorMsg;

    @FXML
    private JFXButton close;

    @FXML
    private JFXButton back;


    @FXML
    void handleSignInBtn(ActionEvent event) throws IOException {
        {

            String userNameInput = username.getText().trim();
            String passwordInput = password.getText().trim();

            try {
                AccountRecord patientAccRecord= new AccountRecord("Files/Details/PatientData.txt");
                LoginRecord loginRecord =new LoginRecord("Files/Details/PatientLoginDetails.txt");
                Login loginData= new Login(userNameInput,passwordInput, Calendar.getInstance().getTime());
                ArrayList<Account> sArray = patientAccRecord.viewAllAccounts();
                int i;
                for (  i=1 ;i<sArray.size();i++);
                {


                    if (userNameInput.equals(sArray.get(i-1).getUser().getUserName()) && passwordInput.equals(sArray.get(i-1).getPassword()))
                    {


                        Stage stage =(Stage) signInBtn.getScene().getWindow();
                        stage.close();
                        Stage primaryStage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("/View/PatientDashBoard/PatientDashBoard.fxml"));
                        primaryStage.initStyle(StageStyle.DECORATED);
                        primaryStage.setScene(new Scene(root));
                        primaryStage.show();
                        loginData.setLoginStatus(true);


                    }

                    else{
                        errorMsg.setText("Invalid UserName or Password!");
                        loginData.setLoginStatus(false);
                   }

                }
                loginRecord.add(loginData);


            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null,
                        "User Database Not Found", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    }


    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    public void handleBackButtonAction(javafx.event.ActionEvent event) throws IOException {
        Stage stage =(Stage) back.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/View/LoginSelect.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
