package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {
    public TextField friendAge;
    public TextField friendColor;
    public TextField friendName;
    public Button btnCreate;

    public TextField deleteFriendName;
    public Button btnDelete;

    public TextField namePrintFriend;
    public TextField displayFriend;
    public Button btnPrintFriend;

    public TextArea listAll;
    public Button btnListAll;
    private String previousFriend;
    private String friend = "";

    ArrayList<Friend> friends = new ArrayList<>();

    public void createFriend(ActionEvent actionEvent) {
        String name = friendName.getText();
        int age = Integer.parseInt(friendAge.getText());
        String favoriteColor = friendColor.getText();
        Friend friend = new Friend(name, age, favoriteColor);
        friends.add(friend);
        friendName.setText("");
        friendAge.setText("");
        friendColor.setText("");
        deleteFriendName.setDisable(false);
        btnDelete.setDisable(false);
        namePrintFriend.setDisable(false);
        displayFriend.setDisable(false);
        btnPrintFriend.setDisable(false);
        listAll.setDisable(false);
        btnListAll.setDisable(false);
    }

    public void deleteFriend(ActionEvent actionEvent) {
        for (int i = 0; i < friends.size(); i++){
            if (friends.get(i).getName().equals(deleteFriendName.getText())){
                friends.remove(i);
                break;
            }
        }
        deleteFriendName.setText("");
    }

    public void listFriends(ActionEvent actionEvent) {
        String friendStorage = "";
        for (int i = 0; i < friends.size(); i++){
            if (i > 0){
                friendStorage += "\n";
            }
            friendStorage += friends.get(i).toString();
        }
        listAll.setText(friendStorage);
    }

    public void printFriend(ActionEvent actionEvent) {
        for (int i = 0; i < friends.size(); i++){
            if (friends.get(i).getName().equals(namePrintFriend.getText())){
                displayFriend.setText(friends.get(i).toString());
                break;
            }
        }
        namePrintFriend.setText("");
    }
}
