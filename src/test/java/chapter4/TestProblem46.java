package chapter4;

import chapter4.aux.BinaryNodeParentLink;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestProblem46 {
    @Test
    public void testWithOneElement() {
        BinaryNodeParentLink<Integer> root = new BinaryNodeParentLink<>(1);
        assertNull(Problem46.getNext(root));
    }

    @Test
    public void testWithTwoElementsValidBinarySearchTree() {
        BinaryNodeParentLink<Double> root = new BinaryNodeParentLink<>(10.0);
        BinaryNodeParentLink<Double> levelOneLeftOne = new BinaryNodeParentLink<>(5.0);
        BinaryNodeParentLink<Double> levelOneRightOne = new BinaryNodeParentLink<>(12.0);
        BinaryNodeParentLink<Double> levelTwoLeftOne = new BinaryNodeParentLink<>(3.0);
        BinaryNodeParentLink<Double> levelTwoRightOne = new BinaryNodeParentLink<>(8.0);
        BinaryNodeParentLink<Double> levelTwoLeftTwo = new BinaryNodeParentLink<>(11.0);
        BinaryNodeParentLink<Double> levelTwoRightTwo = new BinaryNodeParentLink<>(23.0);
        BinaryNodeParentLink<Double> levelThreeLeftOne = new BinaryNodeParentLink<>(2.0);
        BinaryNodeParentLink<Double> levelThreeRightOne = new BinaryNodeParentLink<>(4.0);
        BinaryNodeParentLink<Double> levelThreeLeftTwo = new BinaryNodeParentLink<>(7.0);
        BinaryNodeParentLink<Double> levelThreeRightTwo = new BinaryNodeParentLink<>(9.0);
        BinaryNodeParentLink<Double> levelFourLeftOne = new BinaryNodeParentLink<>(8.5);
        BinaryNodeParentLink<Double> levelFourRightOne = new BinaryNodeParentLink<>(9.8);

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
        levelThreeRightTwo.setLeft(levelFourLeftOne);
        levelThreeRightTwo.setRight(levelFourRightOne);

        BinaryNodeParentLink<Double> next = Problem46.getNext(root);
        assertEquals(levelOneRightOne, next);
        next = Problem46.getNext(levelThreeLeftOne);
        assertEquals(levelTwoLeftOne, next);
        next = Problem46.getNext(levelFourRightOne);
        assertEquals(root, next);
        next = Problem46.getNext(levelTwoRightTwo);
        assertNull(next);
    }
}