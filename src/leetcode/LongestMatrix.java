package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestMatrix {

    public int longestLine(int[][] M) {
        int rows = M.length;
        if (rows == 0) return 0;
        int columns = M[0].length;
        int max = 0;
        int maxPotential = Math.max(rows, columns);
        //horizontal
        for (int i = 0; i < rows; i++) {
            int count = 0;
            for (int j = 0; j < columns; j++) {
                if (M[i][j] == 1) {
                    count++;
                    max = Math.max(count, max);
                } else count = 0;
            }
        }
        // vertical
        for (int i = 0; i < columns; i++) {
            int count = 0;
            for (int j = 0; j < rows; j++) {
                if (M[j][i] == 1) {
                    count++;
                    max = Math.max(count, max);
                } else count = 0;
            }
        }

        if (max == maxPotential) return max;

        int maxDiagonal = Math.min(rows, columns);

        for (int i = 0; i < rows - 1; i++) {
            int count = 0;
            for (int k = i, j = 0; j < columns && k < rows; j++, k++) {
                if (M[k][j] == 1) {
                    count++;
                    max = Math.max(count, max);
                } else count = 0;
            }
        }

        for (int i = 1; i < columns - 1; i++) {
            int count = 0;
            for (int k = 0, j = i; j < columns; j++, k++) {
                if (M[k][j] == 1) {
                    count++;
                    max = Math.max(count, max);
                } else count = 0;
            }
        }

        for (int i = rows - 1; 0 <= i; i--) {
            int count = 0;
            for (int k = i, j = 0; j < columns && k >= 0; j++, k--) {
                if (M[k][j] == 1) {
                    count++;
                    max = Math.max(count, max);
                } else count = 0;
            }
        }

        for (int i = 1; i < columns; i++) {
            int count = 0;
            for (int k = rows - 1, j = i; j < columns && k > 0; j++, k--) {
                if (M[k][j] == 1) {
                    count++;
                    max = Math.max(count, max);
                } else count = 0;
            }
        }

        return max;
    }

    @Test
    public void test() {
        int input[][] = {
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 1}
        };
        assertEquals(3, longestLine(input));
    }
}
