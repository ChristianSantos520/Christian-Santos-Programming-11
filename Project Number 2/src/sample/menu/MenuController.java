package sample.menu;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.action.ActionController;

public class MenuController {

    //Requires: ActionEvent event
    //Modifies: this, actionViewScene and window
    //Effects: actionViewParent is created from ActionView.fxml, actionViewScene is created and window
    public void changeSceneToActionView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/action/ActionView.fxml"));
        Parent actionViewParent = (Parent)loader.load();
        ActionController controller = (ActionController)loader.getController();
        Scene actionViewScene = new Scene(actionViewParent);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(actionViewScene);
        window.show();
        controller.startPlay();
    }

    //Requires: ActionEvent event (call this to terminate).
    //Modifies: this, window
    //Effects: Terminates the application.
    public void exitProgram(ActionEvent event) {
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.close();
    }
}
