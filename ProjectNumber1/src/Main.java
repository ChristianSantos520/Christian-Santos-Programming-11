public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s){
        int answer = 0;

        String[] vowels = {"a", "e", "i", "o", "u"};

        for (int i = 0; i < s.length(); i++){
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

        int longestBeginning = 0;

        int longestSize = 0;

        int probeBeginning = 0;

        int probeEnd = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= s.charAt(probeEnd)){
                probeEnd = i;

            } else {
                int probeLength = (probeEnd - probeBeginning + 1);

                if(probeLength > longestSize){
                    longestBeginning = probeBeginning;
                    longestSize = probeLength;
                }

                probeBeginning = i;
                probeEnd = i;
            }
        }
        int probeLength = (probeEnd - probeBeginning + 1);
        if(probeLength > longestSize){
            longestBeginning = probeBeginning;
            longestSize = probeLength;
        }

        s = s.substring(longestBeginning, longestBeginning + longestSize);
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
