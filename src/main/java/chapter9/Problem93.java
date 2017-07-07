package chapter9;

/**
 * A magic index in an array [0...n-1] is defined to be an index such that A[i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index,
 * if one exists, in array A.
 *
 * FOLLOW UP
 *
 * What if the values are not distinct?
 */
public class Problem93 {
    public static Integer findMagicIndex(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Invalid array!");
        }
        
        return _findMagicIndex(array, 0, array.length - 1);
    }
    
    private static Integer _findMagicIndex(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = start + (end - start) / 2;
        
        if (array[mid] == mid) {
            return mid;
        }
        
        if (array[mid] > mid) {
            return _findMagicIndex(array, start, mid - 1);
        }
        
        return _findMagicIndex(array, mid + 1, end);
    }
}