import org.junit.Test;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.action.gameobjects.Enemy;

import static org.junit.Assert.assertTrue;


public class TestEnemy {

    //Requires: nothing
    //Modifies: this, reachedLeftEdge
    //Effects: tests if the enemy created has reached and stops at the left side of the pane
    @Test
    public void testEnemyReachesLeftOfScreen() {
        double speed = 10;
        long MIN_X = 10;
        AnchorPane pane = new AnchorPane();
        Enemy enemy = new Enemy(pane, speed);
        ImageView enemyImageView = (ImageView)pane.getChildren().get(0); // the ImageVew of the created enemy.
        boolean reachedLeftEdge = false;
        while (!reachedLeftEdge) {
            reachedLeftEdge = enemy.move();
            System.out.println("x=" + enemyImageView.getX());
        }
        // Check that the while loop stops when the enemy reaches the left edge of the pane.
        assertTrue(enemyImageView.getX() <= MIN_X);
    }

}
