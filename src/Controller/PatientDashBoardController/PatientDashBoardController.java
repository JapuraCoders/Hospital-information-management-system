package Controller.PatientDashBoardController;


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

public class PatientDashBoardController implements Initializable{

    @FXML
    private BorderPane mainpane;



    @FXML
    void HandlePatientAppointment(javafx.event.ActionEvent event) {


        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("PatientAppointments");
        mainpane.setCenter(view);

    }

    @FXML
    void HandlePatientHome(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("PatientHome");
        mainpane.setCenter(view);
    }


    @FXML
    void handlePatientComplaint(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("PatientComplaints");
        mainpane.setCenter(view);
    }


    @FXML
    void handlePatientSetting(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("PatientSettings");
        mainpane.setCenter(view);
    }


    @FXML
    void HandlePatientLogout(javafx.event.ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
