package Controller;
import Controller.AdminDashBoard.AdminDashBoardController;
import javafx.fxml.FXMLLoader;
import  javafx.scene.layout.Pane;

import java.net.URL;


public class FxmlLoader {
    private Pane view;

    public Pane getPage(String fileName) {

        try{
            URL fileUrl = AdminDashBoardController.class.getResource("/View/AdminDashBoard/" + fileName + ".fxml");
            if(fileUrl == null){
                throw new java.io.FileNotFoundException("FXML file can't be found");
            }

            view = new FXMLLoader().load(fileUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return view;
    }
}
