public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s){
        int answer = 0;

        //This array is used for comparing s if one of the characters in the array is a vowel.
        String[] vowels = {"a", "e", "i", "o", "u"};

        for (int i = 0; i < s.length(); i++){

            //This for loop will go through all of the vowels to see if s.substring is a vowel.
            //This for loop will run for every position in the s string.
            for (int j = 0; j < vowels.length; j++){
                if (s.substring(i,i+1).equals(vowels[j])){
                    answer++;
                    break;
                }
            }
        }

        System.out.println("Number of vowels: " + answer);

        return answer;
    }
    //Code you problem number two here
    static int problemTwo(String s){
        int answer = 0;

        //This for loop will run and check if s.substring has the string "bob".
        for (int i = 0; i < s.length() - 2; i++){
            if(s.substring(i,i+3).equals("bob")){
                answer++;
            }
        }

        System.out.println("Number of times bob occurs is: " + answer);

        return answer;
    }
    //Code your solution to problem number 3 here
    static String problemThree(String s){

        //The position where the longest substring begins.
        int longestBeginning = 0;

        //This variable tell you the size of the longest substring is.
        int longestSize = 0;

        //This is the beginning position of the current substring.
        int probeBeginning = 0;

        //This is the end of the current substring position
        int probeEnd = 0;

        for(int i = 0; i < s.length(); i++){

            /*If the character at position 'i' is greater or equal to probeEnd, the probeEnd will equal to 'i'.
            This will check if the substring will continue.
            */
            if(s.charAt(i) >= s.charAt(probeEnd)){
                probeEnd = i;

            } else {
                //This variable will determine the length is the current substring.
                int probeLength = (probeEnd - probeBeginning + 1);

                /*If the current substring is the greater that the last substring that was detected.  The longest
                variables will be assigned to the probe variables because probe length is the longer substring.
                */
                if(probeLength > longestSize){
                    longestBeginning = probeBeginning;
                    longestSize = probeLength;
                }

                probeBeginning = i;
                probeEnd = i;
            }
        }
        //This will insure if the substring at the end of the s is the longest substring.
        int probeLength = (probeEnd - probeBeginning + 1);
        if(probeLength > longestSize){
            longestBeginning = probeBeginning;
            longestSize = probeLength;
        }

        s = s.substring(longestBeginning, longestBeginning + longestSize);
        System.out.println("Longest substring in alphabetical order is: " + s);
        return s;
    }
    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
        String s;
    }
}
