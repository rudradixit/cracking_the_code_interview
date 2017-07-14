package chapter9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.String.format;

/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents),
 * and pennies (1 cent), write code to calculate the number of ways of representing n cents.
 */
public class Problem98 {
    private static final int QUARTER = 25, DIME = 10, NICKEL = 5;
    
    public static Set<String> calculateCoinPayments(int cents) {
        if (cents < 0) {
            throw new IllegalArgumentException("Invalid amount of cents!");
        }

        Set<String> set = new HashSet<>();
        TreeNode root = new TreeNode("" + cents);
        buildTree(root, cents, false, false, false);
        iterateTree(root, "", set);
        return set;
    }
    
    private static void buildTree(TreeNode root, int cents, boolean skipQuarters, boolean skipDimes, boolean skipNickels) {
        if (cents == 0) {
            return;
        }
        
        if (cents >= QUARTER && !skipQuarters) {
            int numberOfQuarterChildren = cents / QUARTER;
            TreeNode child;
            
            for (int i=numberOfQuarterChildren; i>0; i--) {
                child = new TreeNode(i + "q");
                root.addChild(child);
                buildTree(child, cents - (QUARTER * i), true, false, false);
            }
        }
        
        if (cents >= DIME && !skipDimes) {
            int numberOfDimeChildren = cents / DIME;
            TreeNode child;
            
            for (int i=numberOfDimeChildren; i>0; i--) {
                child = new TreeNode(i + "d");
                root.addChild(child);
                buildTree(child, cents - (DIME * i), true, true, false);
            }
        }
        
        if (cents >= NICKEL && !skipNickels) {
            int numberOfNickelChildren = cents / NICKEL;
            TreeNode child;
            
            for (int i=numberOfNickelChildren; i>0; i--) {
                child = new TreeNode(i + "n");
                root.addChild(child);
                buildTree(child, cents - (NICKEL * i), true, true, true);
            }
        }
        
        TreeNode child = new TreeNode(cents + "p");
        root.addChild(child);
        buildTree(child, 0, true, true, true);
    }

    private static void iterateTree(TreeNode root, String path, Set<String> set) {
        if (root.getChildren().isEmpty()) {
                set.add(path);
        }

        for (TreeNode child : root.getChildren()) {
            iterateTree(child, (path.equals("") ? "" : path + "+") + child.getValue(), set);
        }
    }
    
    private static class TreeNode {
        private String value;
        private List<TreeNode> children = new ArrayList<>();
        
        public TreeNode(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
        
        public List<TreeNode> getChildren() {
            return new ArrayList<>(children);
        }
        
        public TreeNode addChild(TreeNode child) {
            this.children.add(child);
            return this;
        }
        
        @Override
        public String toString() {
            return format("[value=%s, children=%s]", value, children.toString());
        }
    }
}