package sample.gameover;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import sample.action.ActionController;

import java.io.IOException;
import java.util.ArrayList;

public class GameOverController {
    public ListView scoreList;

    //Requires: JavaFx calls this function automatically when the scene is displayed.
    //Modifies: this, scoreList
    //Effects: The scoreList ListView is assigned the score values from the file for display.
    public void initialize() throws IOException {
        scoreList.getItems().clear();
        FinalScoreManager finalScoreManager = new FinalScoreManager();
        ArrayList<String> scores = finalScoreManager.getAllScores();
        for (String score : scores){
            scoreList.getItems().add(score);
        }
    }

    //Requires: ActionEvent event
    //Modifies: this, menuViewScene and window
    //Effects: menuViewParent is created from MenuView.fxml, menuViewScene is created and window
    public void changeSceneToMenuView(ActionEvent event) throws IOException{
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("/sample/menu/MenuView.fxml"));
        Scene menuViewScene = new Scene(menuViewParent);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(menuViewScene);
        window.show();
    }

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
}
