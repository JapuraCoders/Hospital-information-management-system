package Controller.ReceptionistDashBoardController;

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
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ReceptionistLogout");
        mainpane.setCenter(view);
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
