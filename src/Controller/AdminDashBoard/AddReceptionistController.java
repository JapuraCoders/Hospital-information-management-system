package Controller.AdminDashBoard;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddReceptionistController implements Initializable {

    @FXML
    private TextField receptionistName;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField nIC;

    @FXML
    private JFXComboBox<?> selectGender;

    @FXML
    private TextField userName;

    @FXML
    private DatePicker Dob;

    @FXML
    private JFXComboBox<?> selectMaritalStatus;

    @FXML
    private TextField address;

    @FXML
    private JFXButton close;

    public AddReceptionistController() throws IOException {
    }


    @FXML
    void AddReceptionist(ActionEvent event) {

    }


    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
