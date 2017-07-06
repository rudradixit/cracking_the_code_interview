package chapter4;

import chapter4.aux.BinaryNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestProblem48 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithFirstNull() {
        Problem48.contains(null, new BinaryNode<Integer>(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithSecondNull() {
        Problem48.contains(new BinaryNode<Integer>(1), null);
    }

    @Test
    public void testWhenContains() {
        BinaryNode<Integer> t1 = new BinaryNode<>(10);
        BinaryNode<Integer> t1_levelOneLeftOne = new BinaryNode<>(5);
        BinaryNode<Integer> t1_levelOneRightOne = new BinaryNode<>(12);
        BinaryNode<Integer> t1_levelTwoLeftOne = new BinaryNode<>(3);
        BinaryNode<Integer> t1_levelTwoRightOne = new BinaryNode<>(8);
        BinaryNode<Integer> t1_levelTwoLeftTwo = new BinaryNode<>(11);
        BinaryNode<Integer> t1_levelTwoRightTwo = new BinaryNode<>(23);
        BinaryNode<Integer> t1_levelThreeLeftOne = new BinaryNode<>(2);
        BinaryNode<Integer> t1_levelThreeRightOne = new BinaryNode<>(4);
        BinaryNode<Integer> t1_levelThreeLeftTwo = new BinaryNode<>(7);
        BinaryNode<Integer> t1_levelThreeRightTwo = new BinaryNode<>(9);

        t1.setLeft(t1_levelOneLeftOne);
        t1.setRight(t1_levelOneRightOne);
        t1_levelOneLeftOne.setLeft(t1_levelTwoLeftOne);
        t1_levelOneLeftOne.setRight(t1_levelTwoRightOne);
        t1_levelOneRightOne.setLeft(t1_levelTwoLeftTwo);
        t1_levelOneRightOne.setRight(t1_levelTwoRightTwo);
        t1_levelTwoLeftOne.setLeft(t1_levelThreeLeftOne);
        t1_levelTwoLeftOne.setRight(t1_levelThreeRightOne);
        t1_levelTwoRightOne.setLeft(t1_levelThreeLeftTwo);
        t1_levelTwoRightOne.setRight(t1_levelThreeRightTwo);

        BinaryNode<Integer> t2 = new BinaryNode<>(8);
        BinaryNode<Integer> t2_levelOneLeftOne = new BinaryNode<>(7);
        BinaryNode<Integer> t2_levelOneRightOne = new BinaryNode<>(9);
        t2.setLeft(t2_levelOneLeftOne);
        t2.setRight(t2_levelOneRightOne);

        assertTrue(Problem48.contains(t1, t2));
    }

    @Test
    public void testWhenNotContains() {
        BinaryNode<Integer> t1 = new BinaryNode<>(10);
        BinaryNode<Integer> t1_levelOneLeftOne = new BinaryNode<>(5);
        BinaryNode<Integer> t1_levelOneRightOne = new BinaryNode<>(12);
        BinaryNode<Integer> t1_levelTwoLeftOne = new BinaryNode<>(3);
        BinaryNode<Integer> t1_levelTwoRightOne = new BinaryNode<>(8);
        BinaryNode<Integer> t1_levelTwoLeftTwo = new BinaryNode<>(11);
        BinaryNode<Integer> t1_levelTwoRightTwo = new BinaryNode<>(23);
        BinaryNode<Integer> t1_levelThreeLeftOne = new BinaryNode<>(2);
        BinaryNode<Integer> t1_levelThreeRightOne = new BinaryNode<>(4);
        BinaryNode<Integer> t1_levelThreeLeftTwo = new BinaryNode<>(7);
        BinaryNode<Integer> t1_levelThreeRightTwo = new BinaryNode<>(9);

        t1.setLeft(t1_levelOneLeftOne);
        t1.setRight(t1_levelOneRightOne);
        t1_levelOneLeftOne.setLeft(t1_levelTwoLeftOne);
        t1_levelOneLeftOne.setRight(t1_levelTwoRightOne);
        t1_levelOneRightOne.setLeft(t1_levelTwoLeftTwo);
        t1_levelOneRightOne.setRight(t1_levelTwoRightTwo);
        t1_levelTwoLeftOne.setLeft(t1_levelThreeLeftOne);
        t1_levelTwoLeftOne.setRight(t1_levelThreeRightOne);
        t1_levelTwoRightOne.setLeft(t1_levelThreeLeftTwo);
        t1_levelTwoRightOne.setRight(t1_levelThreeRightTwo);

        BinaryNode<Integer> t2 = new BinaryNode<>(8);
        BinaryNode<Integer> t2_levelOneLeftOne = new BinaryNode<>(7);
        BinaryNode<Integer> t2_levelOneRightOne = new BinaryNode<>(10);
        t2.setLeft(t2_levelOneLeftOne);
        t1.setRight(t2_levelOneRightOne);

        assertFalse(Problem48.contains(t1, t2));
    }
}