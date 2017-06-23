package chapter1;

/**
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the
 * end of the string to hold the additional characters, and
 * that you are given the "true" length of the string. (Note:
 * if implementing in Java, please use a character array so
 * that you can perform this operation in place.)
 *
 * EXAMPLE
 * Input:  "Mr John Smith    ", 13
 * Output: "Mr%20John%20Smith",
 */
public class Problem14 {
    public static String replace(String string, int trueSize) {
        if (string == null) {
            throw new IllegalArgumentException("Invalid string!");
        }

        if (trueSize < 0) {
            throw new IllegalArgumentException("Invalid 'true' size!");
        }

        char[] array = string.toCharArray();
        int shiftIndex = trueSize - 1;
        
        for (int i=0; i<trueSize; i++) {
            if (array[i] == ' ') {
                shiftRight(array, i + 1, shiftIndex);
                shiftIndex += 2;
                array[i] = '%';
                array[i+1] = '2';
                array[i+2] = '0';
            }
        }
        
        return new String(array);
    }
    
    private static void shiftRight(char[] array, int index, int shiftIndex) {
        for (int j=shiftIndex; j>=index; j--) {
            array[j+2] = array[j];
        }
    }
}