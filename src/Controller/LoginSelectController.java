package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginSelectController implements Initializable {

    @FXML
    private Button patientBtn;

    @FXML
    private Button medicalOfficerBtn;

    @FXML
    private Button receptionistBtn;

    @FXML
    private Button adminBtn;

    @FXML
    void handleClose(MouseEvent event) {

        System.exit(0);
    }

    @FXML
    void selectAdmin(javafx.event.ActionEvent event) throws IOException {
        Stage stage =(Stage) adminBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/View/adminLogin.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void selectMedicalOfficer(javafx.event.ActionEvent event) throws IOException {
        Stage stage =(Stage) medicalOfficerBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/View/medicalOfficerLogin.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    public void selectPatient(javafx.event.ActionEvent event) throws IOException {
        Stage stage =(Stage) patientBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/View/PatientLogin.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void selectReceptionist(javafx.event.ActionEvent event) throws IOException {
        Stage stage =(Stage) receptionistBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/View/ReceptionistLogin.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
