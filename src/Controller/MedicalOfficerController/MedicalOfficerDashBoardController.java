package Controller.MedicalOfficerController;

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
