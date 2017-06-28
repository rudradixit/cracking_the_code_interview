package chapter3;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class Problem34 {
    public static List<String> solveTowerOfHanoi(int disks) {
        if (disks <= 0) {
            throw new IllegalArgumentException("Invalid number of disks!");
        }

        List<String> steps = new ArrayList<>();

        moveDisks(steps, disks, "A", "B", "C");

        return steps;
    }

    private static void moveDisks(List<String> steps, int disks, String source, String buffer, String destination) {
        if (disks == 1) {
            steps.add(format("move disk from tower %s to tower %s", source, destination));
            return;
        }

        moveDisks(steps, disks - 1, source, destination, buffer);
        steps.add(format("move disk from tower %s to tower %s", source, destination));
        moveDisks(steps, disks - 1, buffer, source, destination);
    }
}