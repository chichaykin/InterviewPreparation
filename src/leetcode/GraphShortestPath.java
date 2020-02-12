package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphShortestPath {

    public int shortestPathLength(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.println(i + "=" + (1<<i));
        }
        return 1 << graph.length;
    }

    @Test
    public void test() {
        assertEquals(2, shortestPathLength(new int[][] {{1}, {2}, {3}, {4}, {5}, {6}}));
    }
}
