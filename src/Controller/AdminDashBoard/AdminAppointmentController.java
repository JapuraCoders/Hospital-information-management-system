package Controller.AdminDashBoard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminAppointmentController implements Initializable {
    @FXML //  fx:id="tableView"
    private TableView<?> tableView; // Value injected by FXMLLoader

    @FXML
    private TableColumn<?, ?> no;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> nic;

    @FXML
    private TableColumn<?, ?> assignedDoctor;

    @FXML
    private TableColumn<?, ?> dateAndTime;

    @FXML
    private TableColumn<?, ?> edit;







    @FXML
    private Label appointCounterLabel;


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
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'tableview.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}