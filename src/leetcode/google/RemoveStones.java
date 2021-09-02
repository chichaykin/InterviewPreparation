package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveStones {
    public int removeStones(int[][] stones) {
        int all = stones.length;
        int[] parents = new int[all];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < all; i++) {
            for (int j = i + 1; j < all; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j, parents);
                }
            }
        }

        int islands = 0;
        for (int i = 0; i < all; i++) {
            if (parents[i] == i) islands++;
        }
        return all - islands;
    }

    private void union(int i, int j, int[] parents) {
        i = find(i, parents);
        j = find(j, parents);
        if (i != j) {
            parents[i] = j;
        }
    }

    private int find(int i, int[] parent) {
        while (parent[i] != i) {
             parent[i] = parent[parent[i]];
             i = parent[i];
        }
        return parent[i];
    }

    @Test
    public void test3() {
        int[][] in = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
        assertEquals(3, removeStones(in));
    }

    @Test
    public void test2() {
        int[][] in = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        assertEquals(5, removeStones(in));
    }

    @Test
    public void test() {
        int[][] in = {{0, 1}, {1, 0}, {1, 1}};
        assertEquals(2, removeStones(in));
    }
}
