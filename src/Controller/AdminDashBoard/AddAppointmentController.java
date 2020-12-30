package Controller.AdminDashBoard;

import Model.Appointment;
import Model.AppointmentRecord;
import Model.AppointmentStatus;
import Model.Reference;
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
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddAppointmentController<line> implements Initializable {

    @FXML
    private Label errorMsg;

    @FXML
    private Label AppointmentNo;

    @FXML
    private TextField PatientName;

    @FXML
    private TextField Symptoms;

    @FXML
    private TextField username;


    @FXML
    private JFXComboBox<String> specialityAreaCombo;
    Reference doctorSpecialtyArea = new Reference("Files/Data/DoctorSpecialtyArea.txt");
    private ObservableList<String> dbTypeList = FXCollections.observableArrayList(doctorSpecialtyArea.view());

    @FXML
    private JFXComboBox<String> SelectDoctorCombo;
    Reference doctorList = new Reference("Files/Data/DoctorSpecialtyArea.txt");
    private ObservableList<String> docList = FXCollections.observableArrayList(doctorList.view());


    @FXML
    private JFXComboBox<String> TimeCombo;
    Reference doctorTime = new Reference("Files/Data/DoctorShedule.txt");
    private ObservableList<String> docTimeList = FXCollections.observableArrayList(doctorTime.view());
    @FXML
    private DatePicker date;




    @FXML
    private JFXButton close;

    public AddAppointmentController() throws IOException {


    }



    @FXML
    void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        specialityAreaCombo.setItems(dbTypeList);
        SelectDoctorCombo.setItems(docList);
        TimeCombo.setItems(docTimeList);
    }


    public void addAppointment(ActionEvent event) {
        try {
            String inputPatientName = PatientName.getText().trim();

            String inputSymptoms = Symptoms.getText().trim();
            String selectedDoctor = SelectDoctorCombo.getValue();
            String selectedSpecialityArea = specialityAreaCombo.getValue();
            String selectedDate = date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String selectedTime = TimeCombo.getValue();


            Appointment apt = new Appointment(inputPatientName, java.util.Calendar.getInstance().getTime(), inputSymptoms, AppointmentStatus.PENDING, selectedDoctor, selectedSpecialityArea, selectedDate, selectedTime);
            AppointmentRecord aptRecord = new AppointmentRecord("Files/Details/AppointmentData.txt");
            aptRecord.add(apt);



        }catch (Exception e){
            errorMsg.setText("Invalid Fields please Complete the Form !");
        }
    }
}
