package sample.action;

import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.action.gameobjects.Enemy;
import sample.action.gameobjects.Player;
import sample.gameover.FinalScoreManager;

public class ActionController {
    public AnchorPane anchorPane;
    private FinalScoreManager finalScoreManager;
    public Label score;

    private ArrayList<Enemy> enemies;
    private double enemySpeed = 7;
    private double enemySpeedCounter = 0;
    private long timeOfNextAlienCreation = 0;
    private long enemyDelay = 700000000;
    private int enemyDelayCounter = 0;

    public ImageView playerImageView;
    private Player player;
    private AnimationTimer animationTimer;

    //Requires: KeyEvent keyEvent
    //Modifies: nothing
    //Effects: recognizes the up and down keys for the direction.
    //All other keys make the player motionless.
    public void handleKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.UP){
            player.setDirectionUp();
        } else if (keyEvent.getCode() == KeyCode.DOWN){
            player.setDirectionDown();
        } else {
            player.setDirectionMotionless();
        }
    }

    //Requires: KeyEvent keyEvent
    //Modifies: this, keyEvent
    //Effects: Make the player motionless when keys are released.
    public void handleKeyRelease(KeyEvent keyEvent) {
        player.setDirectionMotionless();
    }

    //Requires: Call this when the action view is displayed.
    //Modifies: the scene
    //Effects: Initializes the key handlers, the player and empty list of enemies,
    //and starts the animation timer.
    public void startPlay(){
        Scene scene = score.getScene();
        scene.setOnKeyPressed(this::handleKeyPress);
        scene.setOnKeyReleased(this::handleKeyRelease);

        finalScoreManager = new FinalScoreManager();

        player = new Player(playerImageView);
        enemies = new ArrayList<>();

        animationTimer = new AnimationTimer() {
            public void handle(long now){
                try {
                    animationTick(now);
                } catch(Exception x) {
                }
            }
        };
        animationTimer.start();
    }

    //Requires: long now - the time provided when the animation engine calls this
    //Modifies: the scene components being animated
    //Effects: moves the player if needed, moves/removes/creates enemies as needed,
    //and updates the screen score.
    private void animationTick(long now) throws IOException{
        player.move();
        ArrayList<Enemy> remainingEnemies = new ArrayList<>();
        for(Enemy enemy: enemies){
            boolean isOffScreen = enemy.move();
            if(isOffScreen){
                incrementScore();
            } else {
                if(player.isCollidingWithEnemy(enemy)){
                    endGame();
                    return;
                } else {
                    remainingEnemies.add(enemy);
                }
            }
        }
        enemies = remainingEnemies;

        if (now < timeOfNextAlienCreation){
            return;
        }

        if (enemyDelayCounter == 15){
            enemyDelay -= 100050000;
            enemyDelayCounter++;
        }
        long randomDelay = enemyDelay;
        timeOfNextAlienCreation = now + randomDelay;

        if (enemySpeedCounter == 10){
            enemySpeedCounter = 0;
            enemySpeed += 2;
        }
        Enemy enemy = new Enemy(anchorPane, enemySpeed);
        enemySpeedCounter++;
        enemies.add(enemy);
    }

    //Requires: nothing
    //Modifies: this, numberAliensDodged and score
    //Effects: adds 1 to the screen score
    private void incrementScore(){
        int numberAliensDodged = Integer.parseInt(score.getText());
        numberAliensDodged++;
        score.setText(Integer.toString(numberAliensDodged));
    }

    //Requires: nothing
    //Modifies: this, animationTimer and finalScoreManager
    //Effects: stops the animation timer, records the final score, and calls changeSceneToGameOverView().
    private void endGame() throws IOException{
        animationTimer.stop();
        int numberAliensDodged = Integer.parseInt(score.getText());
        finalScoreManager.addScore(numberAliensDodged);
        changeSceneToGameOverView();
    }

    //Requires: nothing
    //Modifies: this, gameOverViewScene and window
    //Effects: Prepares the GameOverView and transfers the view to that scene.
    private void changeSceneToGameOverView() throws IOException {
        Parent gameOverViewParent = FXMLLoader.load(getClass().getResource("/sample/gameover/GameOverView.fxml"));
        Scene gameOverViewScene = new Scene(gameOverViewParent);
        Stage window = (Stage)score.getScene().getWindow();
        window.setScene(gameOverViewScene);
        window.show();
    }
}
