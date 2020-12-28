package Controller;



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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;



public  class PatientLoginController implements Initializable {
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label label;

    @FXML
    private JFXButton signInBtn;

    @FXML
    private Label errorMsg;


    @FXML
    void handleSignInBtn(ActionEvent event) throws IOException {
        {

            String userNameInput = username.getText().trim();
            String passwordInput = password.getText().trim();

            try {
                Scanner in = new Scanner(new File("Files/Data/Credentials/AdminUserCredentials.txt"));
                while (in.hasNextLine())
                {
                    String s = in.nextLine();
                    String[] sArray = s.split(",");

                    if (userNameInput.equals(sArray[0]) && passwordInput.equals(sArray[1]))
                    {
                        Stage stage =(Stage) signInBtn.getScene().getWindow();
                        stage.close();
                        Stage primaryStage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("/View/PatientDashBoard/PatientDashBoard.fxml"));
                        primaryStage.initStyle(StageStyle.DECORATED);
                        primaryStage.setScene(new Scene(root));
                        primaryStage.show();
                    }
                    else{
                        errorMsg.setText("Invalid UserName or Password!");
                    }

                }

                in.close();

            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null,
                        "User Database Not Found", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    }




    @FXML
    private void handleClose(MouseEvent event) {
        System.exit(0);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
