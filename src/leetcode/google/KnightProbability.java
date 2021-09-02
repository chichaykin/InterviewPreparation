package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightProbability {
    int[][] dirs = {
            {2, -1}, {2, 1},
            {-2, -1}, {-2, 1},
            {-1, 2}, {1, 2},
            {-1, -2}, {1, -2}
    };

    int n;

    public double knightProbability(int n, int k, int row, int column) {
        int dp[][][] = new int[row][column][k];
        this.n = n;
        return check(k, row, column, dp);
    }

    private double check(int row, int column, int k, int[][][] dp) {
        if (k == 0) return 1.0;
        double pr = 0.0;

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = column + dir[1];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                pr += 0.0625 * check(newRow, newCol, k - 1, dp);
            }
        }
        return pr;
    }

    @Test
    public void test() {
        assertEquals(0.06250, knightProbability(3, 2, 0, 0), 0.0);
    }

    @Test
    public void test2() {
        assertEquals(0.11734, knightProbability(10, 13, 5, 3), 0.0);
    }
}
