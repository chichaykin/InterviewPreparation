package microsoft;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

//https://leetcode.com/explore/interview/card/microsoft/47/sorting-and-searching/154/
public class SearchMatrix {

    public boolean searchMatrix(int[][] M, int target) {
        int rows = M.length, cols = M[0].length, lowRow = 0, hiRow = rows - 1;
        if (target < M[0][0] || target > M[rows - 1][cols - 1]) return false;
        int midRow = 0;
        while (lowRow <= hiRow) {
            midRow = lowRow + (hiRow - lowRow) / 2;
            if (target >= M[midRow][0] && target <= M[midRow][cols - 1]) {
                break;
            }
            if (target < M[midRow][0]) {
                hiRow = midRow - 1;
            } else {
                lowRow = midRow + 1;
            }
        }

        int col = Arrays.binarySearch(M[midRow], target);
        return col >= 0 ? true : false;
    }

    @Test
    public void test() {
        int[][] in = {{1, 10}};
        assertTrue(searchMatrix(in, 10));
    }

    @Test
    public void test2() {
        int[][] in = {{1, 10}};
        assertFalse(searchMatrix(in, 9));
        assertFalse(searchMatrix(in, 11));
        assertFalse(searchMatrix(in, 0));
    }

    @Test
    public void test3() {
        int[][] in = {{1}, {3}};
        assertFalse(searchMatrix(in, 2));
    }

    @Test
    public void test4() {
        int[][] in = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        assertTrue(searchMatrix(in, 3));
    }
}