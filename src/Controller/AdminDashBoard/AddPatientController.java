package Controller.AdminDashBoard;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddPatientController {

    @FXML
    private TextField username;

    @FXML
    private TextField username1111;

    @FXML
    private TextField username1;

    @FXML
    private TextField username11111;

    @FXML
    private TextField username11;

    @FXML
    private TextField username111111;

    @FXML
    private TextField username111;

    @FXML
    private TextField username1111111;

    @FXML
    private TextField username1112;

    @FXML
    private TextField username11111111;

    @FXML
    private JFXButton signInBtn;
    @FXML
    private Label closeLabel;

    @FXML
    void handleClose(MouseEvent event) {

        Stage stage =(Stage) closeLabel.getScene().getWindow();
        stage.close();
    }
}
