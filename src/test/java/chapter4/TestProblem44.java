package chapter4;

import chapter4.aux.BinaryNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestProblem44 {
    @Test
    public void testWithOneElement() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        List<List<BinaryNode<Integer>>> list = Problem44.listify(root);
        assertNotNull(list);
        assertEquals(1, list.size());
        assertEquals(1, list.get(0).size());
        assertEquals(root, list.get(0).iterator().next());
    }

    @Test
    public void testWithTwoElements() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> left = new BinaryNode<>(2);
        BinaryNode<Integer> right = new BinaryNode<>(3);
        root.setLeft(left);
        root.setRight(right);
        List<List<BinaryNode<Integer>>> list = Problem44.listify(root);
        assertNotNull(list);
        assertEquals(2, list.size());
        assertEquals(1, list.get(0).size());
        assertEquals(root, list.get(0).iterator().next());
        assertEquals(2, list.get(1).size());
        assertEquals(left, list.get(1).get(0));
        assertEquals(right, list.get(1).get(1));
    }

    @Test
    public void testWithSevenElements() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> left = new BinaryNode<>(2);
        BinaryNode<Integer> right = new BinaryNode<>(3);
        BinaryNode<Integer> leftleft = new BinaryNode<>(4);
        BinaryNode<Integer> leftright = new BinaryNode<>(5);
        BinaryNode<Integer> leftleftleft = new BinaryNode<>(6);
        BinaryNode<Integer> leftleftright = new BinaryNode<>(7);
        root.setLeft(left);
        left.setLeft(leftleft);
        left.setRight(leftright);
        leftleft.setLeft(leftleftleft);
        leftleft.setRight(leftleftright);
        root.setRight(right);
        List<List<BinaryNode<Integer>>> list = Problem44.listify(root);
        assertNotNull(list);
        assertEquals(4, list.size());
        assertEquals(1, list.get(0).size());
        assertEquals(2, list.get(1).size());
        assertEquals(2, list.get(2).size());
        assertEquals(2, list.get(3).size());
        assertEquals(root, list.get(0).iterator().next());
        assertEquals(left, list.get(1).get(0));
        assertEquals(right, list.get(1).get(1));
        assertEquals(leftleft, list.get(2).get(0));
        assertEquals(leftright, list.get(2).get(1));
        assertEquals(leftleftleft, list.get(3).get(0));
        assertEquals(leftleftright, list.get(3).get(1));
    }
}