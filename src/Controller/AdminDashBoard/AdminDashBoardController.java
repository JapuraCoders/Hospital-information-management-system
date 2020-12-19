package Controller.AdminDashBoard;

import Controller.FxmlLoader;
import com.sun.glass.ui.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashBoardController implements Initializable {

    @FXML
    private BorderPane mainpane;



    @FXML
    void HandleAdminAppointment(javafx.event.ActionEvent event) {


        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("AdminAppointments");
        mainpane.setCenter(view);

    }

    @FXML
    void HandleAdminHome(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("AdminHome");
        mainpane.setCenter(view);
    }


    @FXML
    void HandleAdminPatient(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("AdminPatient");
        mainpane.setCenter(view);
    }

    @FXML
    void handleAdminComplaint(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("AdminComplaints");
        mainpane.setCenter(view);
    }

    @FXML
    void handleAdminModule(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("AdminModule");
        mainpane.setCenter(view);
    }

    @FXML
    void handleAdminReceptionist(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("AdminReceptionist");
        mainpane.setCenter(view);
    }

    @FXML
    void handleAdminSetting(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("AdminSettings");
        mainpane.setCenter(view);
    }

    @FXML
    void handleMedicalOfficerMedical(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("AdminMedicalOfficer");
        mainpane.setCenter(view);
    }


    @FXML
    void HandleAdminLogout(javafx.event.ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
