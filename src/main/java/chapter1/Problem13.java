package chapter1;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class Problem13 {
    public static boolean verifyPermutation(String string1, String string2) {
        if (string1 == null || string2 == null) {
            throw new IllegalArgumentException("Invalid string parameters!");
        }
        
        if (string1.length() != string2.length()) {
            return false;
        }
        
        char[] array1 = string1.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        
        for (int i=0; i<array1.length; i++) {
            if (map1.containsKey(array1[i])) {
                map1.put(array1[i], map1.get(array1[i]) + 1);
            } else {
                map1.put(array1[i], 1);
            }
        }
        
        char[] array2 = string2.toCharArray();
        Map<Character, Integer> map2 = new HashMap<>();
        
        for (int i=0; i<array2.length; i++) {
            if (map2.containsKey(array2[i])) {
                map2.put(array2[i], map2.get(array2[i]) + 1);
            } else {
                map2.put(array2[i], 1);
            }
        }
        
        return map1.equals(map2);
    }
}