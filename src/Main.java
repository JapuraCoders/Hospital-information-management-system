
import Model.Login;
import Model.LoginRecord;
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
        Parent root = FXMLLoader.load(getClass().getResource("../../Hospital-information-management-system-vinod/src/View/LoginSelect.fxml"));
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

    /*public static String removeFirstAndLast(String str)
    {   // Removing first and last character of a string using substring() method
        str = str.substring(1, str.length() - 1);
        return str;
    }*/

    public static void main(String[] args) throws IOException {
        launch(args);

        /*Login login1 = new Login("User1","password");
        Login login2 = new Login("User2","pass");
        LoginRecord userLogin = new LoginRecord("Files\\Details\\LoginDetails.txt");

        userLogin.add(login1);
        userLogin.add(login2);
        userLogin.dlt("null|null|0");
        System.out.println(userLogin.viewByID("null|null|1"));
        System.out.println(removeFirstAndLast(userLogin.viewAllLogins().toString()));*/

    }
}

