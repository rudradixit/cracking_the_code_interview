package chapter9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Write a method to return all subsets of a set.
 */
public class Problem94 {
    public static <T> List<Set<T>> generateSubsets(Set<T> original) {
        if (original == null) {
            throw new IllegalArgumentException("Invalid original set!");
        }

        List<Set<T>> list = new ArrayList<>();
        _generateSubsets(original, list, (1 << original.size()) - 1);
        return list;
    }
    
    private static <T> void _generateSubsets(Set<T> original, List<Set<T>> list, int number) {
        if (number == 0) {
            list.add(new HashSet<>());
        } else {
            String binary = toBinary(number, original.size());
            Set<T> set = new HashSet<>();
            T[] originalArray = (T[])original.toArray();

            for (int i=0; i<binary.length(); i++) {
                if (binary.charAt(i) == '1') {
                    set.add(originalArray[i]);
                }
            }

            list.add(set);
            _generateSubsets(original, list, number - 1);
        }
    }
    
    private static String toBinary(int number, int size) {
        String binary = Integer.toBinaryString(number);
        
        if (binary.length() != size) {
            int diff = size - binary.length();
            for (int i=0; i<diff; i++) {
                binary = "0" + binary;
            }
        }
        
        return binary;
    }
}