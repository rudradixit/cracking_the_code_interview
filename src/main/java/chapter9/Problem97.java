package chapter9;

import static java.lang.String.format;

/**
 * Implement the "paint fill" function that one might see on many image editing
 * programs. That is, given a screen (represented by a two-dimensional array of
 * colors), a point, and a new color, fill in the surrounding area until the color
 * changes from the original color.
 */
public class Problem97 {
    public static String[][] fill(String[][] screen, Point point, String newColor) {
        if (screen == null) {
            throw new IllegalArgumentException("Invalid screen!");
        }
        
        if (point == null || point.getX() >= screen.length || point.getY() >= screen[0].length) {
            throw new IllegalArgumentException("Invalid point!");
        }
        
        if (newColor == null) {
            throw new IllegalArgumentException("Invalid color!");
        }
        
        String currentColor = screen[point.getX()][point.getY()];
        _fill(screen, point, newColor, currentColor);
        return screen;
    }
    
    private static void _fill(String[][] screen, Point point, String newColor, String currentColor) {
        if (screen[point.getX()][point.getY()].equals(currentColor)) {
            System.out.printf("Filling %s from %s to %s%n", point, currentColor, newColor);
            screen[point.getX()][point.getY()] = newColor;
        }
        
        Point newPoint = new Point(point.getX() + 1, point.getY() - 1);
        
        if (isWithinBounds(screen, newPoint) && screen[newPoint.getX()][newPoint.getY()].equals(currentColor)) {
            _fill(screen, newPoint, newColor, currentColor);
        }
        
        newPoint = new Point(point.getX() + 1, point.getY());
        
        if (isWithinBounds(screen, newPoint) && screen[newPoint.getX()][newPoint.getY()].equals(currentColor)) {
            _fill(screen, newPoint, newColor, currentColor);
        }
        
        newPoint = new Point(point.getX() + 1, point.getY() + 1);
        
        if (isWithinBounds(screen, newPoint) && screen[newPoint.getX()][newPoint.getY()].equals(currentColor)) {
            _fill(screen, newPoint, newColor, currentColor);
        }
        
        newPoint = new Point(point.getX(), point.getY() - 1);
        
        if (isWithinBounds(screen, newPoint) && screen[newPoint.getX()][newPoint.getY()].equals(currentColor)) {
            _fill(screen, newPoint, newColor, currentColor);
        }
        
        newPoint = new Point(point.getX(), point.getY() + 1);
        
        if (isWithinBounds(screen, newPoint) && screen[newPoint.getX()][newPoint.getY()].equals(currentColor)) {
            _fill(screen, newPoint, newColor, currentColor);
        }
        
        newPoint = new Point(point.getX() - 1, point.getY() - 1);
        
        if (isWithinBounds(screen, newPoint) && screen[newPoint.getX()][newPoint.getY()].equals(currentColor)) {
            _fill(screen, newPoint, newColor, currentColor);
        }
        
        newPoint = new Point(point.getX() - 1, point.getY());
        
        if (isWithinBounds(screen, newPoint) && screen[newPoint.getX()][newPoint.getY()].equals(currentColor)) {
            _fill(screen, newPoint, newColor, currentColor);
        }
        
        newPoint = new Point(point.getX() - 1, point.getY() + 1);
        
        if (isWithinBounds(screen, newPoint) && screen[newPoint.getX()][newPoint.getY()].equals(currentColor)) {
            _fill(screen, newPoint, newColor, currentColor);
        }
    }
    
    private static boolean isWithinBounds(String[][] screen, Point point) {
        return (point.getX() >= 0 && point.getX() < screen.length) &&
               (point.getY() >= 0 && point.getY() < screen[0].length);
    }
}

class Point {
    private int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    @Override
    public String toString() {
        return format("[%d, %d]", x, y);
    }
}