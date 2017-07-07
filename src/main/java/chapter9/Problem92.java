package chapter9;

import static java.lang.String.format;

/**
 * Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can
 * only move in two directions: right and down. How many possible paths are there
 * for the robot to go from (0,0) to (X,Y)?
 *
 * FOLLOW UP
 *
 * Imagine certain spots are "off limits", such that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the bottom
 * right.
 */
public class Problem92 {
    public static int robotWalk(int x, int y) {
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException("Invalid [X,Y]!");
        }
        
        return _robotWalk(new Coordinate(0, 0), new Coordinate(x, y));
    }
    
    private static int _robotWalk(Coordinate current, Coordinate target) {
        if (current.equals(target)) {
            return 1;
        }
        
        if ((current.x() > target.x()) || (current.y() > target.y())) {
            return 0;
        }
        
        return _robotWalk(new Coordinate(current.x() + 1, current.y()), target) + 
            _robotWalk(new Coordinate(current.x(), current.y() + 1), target);
    }
    
    private static class Coordinate {
        private int x, y;
        
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int x() {
            return x;
        }
        
        public int y() {
            return y;
        }
        
        @Override
        public int hashCode() {
            int result = 31;
            result += 37 * x;
            result += 37 * y;
            return result;
        }
        
        @Override
        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            
            if (object == this) {
                return true;
            }
            
            if (object.getClass() != getClass()) {
                return false;
            }
            
            Coordinate other = (Coordinate)object;
            return x == other.x && y == other.y;
        }

        @Override
        public String toString() {
            return format("[%d, %d]", x, y);
        }
    }
}