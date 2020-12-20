
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


    }
}

