import org.junit.Test;

import javafx.scene.image.ImageView;
import sample.action.gameobjects.Player;

import static org.junit.Assert.assertTrue;


public class TestPlayer {

    private static double MIN_Y = -140;
    private static double MAX_Y = 150;

    //Requires: nothing
    //Modifies: this, playerImageView
    //Effects: tests if the player reaches and stops at the top of the pane
    @Test
    public void testGoingUpStopsAtTop() {
        ImageView playerImageView = new ImageView();
        Player player = new Player(playerImageView);
        player.setDirectionUp();
        for (int i = 0; i < 25; i++) {
            player.move();
            System.out.println("y=" + playerImageView.getY());
        }
        assertTrue(MIN_Y == playerImageView.getY());
        player.move();
        System.out.println("y=" + playerImageView.getY());
        assertTrue(MIN_Y == playerImageView.getY());
    }

    //Requires: nothing
    //Modifies: this, playerImageView
    //Effects: tests if the player reaches and stops at the bottom of the pane
    @Test
    public void testGoingDownStopsAtBottom() {
        ImageView imageView = new ImageView();
        Player player = new Player(imageView);
        player.setDirectionDown();
        for (int i = 0; i < 25; i++) {
            player.move();
            System.out.println("y=" + imageView.getY());
        }
        assertTrue(MAX_Y == imageView.getY());
        player.move();
        System.out.println("y=" + imageView.getY());
        assertTrue(MAX_Y == imageView.getY());
    }
}
