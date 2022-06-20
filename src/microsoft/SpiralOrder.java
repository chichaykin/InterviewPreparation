package microsoft;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
//medium
//https://leetcode.com/problems/spiral-matrix/
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = 0, col = 0, minRow = 0, minCol = 0;
        int maxCol = matrix[0].length - 1, maxRow = matrix.length - 1;
        while (true) {
            // Right
            while (col <= maxCol) {
                result.add(matrix[row][col++]);
            }
            col = maxCol;
            minRow++; row = minRow;
            if (minRow > maxRow) break;
            // Down
            while (row <= maxRow) {
                result.add(matrix[row++][col]);
            }
            row = maxRow;
            maxCol--; col = maxCol;
            if (maxCol < minCol) break;
            // Left
            while (col >= minCol) {
                result.add(matrix[row][col--]);
            }
            col = minCol;
            maxRow--; row = maxRow;
            if (maxRow < minRow) break;
            // Up
            while (row >= minRow) {
                result.add(matrix[row--][col]);
            }
            row = minRow;
            minCol++; col = minCol;
            if (maxCol < minCol) break;
        }
        return result;
    }

    @Test
    public void test() {
        int[][] in = {
                {1, 2},
                {3, 4}
        };
        assertEquals(Arrays.asList(1, 2, 4, 3), spiralOrder(in));
    }

    @Test
    public void test2() {
        int[][] in = {
                {1},
                {2},
                {3}
        };
        assertEquals(Arrays.asList(1, 2, 3), spiralOrder(in));
    }

    @Test
    public void test3() {
        int[][] in = {
                {1, 2, 3},
        };
        assertEquals(Arrays.asList(1, 2, 3), spiralOrder(in));
    }
}
