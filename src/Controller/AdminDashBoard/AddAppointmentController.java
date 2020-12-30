package Controller.AdminDashBoard;

import Model.Reference;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddAppointmentController<line> implements Initializable {

    @FXML
    private TextField username;


    @FXML
    private JFXComboBox<String> specialityAreaCombo;
    Reference doctorSpecialtyArea = new Reference("Files/Data/DoctorSpecialtyArea.txt");
    private ObservableList<String> dbTypeList = FXCollections.observableArrayList(doctorSpecialtyArea.view());

    @FXML
    private JFXComboBox<String> DoctorCombo;

    @FXML
    private JFXComboBox<String> TimeCombo;

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
    }


    public void addAppointment(ActionEvent event) {
    }
}
