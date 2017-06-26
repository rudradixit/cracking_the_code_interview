package chapter1;

public class Problem18 {
    public static boolean isRotation(String string, String excerpt) {
        if (string == null) {
            throw new IllegalArgumentException("Invalid input string!");
        }

        if (excerpt == null) {
            throw new IllegalArgumentException("Invalid excerpt string!");
        }

        return isSubstring(string + string, excerpt);
    }

    private static boolean isSubstring(String string, String excerpt) {
        return string.contains(excerpt);
    }
}