package chapter4;

import chapter4.aux.GraphNode;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestProblem42 {
    @Test(expected = IllegalArgumentException.class)
    public void testBreadthFirstWithNull() {
        Problem42.hasConnection(null, new GraphNode<>("a"));
    }

    @Test
    public void testHasConnectionEqualsTrueWithTree() {
        GraphNode<String> a = new GraphNode<>("A");
        GraphNode<String> b = new GraphNode<>("B");
        GraphNode<String> c = new GraphNode<>("C");
        GraphNode<String> d = new GraphNode<>("D");
        GraphNode<String> e = new GraphNode<>("E");
        GraphNode<String> f = new GraphNode<>("F");
        a.setConnections(new ArrayList<GraphNode<String>>() {{ add(b); }});
        b.setConnections(new ArrayList<GraphNode<String>>() {{ add(c); }});
        c.setConnections(new ArrayList<GraphNode<String>>() {{ add(d); }});
        c.setConnections(new ArrayList<GraphNode<String>>() {{ add(d); }});
        d.setConnections(new ArrayList<GraphNode<String>>() {{ add(b); add(e); }});
        f.setConnections(new ArrayList<GraphNode<String>>() {{ add(c); }});
        assertTrue(Problem42.hasConnection(a, e));
    }

    @Test
    public void testHasConnectionEqualsFalseWithTree() {
        GraphNode<String> a = new GraphNode<>("A");
        GraphNode<String> b = new GraphNode<>("B");
        GraphNode<String> c = new GraphNode<>("C");
        GraphNode<String> d = new GraphNode<>("D");
        GraphNode<String> e = new GraphNode<>("E");
        GraphNode<String> f = new GraphNode<>("F");
        a.setConnections(new ArrayList<GraphNode<String>>() {{ add(b); }});
        b.setConnections(new ArrayList<GraphNode<String>>() {{ add(c); }});
        c.setConnections(new ArrayList<GraphNode<String>>() {{ add(d); }});
        c.setConnections(new ArrayList<GraphNode<String>>() {{ add(d); }});
        d.setConnections(new ArrayList<GraphNode<String>>() {{ add(b); add(e); }});
        f.setConnections(new ArrayList<GraphNode<String>>() {{ add(c); }});
        assertFalse(Problem42.hasConnection(a, f));
    }
}