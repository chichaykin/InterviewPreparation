package microsoft;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

//https://leetcode.com/explore/interview/card/microsoft/47/sorting-and-searching/206/
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] A) {
        if (A.length == 1) return A[0];
        int size = A.length;
        if (A[0] < A[size - 1]) return A[0];
        int l = 0, r = size - 1;
        while (l < r) {
            while(l < r && A[l] == A[l+1]) l++;
            int m = l + (r - l) / 2;
            if (m + 1 < size && A[m] > A[m + 1]) return A[m + 1];
            if (m > 0 && A[m] < A[m - 1]) return A[m];
            if (A[m] > A[l]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return A[l];
    }

    @Test
    public void test() {
        assertEquals(4, findMin(new int[]{4}));
    }

    @Test
    public void test2() {
        assertEquals(4, findMin(new int[]{6, 4}));
    }

    @Test
    public void test3() {
        assertEquals(4, findMin(new int[]{4, 5, 10}));
    }

    @Test
    public void test4() {
        assertEquals(2, findMin(new int[]{6, 5, 2, 3, 4}));
    }

    @Test
    public void test5() {
        assertEquals(0, findMin(new int[]{6, 7, 8, 0, 6}));
    }

    @Test
    public void test6() {
        assertEquals(0, findMin(new int[]{6, 7, 8, 9, 0}));
    }

    @Test
    public void test7() {
        assertEquals(0, findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    @Test
    public void test8() {
        assertEquals(1, findMin(new int[]{1, 1}));
    }

    @Test
    public void test9() {
        assertEquals(1, findMin(new int[]{3, 3, 3, 1}));
    }

    @Test
    public void test10() {
        assertEquals(1, findMin(new int[]{10, 1, 10, 10, 10}));
    }

    @Test
    public void test11() {
        assertEquals(1, findMin(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 1, 3}));
    }
}
