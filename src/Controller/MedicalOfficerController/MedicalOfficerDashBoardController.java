package Controller.MedicalOfficerController;

import Controller.AdminDashBoard.FxmlLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MedicalOfficerDashBoardController implements Initializable {
    @FXML
    private BorderPane mainpane;



    @FXML
    void HandleMedicalOfficerAppointment(javafx.event.ActionEvent event) {


        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("MedicalOfficerAppointments");
        mainpane.setCenter(view);

    }

    @FXML
    void HandleMedicalOfficerHome(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("MedicalOfficerHome");
        mainpane.setCenter(view);
    }

    @FXML
    void handleMedicalOfficerSetting(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("MedicalOfficerSettings");
        mainpane.setCenter(view);
    }


    @FXML
    void HandleMedicalOfficerLogout(javafx.event.ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
