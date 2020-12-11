package Controller.AdminDashBoard;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminDashBoardController implements Initializable {

    @FXML
    private Pane mainPane;

    @FXML
    private JFXButton btnHome;

    @FXML
    private JFXButton btnAppointments;

    @FXML
    private JFXButton btnComplaints;

    @FXML
    private JFXButton btnPatients;

    @FXML
    private JFXButton btnMedicalOfficer;

    @FXML
    private JFXButton btnReceptionist;

    @FXML
    private JFXButton btnModule;

    @FXML
    private JFXButton btnSettings;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private StackPane contentArea;

    @FXML
    private Label exit;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exit.setOnMouseClicked(e->{
            System.exit(0);
        });

        }

    @FXML
    void HandlePatient(ActionEvent event) {
        System.out.println("you clicked me");
        FXMLLoader object = new FXMLLoader();
        pane view = object.getPane("AdminHome.fxml");
        mainPane.setCenter(view);

    }

    @FXML
    void handleAppointment(ActionEvent event) {

    }

    @FXML
    void handleComplaint(ActionEvent event) {

    }

    @FXML
    void handleHome(ActionEvent event) {

    }

    @FXML
    void handleMedical(ActionEvent event) {

    }

    @FXML
    void handleModule(ActionEvent event) {

    }

    @FXML
    void handleReceptionist(ActionEvent event) {

    }

    @FXML
    void handleSetting(ActionEvent event) {

    }



}



