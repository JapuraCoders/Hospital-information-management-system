package Controller.AdminDashBoard;


import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddMedicalOfficerController implements Initializable {

    @FXML
    private TextField MedicalOfficerName;

    @FXML
    private TextField PhoneNumber;

    @FXML
    private TextField NIC;

    @FXML
    private JFXComboBox<?> SelectGender;

    @FXML
    private TextField username;

    @FXML
    private DatePicker Dob;

    @FXML
    private JFXComboBox<?> selectMaritalStatus;

    @FXML
    private JFXComboBox<?> selectSpecialtyArea;

    @FXML
    private TextField Address;

    @FXML
    private TextField email;

    @FXML
    private Label closeLabel;

    @FXML
    void AddMedicalOfficer(ActionEvent event) {

    }

    @FXML
    void handleClose(javafx.scene.input.MouseEvent mouseEvent) {
        Stage stage = (Stage) closeLabel.getScene().getWindow();
        stage.close();
    }






    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }





}
