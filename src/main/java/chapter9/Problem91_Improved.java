package chapter9;

/**
 * A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps
 * at a time. Implement a method to count how many possible ways the child can run up the stairs.
 */
public class Problem91_Improved {
    public static int run(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Invalid number of steps!");
        }

        return countPossibleWays(n);
    }

    private static int countPossibleWays(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        return countPossibleWays(n - 1) +
               countPossibleWays(n - 2) +
               countPossibleWays(n - 3);
    }
}