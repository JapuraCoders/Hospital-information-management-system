package Controller.AdminDashBoard;

import Model.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class AddAdminController implements Initializable {
    @FXML
    private TextField PatientName;

    @FXML
    private TextField PhoneNumber;

    @FXML
    private TextField NIC;

    @FXML
    private JFXComboBox<Model.Gender> SelectGender;

    @FXML
    private TextField Address;

    @FXML
    private DatePicker Dob;

    @FXML
    private JFXComboBox<BloodType> selectBloodGroup;

    @FXML
    private JFXComboBox<MaritalStatus> selectMaritalStatus;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private JFXButton close;

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @FXML
    void AddPatient(javafx.event.ActionEvent event) throws ParseException{
        String inputPatientName = PatientName.getText().trim();

        String inputPhoneNum = PhoneNumber.getText().trim();
        String inputNIC = NIC.getText().trim();
        Gender selectedGender = SelectGender.getValue();
        String inputUserName = username.getText().trim();

        Date inputDOB = formatter.parse(Dob.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        MaritalStatus selectedMaritalStatus = selectMaritalStatus.getValue();
        String inputAddress = Address.getText().trim();
        BloodType selectBloodType = selectBloodGroup.getValue();
        String inputPassword = password.getText().trim();


        User admin = new Patient(inputPatientName, inputPhoneNum, inputNIC, inputUserName, selectedGender, inputDOB, inputAddress, selectedMaritalStatus, selectBloodType, inputPassword);
        System.out.println(admin);
        Account adminAccount = new Account(UserType.ADMIN, admin);

        AccountRecord adminRecord = new AccountRecord("Files/Details/AdminData.txt");

        try {
            adminRecord.add(adminAccount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SelectGender.getItems().addAll(Gender.values());
        selectMaritalStatus.getItems().addAll(MaritalStatus.values());
        selectBloodGroup.getItems().addAll(BloodType.values());

    }

}
