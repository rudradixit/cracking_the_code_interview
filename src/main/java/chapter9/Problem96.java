package chapter9;

import java.util.HashSet;
import java.util.Set;

/**
 * Implement an algorithm to print all valid (e.g., properly opened and closed) combination of n-pairs
 * of parentheses.
 *
 * EXAMPLE
 *
 * Input: 3
 * Output: ((())), (()()), (())(), ()(()), ()()()
 */
public class Problem96 {
    public static Set<String> parentheses(int pairs) {
        if (pairs < 0) {
            throw new IllegalArgumentException("Invalid number of pairs!");
        }
        
        Set<String> set = new HashSet<>();
        
        if (pairs == 1) {
            set.add("()");
            return set;
        }
        
        int min = 1 << (pairs * 2 - 1);
        System.out.printf("Min: %d%n", min);
        int max = (1 << (pairs * 2)) - 1;
        System.out.printf("Max: %d%n", max);
        
        String binary;
        
        for (int i=min; i<=max; i++) {
            binary = Integer.toBinaryString(i);
            System.out.printf("Binary: %s%n", binary);

            if (binary.endsWith("0") &&
                has(binary, '1', pairs) &&
                has(binary, '0', pairs) && 
                reduceToEmpty(binary)) {
                
                System.out.printf("\tWorks: %s%n", swapCharacters(binary));
                set.add(swapCharacters(binary));
            }
        }
        
        return set;
    }
    
    private static boolean has(String binary, char digit, int occurrences) {
        char[] array = binary.toCharArray();
        int counter = 0;
        
        for (char c : array) {
            if (c == digit) {
                counter++;
            }
        }
        
        return counter == occurrences;        
    }
    
    private static boolean reduceToEmpty(String binary) {
        if (binary.isEmpty()) {
            return true;
        }
        
        int occurrence = binary.indexOf("10");

        if (occurrence == -1) {
            return false;
        }
        
        char[] array = binary.toCharArray();
        char[] reduced = new char[array.length - 2];
        int j=0;
        
        for (int i=0; i<array.length; i++) {
            if ((i != occurrence) && 
                (i != (occurrence + 1))) {
                
                reduced[j++] = array[i];
            }
        }
        
        return reduceToEmpty(new String(reduced));
    }
    
    private static String swapCharacters(String binary) {
        return (binary.replaceAll("1", "(")).replaceAll("0", ")");
    }
}