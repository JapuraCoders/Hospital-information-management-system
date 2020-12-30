package Controller.AdminDashBoard;

import Model.Appointment;
import Model.AppointmentRecord;
import Model.AppointmentStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class AdminAppointmentController implements Initializable {
    @FXML //  fx:id="tableView"
    private TableView<Appointment> tableView; // Value injected by FXMLLoader
    @FXML
    private Label appointCounterLabel;

    @FXML
    private TableColumn<Appointment,String> aptNo;

    @FXML
    private TableColumn<Appointment, Date> TimeStamp;

    @FXML
    private TableColumn<Appointment, String> patientName;

    @FXML
    private TableColumn<Appointment, String> medicalOfficer;

    @FXML
    private TableColumn<Appointment,String> specialtyArea;

    @FXML
    private TableColumn<Appointment, AppointmentStatus> status;

    @FXML
    private TableColumn<Appointment,String> date;

    @FXML
    private TableColumn<Appointment, String> Time;

    public AdminAppointmentController() throws IOException {
    }

    @FXML
    void AddAppointment(ActionEvent event) {

    }
    @FXML
    void AddAppointment(javafx.event.ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/View/AdminDashBoard/AddAppointment.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    @FXML
    void ExportData(ActionEvent event) {


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'tableview.fxml'.";
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        try {
            AppointmentRecord aptRecord = new AppointmentRecord("Files/Details/AppointmentData.txt");
            ArrayList<Appointment> appointmentArrayList = aptRecord.viewAllAppointments();
            int appointmentCount = appointmentArrayList.size();
            ObservableList<Appointment> appointmentData = FXCollections.observableArrayList();
            for (int i = 0; i < appointmentCount; i++) {
                appointmentData.add(appointmentArrayList.get(i));
            }

            aptNo.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
            TimeStamp.setCellValueFactory(new PropertyValueFactory<>("appointmentDateAndTime"));
            patientName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
            medicalOfficer.setCellValueFactory(new PropertyValueFactory<>("medicalOfficerName"));
            specialtyArea.setCellValueFactory(new PropertyValueFactory<>("medicalOfficerSpeciality"));
            status.setCellValueFactory(new PropertyValueFactory<>("appointmentStatus"));
            date.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
            Time.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));

            tableView.setItems(appointmentData);

        } catch (Exception e) {

        }
    }
}