package leetcode.facebook;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsGraphBipartite {
    private int nodes;
    private int[][] graph;
    int[] state;

    public boolean isBipartite(int[][] graph) {
        nodes = graph.length;
        this.graph = graph;
        state = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            if (state[i] != 0) continue;
            if (dfs(i, 1)) return false;
        }
        return true;
    }

    private boolean dfs(int i, int color) {
        state[i] = color;
        for (int n : graph[i]) {
            if (state[n] == 0) {
                if (dfs(n, color == 1 ? 2 : 1)) return true;
            } else if (state[i] == state[n]) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test2() {
        assertFalse(isBipartite(new int[][]{{1,2,3}, {0,2}, {0,1,3}, {0,2}}));
    }

    @Test
    public void test() {
        assertTrue(isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
    }
}
