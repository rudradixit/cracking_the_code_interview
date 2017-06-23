package chapter1;

import java.util.HashSet;
import java.util.Set;

/**
 * Implement an algorithm that determines if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class Problem11 {
    public static boolean verifyUniqueCharsWithAdditionalDS(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Invalid string!");
        }
        
        char[] array = string.toCharArray();
        Set<Character> set = new HashSet<>();
            
        for (int i=0; i<array.length; i++) {
            if (set.contains(array[i])) {
                return false;
            }
            
            set.add(array[i]);
        }
        
        return true;
    }

    public static boolean verifyUniqueCharsWithoutAdditionalDS(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Invalid string!");
        }
        
        char[] array = string.toCharArray();
        
        for (int i=0; i<array.length; i++) {
            for (int j=i; j<array.length; j++) {
                if (array[i] == array[j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}