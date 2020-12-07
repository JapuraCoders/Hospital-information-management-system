package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashBoardController implements Initializable {

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
    private Pane pniStatus;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblStatusMin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void handleclick(ActionEvent event){
         if (event.getSource() ==btnHome)
         {

         }
         else if(event.getSource() ==btnAppointments)
         {

         }
         else if(event.getSource() ==btnComplaints)
         {

         }
         else if(event.getSource() ==btnPatients)
         {

         }
         else if(event.getSource() ==btnMedicalOfficer)
         {

         }
         else if(event.getSource() ==btnReceptionist)
         {

         }
         else if(event.getSource() ==btnModule)
         {

         }
         else if(event.getSource() ==btnSettings)
         {

         }
         else if(event.getSource() ==btnLogout)
         {

         }
    }
}
