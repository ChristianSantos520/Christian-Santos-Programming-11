import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Instructions
        System.out.println("Type a string to get your string encrypted and decrypted.");

        // User input variable
        String userString = scan.next();

        System.out.println("User String:\t" + userString);


        // This variable is the firstLetter of the encrypted string;
        String firstLetter = "";

        // This variable has the data of the encrypted string
        String encryptedString = "";

        // This variable has the data of the decrypted string
        String decryptedString = "";

        // Identify the last letter
        encryptedString = userString.substring(userString.length() - 1);

        // Prints rest of string and replace last letter with 'ay'
        for(int i = 0; i < userString.length(); i++){
            if (i == userString.length() - 1) {
                encryptedString += "ay";
            } else {
                encryptedString += userString.substring(i, i + 1);
            }
        }
        System.out.println("Encrypted String:\t" + encryptedString);


        for(int i = 0; i < encryptedString.length(); i++){
             if(i == 0){
                 firstLetter = encryptedString.substring(i, i + 1);
             } else if (i >= 1){
                 if(i == encryptedString.length() - 2){
                     decryptedString += firstLetter;
                     break;
                 }
                 decryptedString += encryptedString.substring(i, i + 1);
             }
        }
        System.out.println("Decrypted String:\t" + decryptedString);
    }
}