package Controller.ReceptionistDashBoardController;

import Controller.AdminDashBoard.FxmlLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ReceptionistDashBoardController implements Initializable{

    @FXML
    private BorderPane mainpane;

    @FXML
    void HandleReceptionistAppointment(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ReceptionistAppointment");
        mainpane.setCenter(view);
    }

    @FXML
    void HandleReceptionistHome(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ReceptionistHome");
        mainpane.setCenter(view);
    }

    @FXML
    void HandleReceptionistLogout(javafx.event.ActionEvent event) {

    }

    @FXML
    void handleReceptionistComplaint(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ReceptionistComplaint");
        mainpane.setCenter(view);
    }

    @FXML
    void handleReceptionistMail(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ReceptionistMail");
        mainpane.setCenter(view);
    }

    @FXML
    void handleReceptionistSetting(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ReceptionistSetting");
        mainpane.setCenter(view);
    }

    @FXML
    void handleReceptionistVisitor(javafx.event.ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ReceptionistVisitor");
        mainpane.setCenter(view);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
