
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
import java.util.Date;

public class Main /*extends Application*/ {

  /* @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/LoginSelect.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }*/

    public static String removeFirstAndLast(String str)
    {   // Removing first and last character of a string using substring() method
        str = str.substring(1, str.length() - 1);
        return str;
    }
    public static Date getCurrentDate(){
        return java.util.Calendar.getInstance().getTime();
        //getting current date and time from the CPU
    }

    public static void main(String[] args) throws IOException {
        //launch(args);

        //Login login1 = new Login("Romenia","abc",getCurrentDate());
        //Login login2 = new Login("Movini","xyz",getCurrentDate());
        //Login login3 = new Login("Thiromi","123",getCurrentDate());
        LoginRecord userLogin = new LoginRecord("Files\\Details\\LoginDetails.txt");

        //userLogin.add(login1);
        //userLogin.add(login2);
        //userLogin.add(login3);

        //userLogin.dlt("00000");
        //userLogin.editLoginData("#00001","loginStatus","true");
         System.out.println(userLogin.viewByID("#00001"));
         System.out.println(removeFirstAndLast(userLogin.viewAllLogins().toString()));

    }
}