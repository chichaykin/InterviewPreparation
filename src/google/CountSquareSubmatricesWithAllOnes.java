package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountSquareSubmatricesWithAllOnes {
    int rows, cols;

    public int countSquares(int[][] m) {
        rows = m.length;
        cols = m[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (m[i][j] == 0) continue;
                if (i != 0 && j != 0) {
                    m[i][j] = 1 + Math.min(m[i][j-1], Math.min(m[i-1][j-1], m[i-1][j]));
                }
                res += m[i][j];
            }
        }

        return res;
    }

    @Test
    public void test3() {
        int[][] in = {
                {1},
        };
        assertEquals(1, countSquares(in));
    }

    @Test
    public void test2() {
        int[][] in = {
                {1, 1},
                {1, 1}
        };
        assertEquals(5, countSquares(in));
    }

    @Test
    public void test22() {
        int[][] in = {
                {1, 1},
                {1, 0}
        };
        assertEquals(3, countSquares(in));
    }

    @Test
    public void test() {
        int[][] in = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        assertEquals(15, countSquares(in));
    }

    @Test
    public void test4() {
        int[][] in = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        assertEquals(7, countSquares(in));
    }

    @Test
    public void test5() {
        int[][] in = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        assertEquals(30, countSquares(in));
    }
}
