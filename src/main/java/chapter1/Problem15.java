package chapter1;

/**
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string "aabcccccaaa" would become
 * "a2b1c5a3". If the compressed string would not become smaller than the
 * original string, your method should return the original string. You can
 * assume the string as only upper and lower case letters (a-z).
 */
public class Problem15 {
    public static String compress(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        
        if (!input.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Input contains invalid characters!");
        }
        
        char[] chars = input.toCharArray();
        StringBuilder builder = new StringBuilder();
        
        for (int i=0; i<chars.length; i++) {
            int walker = i+1;
            int counter = 1;
            
            while ((walker < chars.length) && (chars[i] == chars[walker])) {
                counter++;
                walker++;
            }
            
            builder.append(chars[i]).append(counter);
            i = walker-1;
        }
        
        return builder.length() < input.length() ? builder.toString() : input;
    }
}