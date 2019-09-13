package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;

public class Controller {
    public Label moneyAmount;

    public Label diceOne;
    public Label diceTwo;
    public Button btnRollOne;
    public Button btnRollTwo;
    private int diceAnswerOne;
    private int diceAnswerTwo;

    public RadioButton btnHigher;
    public RadioButton btnLower;
    private boolean isHigher = false;
    private boolean isLower = false;

    public TextField betAmount;

    public Button btnPlayAgain;

    private int convertBetInteger(TextField betAmount){
        return Integer.parseInt(betAmount.getText());
    }

    private int convertMoneyAmount(Label moneyAmount){
        return Integer.parseInt(moneyAmount.getText());
    }

    private int rollDice() {
        double rollDice = Math.random() * 6 + 1;
        int diceAnswer = (int) rollDice;
        return diceAnswer;
    }

    public void rollOne(ActionEvent actionEvent) {
        diceAnswerOne = rollDice();
        diceOne.setText(Integer.toString(diceAnswerOne));
        btnRollOne.setDisable(true);
        betAmount.setDisable(false);
        btnHigher.setDisable(false);
        btnLower.setDisable(false);
    }

    public void rollTwo(ActionEvent actionEvent) {
        betAmount.setDisable(true);
        btnHigher.setDisable(true);
        btnLower.setDisable(true);

        diceAnswerTwo = rollDice();
        diceTwo.setText(Integer.toString(diceAnswerTwo));

        if(diceAnswerTwo > diceAnswerOne && isHigher == true || diceAnswerTwo < diceAnswerOne && isLower == true){
            int balance = convertMoneyAmount(moneyAmount);
            int winAmount = convertBetInteger(betAmount);
            int newBalance = balance + winAmount;
            moneyAmount.setText(Integer.toString(newBalance));
        } else {
            int balance = convertMoneyAmount(moneyAmount);
            int loseAmount = convertBetInteger(betAmount);
            int newBalance = balance - loseAmount;
            moneyAmount.setText(Integer.toString(newBalance));
        }
        btnRollTwo.setDisable(true);
        btnPlayAgain.setDisable(false);
    }

    public void checkAndEnableDice2() {
        if ((isHigher || isLower) && (!betAmount.getText().isEmpty())) {
            btnRollTwo.setDisable(false);
        } else {
            btnRollTwo.setDisable(true);
        }
    }
    public void higher(ActionEvent actionEvent) {
        isHigher = true;
        isLower = false;
        betAmount.setDisable(true);
        checkAndEnableDice2();
    }

    public void lower(ActionEvent actionEvent) {
        isLower = true;
        isHigher = false;
        betAmount.setDisable(true);
        checkAndEnableDice2();
    }

    public void playAgain(ActionEvent actionEvent) {
        diceAnswerOne = 0;
        diceOne.setText(Integer.toString(diceAnswerOne));
        diceAnswerTwo = 0;
        diceTwo.setText(Integer.toString(diceAnswerTwo));

        betAmount.clear();

        btnHigher.setSelected(false);
        btnLower.setSelected(false);

        btnRollOne.setDisable(false);
        btnRollTwo.setDisable(true);
        btnHigher.setDisable(true);
        btnLower.setDisable(true);
        btnPlayAgain.setDisable(true);
    }
}
