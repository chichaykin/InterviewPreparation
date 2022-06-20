package microsoft;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A.length == 0) return -1;
        if (A.length == 1) return A[0] == target ? 0 : -1;
        int N = A.length;
        int low = 0, hi = N - 1;

        while (low <= hi) {
            int m = low + (hi - low) / 2;
            if (A[m] == target) return m;

            if (A[m] >= A[low]) { //left part is sorted
                if (target < A[m] && target >= A[low]) {
                    hi = m - 1;
                } else {
                    low = m + 1;
                }
            } else { // right part is sorted
                if (target > A[m] && target <= A[hi]) {
                    low = m + 1;
                } else {
                    hi = m - 1;
                }
            }
        }
        // no elements
        return -1;
    }

    @Test
    public void test3() {
        int[] in = {3, 1};
        assertEquals(1, search(in, 1));
    }

    @Test
    public void test2() {
        int[] in = {1, 3};
        assertEquals(-1, search(in, 4));
    }

    @Test
    public void test1() {
        int[] in = {1, 3};
        assertEquals(-1, search(in, 2));
    }

    @Test
    public void test() {
        int[] in = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(4, search(in, 0));
    }
}
