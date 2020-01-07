import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String nameOfFileToSearch = "in.txt";
        String word = "stored";

        ArrayList<String> lines = convertFileToLines(nameOfFileToSearch);
        ArrayList<ArrayList<Integer>> wordLocations = findLocations(lines, word);
        printResults(word, wordLocations);
    }

    public static ArrayList<String> convertFileToLines(String nameOfFileToSearch) throws IOException{
        ArrayList<String> lines = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(nameOfFileToSearch));

        int readLineInTxt;
        String lineStorage = "";
        while((readLineInTxt = br.read()) != -1) {
            char character = (char) readLineInTxt;

            String line = Character.toString(character);
            lineStorage += line;

            if (readLineInTxt == '\n') {
                lines.add(lineStorage);
                lineStorage = null;
            }
        }
        br.close();

        return lines;
    }

    public static ArrayList<ArrayList<Integer>> findLocations(ArrayList<String> lines, String word){
        ArrayList<ArrayList<Integer>> locations = new ArrayList<>();

        for (int lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
            String line = lines.get(lineIndex);
            // search for word in line.
            int startHere = 0;
            int positionInLine;
            while ((positionInLine = line.indexOf(word, startHere)) != -1) {
                // we found a match
                ArrayList<Integer> location = new ArrayList<>();
                location.add(lineIndex+1);  // the line number of match
                location.add(positionInLine+1);  // position in the line
                locations.add(location); // record the location
                startHere = positionInLine+1;
            }
        }

        return locations;
    }

    public static void printResults(String word, ArrayList<ArrayList<Integer>> wordLocations){
        for(ArrayList<Integer> location: wordLocations){
            System.out.println("line number =\t" + location.get(0));
            System.out.println("positionInLines =\t" + location.get(1));
            System.out.println("----------------------------------------------");
        }
    }
}
