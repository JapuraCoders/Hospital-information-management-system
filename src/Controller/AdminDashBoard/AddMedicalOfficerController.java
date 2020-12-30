package Controller.AdminDashBoard;


import Model.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class AddMedicalOfficerController implements Initializable {

    @FXML
    private TextField MedicalOfficerName;

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
    private JFXComboBox<MaritalStatus> selectMaritalStatus;


    @FXML
    private JFXComboBox<String> selectSpecialtyArea;
    Reference doctorSpecialtyArea = new Reference("Files/Data/DoctorSpecialtyArea.txt");
    private ObservableList<String> dbTypeList = FXCollections.observableArrayList(doctorSpecialtyArea.view());

    @FXML
    private TextField Address;

    @FXML
    private TextField email;

    @FXML
    private JFXButton close;

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public AddMedicalOfficerController() throws IOException {
    }

    @FXML
    void AddMedicalOfficer(ActionEvent event) throws ParseException {
        String inputMedicalOfficerName = MedicalOfficerName.getText().trim();

        String inputPhoneNum = PhoneNumber.getText().trim();
        String inputNIC = NIC.getText().trim();
        Gender selectedGender = SelectGender.getValue();
        String inputUserName = username.getText().trim();

        Date inputDOB = formatter.parse(Dob.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        MaritalStatus selectedMaritalStatus = selectMaritalStatus.getValue();
        String inputAddress = Address.getText().trim();
        String inputSpecialtyArea = selectSpecialtyArea.getValue();
        String inputEmail = email.getText().trim();


       Staff mo = new Staff(inputMedicalOfficerName, inputPhoneNum, inputNIC, inputUserName, selectedGender, inputDOB, inputAddress, selectedMaritalStatus, inputSpecialtyArea, inputEmail);
        System.out.println(mo);
        Account medicalOfficerAccount = new Account(UserType.MEDICALOFFICER, mo);

        AccountRecord MedicalOfficerRecord = new AccountRecord("Files/Details/MedicalOfficerData.txt");

        try {
            MedicalOfficerRecord.add(medicalOfficerAccount);
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
        selectSpecialtyArea.setItems(dbTypeList);;
    }





}
