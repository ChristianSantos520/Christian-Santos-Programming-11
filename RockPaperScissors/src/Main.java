import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Identifies the scan variable as a Scanner.
        Scanner scan = new Scanner(System.in);

        /*Integers the represent rock paper and scissors so they can be used return a value into userDetermination and
        use then to compare it the user has a draw, wins, or loses at the bottom of the script
        */
        int rock = 0;
        int paper = 1;
        int scissors = 2;

        /* A variable that is used to define the value of userDetermination is userInput is neither rock paper or
        scissors.
        */
        int invalid = -1;

        /* Determines if userInput is euqal sto rock paper or scissors and get assigned a value from the variables:
        rock, paper, or scissors.
        */
        int userDetermination;

        //Tells the user that which letters to type in order to tell the computer it they choose rock paper of scissors.
        System.out.println("Choose rock paper or scissors. 'r' for rock, 'p' for paper, and 's' for scissors");

        /*
        The computer will generate a number between 0 and 2.
        If random is 0, random is equal to rock.
        If random is 1, random is equal to paper.
        If random is 2, random is equal to scissors.

        If Math.random()*3 is not in brackets, then the expression (int)Math.random()*3 would cast Math.random() first -
        always to 0, so 0*3 is still 0.  If you times the random number first by 3, with brackets around
        Math.random()*3), the product would be casted and would produce 0, 1, or 2.
        */
        int random = (int)(Math.random()*3);

        //Takes in what the user types.
        String userInput = scan.next();

        // This will determine what the user's input is rock, paper, or scissors.
        if(userInput.equals("r")){
            userDetermination = rock;

        } else if (userInput.equals("p")){
            userDetermination = paper;

        } else if (userInput.equals("s")){
            userDetermination = scissors;

        } else {
            /* If the user did not print r, p, or s, they will get a message saying that the input is invalid and should
            try again.
            */
            System.out.println("Invalid selection please play again.");
            userDetermination = invalid;
        }

        //Determines if the user has a draw, wins, or loses.
        if(userDetermination == rock){
            if(random == rock){
                System.out.println("Draw!");
                System.out.println("Computer Choice: " + "rock   " + "Player choice: " + "rock");
            } else if (random == scissors) {
                System.out.println("You Win!");
                System.out.println("Computer Choice: " + "scissors   " + "Player choice: " + "rock");
            } else {
                System.out.println("You Lose!");
                System.out.println("Computer Choice: " + "paper   " + "Player choice: " + "rock");
            }

        } else if (userDetermination == paper){
            if(random == paper){
                System.out.println("Draw!");
                System.out.println("Computer Choice: " + "paper   " + "Player choice: " + "paper");
            } else if (random == rock) {
                System.out.println("You Win!");
                System.out.println("Computer Choice: " + "rock   " + "Player choice: " + "paper");
            } else {
                System.out.println("You Lose!");
                System.out.println("Computer Choice: " + "scissors   " + "Player choice: " + "paper");
            }

        } else if (userDetermination == scissors){
            if(random == scissors){
                System.out.println("Draw!");
                System.out.println("Computer Choice: " + "scissors   " + "Player choice: " + "scissors");
            } else if (random == paper) {
                System.out.println("You Win!");
                System.out.println("Computer Choice: " + "paper   " + "Player choice: " + "scissors");
            } else {
                System.out.println("You Lose!");
                System.out.println("Computer Choice: " + "rockr   " + "Player choice: " + "scissors");
            }
        } else {
            // Do nothing when invalid.
        }
    }
}
