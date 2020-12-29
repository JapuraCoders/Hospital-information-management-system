package Controller.PatientDashBoardController;

import Model.Appointment;
import Model.AppointmentRecord;
import Model.AppointmentStatus;
import Model.Reference;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class PatientAppointmentController implements Initializable {

    @FXML
    private Label AppointmentNo;
    @FXML
    private Label errorMsg;

    @FXML
    private TextField PatientName;

    @FXML
    private TextField Symptoms;

    @FXML
    private JFXComboBox<String> specialityAreaCombo;
    Reference doctorSpecialtyArea = new Reference("Files/Data/DoctorSpecialtyArea.txt");
    private ObservableList<String> dbTypeList = FXCollections.observableArrayList(doctorSpecialtyArea.view());

    @FXML
    private JFXComboBox<String> SelectDoctorCombo;
    Reference doctorList = new Reference("Files/Data/DoctorSpecialtyArea.txt");
    private ObservableList<String> docList = FXCollections.observableArrayList(doctorList.view());


    @FXML
    private DatePicker date;


    @FXML
    private JFXComboBox<String> TimeCombo;
    Reference doctorTime = new Reference("Files/Data/DoctorShedule.txt");
    private ObservableList<String> docTimeList = FXCollections.observableArrayList(doctorTime.view());

    public PatientAppointmentController() throws IOException {
    }


    public void addAppointment(javafx.event.ActionEvent event) throws IOException {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AppointmentNo.setText(String.valueOf(Appointment.appointmentCounter+1));
        specialityAreaCombo.setItems(dbTypeList);
        SelectDoctorCombo.setItems(docList);
        TimeCombo.setItems(docTimeList);
    }



    }

