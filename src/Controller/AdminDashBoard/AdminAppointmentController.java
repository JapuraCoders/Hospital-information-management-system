package Controller.AdminDashBoard;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminAppointmentController implements Initializable {
    @FXML //  fx:id="tableView"
    private TableView<?> tableView; // Value injected by FXMLLoader

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'tableview.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}