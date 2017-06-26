package chapter1;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column are set to 0.
 */
public class Problem17 {
    public static int[][] crossout(int[][] input) {
        if (input == null) {
            throw new IllegalArgumentException("Invalid input!");
        }

        if (input.length == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        
        int columns = input[0].length;

        for (int row = 1; row < input.length; row++) {
            if (input[row] == null || input[row].length != columns) {
                throw new IllegalArgumentException("Input array is not MxN!");
            }
        }
        
        Set<Integer> skipRows = new HashSet<>();
        Set<Integer> skipColumns = new HashSet<>();

        for (int row = 0; row < input.length; row++) {
            if (!skipRows.contains(row)) {
                for (int column = 0; column < input[row].length; column++) {
                    if (!skipColumns.contains(column)) {
                        if (input[row][column] == 0) {
                            crossout(input, row, column);
                        }
                        
                        skipColumns.add(column);
                    }
                }
                
                skipRows.add(row);
            }
        }

        return input;
    }
    
    private static void crossout(int[][] input, int row, int column) {
        for (int c=0; c<input[row].length; c++) {
            input[row][c] = 0;
        }
        
        for (int r=0; r<input.length; r++) {
            input[r][column] = 0;
        }
    }
}