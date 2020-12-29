
import Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;

public class Main extends Application {
    private static double xOffset = 0;
    private static double yOffset = 0;
   @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/LoginSelect.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        root.setOnMousePressed(event -> {
           xOffset = event.getSceneX();
           yOffset = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
           primaryStage.setX(event.getScreenX() - xOffset);

           primaryStage.setY(event.getScreenY() - yOffset);
       });

   }

    public static void main(String[] args) throws IOException {
        launch(args);
        /*User admin = new User("ABC","1234567890","2000123458V", "user", Gender.MALE,"22/01/2000","1234", MaritalStatus.SINGLE);
        Account adminAccount = new Account(UserType.ADMIN,admin);
        AccountRecord adminAccountRecord = new AccountRecord("Files\\Details\\AdminAccountDetails.txt");
        adminAccountRecord.add(adminAccount);
        adminAccountRecord.editAccountData("AD00000","dOB","28/01/2001");
        System.out.println(admin);
        System.out.println(adminAccount);*/

    }
}

