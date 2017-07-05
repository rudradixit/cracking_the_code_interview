package chapter4;

import chapter4.aux.BinaryNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProblem49 {
    @Test
    public void testWithTwoElementsValidBinarySearchTree() {
        BinaryNode<Integer> root = new BinaryNode<>(10);
        BinaryNode<Integer> levelOneLeftOne = new BinaryNode<>(5);
        BinaryNode<Integer> levelOneRightOne = new BinaryNode<>(12);
        BinaryNode<Integer> levelTwoLeftOne = new BinaryNode<>(3);
        BinaryNode<Integer> levelTwoRightOne = new BinaryNode<>(8);
        BinaryNode<Integer> levelTwoLeftTwo = new BinaryNode<>(11);
        BinaryNode<Integer> levelTwoRightTwo = new BinaryNode<>(23);
        BinaryNode<Integer> levelThreeLeftOne = new BinaryNode<>(2);
        BinaryNode<Integer> levelThreeRightOne = new BinaryNode<>(4);
        BinaryNode<Integer> levelThreeLeftTwo = new BinaryNode<>(7);
        BinaryNode<Integer> levelThreeRightTwo = new BinaryNode<>(9);

        root.setLeft(levelOneLeftOne);
        root.setRight(levelOneRightOne);
        levelOneLeftOne.setLeft(levelTwoLeftOne);
        levelOneLeftOne.setRight(levelTwoRightOne);
        levelOneRightOne.setLeft(levelTwoLeftTwo);
        levelOneRightOne.setRight(levelTwoRightTwo);
        levelTwoLeftOne.setLeft(levelThreeLeftOne);
        levelTwoLeftOne.setRight(levelThreeRightOne);
        levelTwoRightOne.setLeft(levelThreeLeftTwo);
        levelTwoRightOne.setRight(levelThreeRightTwo);

        assertEquals("[10],[2,3,5]", Problem49.findSumPaths(root, 10));
        assertEquals("[2,3,5,10]", Problem49.findSumPaths(root, 20));
    }
}