package Controller.PatientDashBoardController;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;


public class PatientDashBoardController implements Initializable{

    @FXML
    private BorderPane mainpane;



    @FXML
    void HandlePatientAppointment(javafx.event.ActionEvent event) {


        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("PatientAppointment");
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
        Pane view = object.getPage("PatientComplaint");
        mainpane.setCenter(view);
    }


    @FXML
    void handlePatientSetting(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("PatientSetting");
        mainpane.setCenter(view);
    }


    @FXML
    void HandlePatientLogout(javafx.event.ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("PatientHome");
        mainpane.setCenter(view);
    }

}
