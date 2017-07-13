package chapter9;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestProblem94 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNull() {
        Problem94.generateSubsets(null);
    }

    @Test
    public void testWithEmpty() {
        Set<Integer> empty = new HashSet<>();
        assertTrue(Problem94.generateSubsets(empty).contains(new HashSet<>()));
    }

    @Test
    public void testWithOneElement() {
        Set<Integer> set = new HashSet<>();
        set.add(23);
        List<Set<Integer>> subsets = Problem94.generateSubsets(set);
        assertEquals(2, subsets.size());
        assertTrue(subsets.contains(new HashSet<>(set)));
        assertTrue(subsets.contains(new HashSet<>()));
    }

    @Test
    public void testWithTwoElements() {
        Set<Integer> set = new HashSet<>();
        set.add(23);
        set.add(24);
        List<Set<Integer>> subsets = Problem94.generateSubsets(set);
        assertEquals(4, subsets.size());
        assertTrue(subsets.contains(new HashSet<>(set)));
        assertTrue(subsets.contains(new HashSet<Integer>() {{ add(23); }}));
        assertTrue(subsets.contains(new HashSet<Integer>() {{ add(24); }}));
        assertTrue(subsets.contains(new HashSet<>()));
    }

    @Test
    public void testWithThreeElements() {
        Set<Integer> set = new HashSet<>();
        set.add(23);
        set.add(24);
        set.add(25);
        List<Set<Integer>> subsets = Problem94.generateSubsets(set);
        assertEquals(8, subsets.size());
        assertTrue(subsets.contains(new HashSet<>(set)));
        assertTrue(subsets.contains(new HashSet<Integer>() {{ add(23); add(24); }}));
        assertTrue(subsets.contains(new HashSet<Integer>() {{ add(24); add(25); }}));
        assertTrue(subsets.contains(new HashSet<Integer>() {{ add(23); add(25); }}));
        assertTrue(subsets.contains(new HashSet<Integer>() {{ add(23); }}));
        assertTrue(subsets.contains(new HashSet<Integer>() {{ add(24); }}));
        assertTrue(subsets.contains(new HashSet<Integer>() {{ add(25); }}));
        assertTrue(subsets.contains(new HashSet<>()));
    }
}