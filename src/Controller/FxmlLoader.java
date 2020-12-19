package Controller;
import Controller.AdminDashBoard.AdminDashBoardController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import  javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.Stack;


public class FxmlLoader {
    private Pane view;

    public Pane getPage(String fileName) {

        try{
            URL fileUrl = AdminDashBoardController.class.getResource("/View/AdminDashBoard/" + fileName + ".fxml");
            if(fileUrl == null){
                throw new java.io.FileNotFoundException("FXML file can't be found");
            }

            view =  new FXMLLoader().load(fileUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return view;
    }
}
