
package Controller.AdminDashBoard;

import Model.*;
import com.jfoenix.controls.JFXComboBox;
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

public class AddPatientController implements Initializable {

    @FXML
    private TextField PatientName;

    @FXML
    private TextField PhoneNumber;

    @FXML
    private TextField NIC;

    @FXML
    private JFXComboBox<Model.Gender> SelectGender;



    @FXML
    private TextField username;

    @FXML
    private DatePicker Dob;

    @FXML
    private JFXComboBox<MaritalStatus> selectMaritalStatus;;



    @FXML
    private TextField Address;

    @FXML
    private JFXComboBox<BloodType> selectBloodGroup;


    @FXML
    private TextField Allergies;

    @FXML
    private Label closeLabel;

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");





    @FXML
    public void AddPatient(javafx.event.ActionEvent event) throws ParseException {
        String inputPatientName = PatientName.getText().trim();

        String inputPhoneNum = PhoneNumber.getText().trim();
        String inputNIC = NIC.getText().trim();
        Gender selectedGender = SelectGender.getValue();
        String inputUserName = username.getText().trim();

        Date inputDOB = formatter.parse(Dob.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        MaritalStatus selectedMaritalStatus = selectMaritalStatus.getValue();
        String inputAddress = Address.getText().trim();
        BloodType selectBloodType = selectBloodGroup.getValue();
        String inputAllergies = Allergies.getText().trim();


        Patient pat = new Patient(inputPatientName, inputPhoneNum, inputNIC, inputUserName, selectedGender, inputDOB, inputAddress, selectedMaritalStatus, selectBloodType, inputAllergies);
        System.out.println(pat);
        Account patientAccount = new Account(UserType.PATIENT, pat);

        AccountRecord patientRecord = new AccountRecord("Files/Details/PatientData.txt");

        try {
            patientRecord.add(patientAccount);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void handleClose(javafx.scene.input.MouseEvent mouseEvent) {
        Stage stage = (Stage) closeLabel.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {


        SelectGender.getItems().addAll(Gender.values());
        selectMaritalStatus.getItems().addAll(MaritalStatus.values());
        selectBloodGroup.getItems().addAll(BloodType.values());
    }


}




