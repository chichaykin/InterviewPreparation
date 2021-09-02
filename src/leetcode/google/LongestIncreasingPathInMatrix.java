package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestIncreasingPathInMatrix {
    int rows, cols;

    public int longestIncreasingPath(int[][] m) {
        rows = m.length;
        cols = m[0].length;
        int counter = 1;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(i, j, m, dp);
                counter = Math.max(counter, dp[i][j]);
            }
        }
        return counter;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void dfs(int row, int col, int[][] m, int[][] dp) {
        if (dp[row][col] != 0) return;
        int result = 1;
        for (int[] dir : dirs) {
            int nRow = row + dir[0], nCol = col + dir[1];
            if (nRow < 0 || nRow == rows || nCol < 0 || nCol == cols
                    || m[row][col] >= m[nRow][nCol]
            ) continue;

            dfs(nRow, nCol, m, dp);
            result = Math.max(result, dp[nRow][nCol] + 1);
        }

        dp[row][col] = result;
    }

    @Test
    public void test() {
        int[][] in = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        assertEquals(4, longestIncreasingPath(in));
    }

    @Test
    public void test2() {
        int[][] in = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        assertEquals(4, longestIncreasingPath(in));
    }
}
