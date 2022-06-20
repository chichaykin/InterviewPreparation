package google;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MatrixBlockSum {
    int m[][];
    int rows, cols;

    public int[][] matrixBlockSum(int[][] mat, int k) {
        rows = mat.length;
        cols = mat[0].length;
        m = mat;
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                calc(res, i, j, k);
            }
        }
        return res;
    }

    private void calc(int[][] res, int row, int col, int k) {
        int startR = Math.max(0, row - k), endR = Math.min(row + k, rows - 1);
        int startC = Math.max(0, col - k), endC = Math.min(col + k, cols - 1);
        int sum = 0;
        for (int i = startR; i <= endR; i++) {
            for (int j = startC; j <= endC; j++) {
                sum += m[i][j];
            }
        }
        res[row][col] = sum;
    }

    @Test
    public void test() {
        int in[][] = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };

        int ex[][] = {
                {12, 21, 16}, {27, 45, 33}, {24, 39, 28}
        };

        assertArrayEquals(ex, matrixBlockSum(in, 1));
    }
}
