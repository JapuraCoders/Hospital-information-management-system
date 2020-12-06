package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MedicalOfficerLoginController implements Initializable{

        @FXML
        private TextField username;

        @FXML
        private PasswordField password;


        @FXML
        private void handleClose(MouseEvent event) {
                System.exit(0);
        }


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

        }

}
