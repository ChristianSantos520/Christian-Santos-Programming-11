public class Main {
    public static void main(String[] args) {

        int[] originalArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        System.out.println("Original Array");
        for(int i = 0; i < originalArray.length; i++) {
            System.out.println("Index: " + i + "\tValue: " + originalArray[i]);
        }
        System.out.println("**********************************************");


        int[] biggerArray = addValue(originalArray, 15);
        System.out.println("Array With Added Index At the End of the Array");
        for(int i = 0; i < biggerArray.length; i++) {
            System.out.println("Index: " + i + "\tValue: " + biggerArray[i]);
        }
        System.out.println("**********************************************");


        //insertPos is the place index where addedNumber will be inserted and everything else will be shifted over
        int[] insertArray = insertValue(biggerArray,2, 31);
        System.out.println("Array With Added Index Value In the Middle of the Array");
        for(int i = 0; i < insertArray.length; i++) {
            System.out.println("Index: " + i + "\tValue: " + insertArray[i]);
        }
        System.out.println("**********************************************");


        int poppedNumber = popValue(insertArray);
        System.out.println("Popped Value: " + poppedNumber);
        System.out.println("**********************************************");
    }

    static int[] addValue (int[] inputArray, int newValue){
        int[] biggerArray = new int[inputArray.length + 1];

        for(int i = 0; i < biggerArray.length; i++){
            if(i == biggerArray.length - 1){
                biggerArray[i] = newValue;

            } else {
                biggerArray[i] = inputArray[i];
            }
        }

        return biggerArray;
    }

    static int popValue(int[] inputArray){
        int[] smallerArray = new int[inputArray.length - 1];

        for(int i = 0; i < smallerArray.length; i++){
            if(i <= smallerArray.length - 1){
                smallerArray[i] = inputArray[i];
            }
        }

        int poppedValue = inputArray[inputArray.length - 1];

        return poppedValue;

        // - How can I return smallerArray to the caller so the caller can update their array?
        // - How can this method update the caller's array?
    }

    static int[] insertValue (int[] inputArray, int insertPos, int addedNumber) {
        int[] biggerArray = new int[inputArray.length + 1];

        for (int i = 0; i < biggerArray.length; i++) {
            if(i < insertPos){
                biggerArray[i] = inputArray[i];
            } else if (i == insertPos){
                biggerArray[i] = addedNumber;
            } else {
                biggerArray[i] = inputArray[i - 1];
            }
        }

        return biggerArray;

    }
}
