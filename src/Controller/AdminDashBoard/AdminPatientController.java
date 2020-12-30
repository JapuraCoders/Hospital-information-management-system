package Controller.AdminDashBoard;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
   
public class AdminPatientController implements Initializable {

    @FXML
    private TableView<Account> tableView;

    @FXML
    private TableColumn<Account,String> patientId;

  //  @FXML
  //  private TableColumn<Patient,String> name;

   // @FXML
   // private TableColumn<Patient,String > nic;

    //@FXML
    //private TableColumn<Patient,String > contactNumber;

  //  @FXML
   // private TableColumn<Patient,Gender> gender;

  //  @FXML
  //  private TableColumn<Patient,BloodType> bloodGroup;

   @FXML
    private TableColumn<Account,User> username;

    @FXML
    private TableColumn<Account,String> password;

   // @FXML
   // private TableColumn<Patient,String> edit;


    @FXML
    void AddPatient(javafx.event.ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/View/AdminDashBoard/AddPatient.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'tableview.fxml'.";
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        try {
            AccountRecord actRecord = new AccountRecord("Files/Details/PatientData.txt");
            ArrayList<Account> accountArrayList = actRecord.viewAllAccounts();
            int PatientCount = accountArrayList.size();
            ObservableList<Account> PatientData = FXCollections.observableArrayList();
            for (int i = 0; i < PatientCount; i++) {
                PatientData.add(accountArrayList.get(i));
            }

            patientId.setCellValueFactory(new PropertyValueFactory<>("accountID"));
          //  name.setCellValueFactory(new PropertyValueFactory<>("appointmentDateAndTime"));
           // nic.setCellValueFactory(new PropertyValueFactory<>("patientName"));
           // contactNumber.setCellValueFactory(new PropertyValueFactory<>("medicalOfficerName"));
            //gender.setCellValueFactory(new PropertyValueFactory<>("medicalOfficerSpeciality"));
           // bloodGroup.setCellValueFactory(new PropertyValueFactory<>(" appointmentStatus"));
           username.setCellValueFactory(new PropertyValueFactory<>("user"));
            password.setCellValueFactory(new PropertyValueFactory<>("password"));

            tableView.setItems(PatientData);



        } catch (Exception e) {

        }
    }
}
