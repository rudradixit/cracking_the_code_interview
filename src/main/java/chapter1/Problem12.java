package chapter1;

/**
 * Implement a function to reverse a String.
 */
public class Problem12 {
    public static String reverse(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Invalid string!");
        }
        
        char[] array = string.toCharArray();
        char[] reversed = new char[array.length];
        int j=0;
        
        for (int i=array.length - 1; i >= 0; i--) {
            reversed[j++] = array[i];
        }
        
        return new String(reversed);
    }
}