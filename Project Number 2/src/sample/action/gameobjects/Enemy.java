package sample.action.gameobjects;

import java.util.concurrent.ThreadLocalRandom;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Enemy {
    private Pane pane;
    private ImageView imageView;
    private double speed;

    private static int WIDTH = 50;
    private static int HEIGHT = 50;
    private static int MIN_X = 10;
    private static int MAX_X = 540;
    private static int MIN_Y = 40;
    private static int MAX_Y = 340;

    private static int MIN_SPEED = 10;
    private static int MAX_SPEED = 15;

    //Requires: Pane pane and double enemySpeed
    //Modifies: this and Pane pane
    //Effects: creates an Enemy by creating an imageView with Alien.png that is added to pane.  imageView is assigned
    // with a width and height and its x and y position.  The y position is randomized between MIN_Y and MAX_Y.
    public Enemy(Pane pane, double enemySpeed) {
        this.pane = pane;
        Image enemy = new Image(getClass().getResourceAsStream("/sample/images/Alien.png"));
        imageView = new ImageView(enemy);
        pane.getChildren().add(imageView);

        imageView.setFitHeight(HEIGHT);
        imageView.setFitWidth(WIDTH);

        int randomY = ThreadLocalRandom.current().nextInt(MIN_Y, MAX_Y + 1);
        imageView.setX(MAX_X);
        imageView.setY(randomY);

        speed = enemySpeed;
    }

    //Requires: nothing
    //Modifies: this
    //Effects: moves this enemy by negative speed and checks if this reaches the left side of the window.  If so,
    //it removes the imageView from the pane and returns true, else it returns false.
    public boolean move(){
        double enemyXPosition = imageView.getX();
        imageView.setX(enemyXPosition - speed);
        if(enemyXPosition < MIN_X){
            pane.getChildren().remove(imageView);
            return true;
        } else {
            return false;
        }
    }

    //Requires: nothing
    //Modifies: nothing
    //Effects: returns the imageView's boundaries in the parent pane
    public Bounds getBoundsInParent() {
        return imageView.getBoundsInParent();
    }
}
