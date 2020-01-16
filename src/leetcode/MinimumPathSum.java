package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < m; j++) {
            grid[0][j] = grid[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i][j-1], grid[i-1][j]) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }

    @Test
    public void test() {
        int[][] in = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        assertEquals(7, minPathSum(in));
    }

}
