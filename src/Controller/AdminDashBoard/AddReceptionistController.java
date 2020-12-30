package Controller.AdminDashBoard;

import Model.*;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class AddReceptionistController implements Initializable {

    @FXML
    private TextField receptionistName;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField nIC;

    @FXML
    private JFXComboBox<Model.Gender> selectGender;

    @FXML
    private TextField userName;

    @FXML
    private DatePicker Dob;

    @FXML
    private JFXComboBox<MaritalStatus> selectMaritalStatus;

    @FXML
    private TextField address;

    @FXML
    private JFXButton close;

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public AddReceptionistController() throws IOException, ParseException {
        String inputReceptionistName = receptionistName.getText().trim();

        String inputPhoneNum = phoneNumber.getText().trim();
        String inputNIC = nIC.getText().trim();
        Gender selectedGender = selectGender.getValue();
        String inputUserName = userName.getText().trim();

        Date inputDOB = formatter.parse(Dob.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        MaritalStatus selectedMaritalStatus = selectMaritalStatus.getValue();
        String inputAddress = address.getText().trim();




        Staff recep = new Staff(inputReceptionistName, inputPhoneNum, inputNIC, inputUserName, selectedGender, inputDOB, inputAddress, selectedMaritalStatus);
        System.out.println(recep);
        Account receptionistAccount = new Account(UserType.RECEPTIONIST, recep);

        AccountRecord ReceptionistRecord = new AccountRecord("Files/Details/ReceptionistData.txt");

        try {
            ReceptionistRecord.add(receptionistAccount);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        selectGender.getItems().addAll(Gender.values());
        selectMaritalStatus.getItems().addAll(MaritalStatus.values());

    }
}
