package chapter1;

/**
 * Given an image represented by NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this
 * in place?
 */
public class Problem16 {
    public static int[][] rotate(int[][] input) {
        if (input == null) {
            throw new IllegalArgumentException("Invalid input!");
        }
        
        if (input.length == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        
        for (int row = 0; row < input.length; row++) {
            if (input[row].length != input.length) {
                throw new IllegalArgumentException("Input array is not NxN!");
            }
        }
        
        int[][] newArray = new int[input.length][input.length];
        
        for (int row = 0; row < input.length; row++) {
            for (int column = 0; column < input.length; column++) {
                newArray[column][input.length - row - 1] = input[row][column];
            }
        }
        
        return newArray;
    }
}