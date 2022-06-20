package facebook;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchinRotatedSortedArray {
    public int search(int[] in, int target) {
        int l = 0, r = in.length - 1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if (in[m] == target) return m;
            if (in[l] > target && in[r] >= target ) {
                //to right
                l = m + 1;
            } else {
                //to left
                r = m;
            }
        }
        return -1;
    }

    @Test
    public void test4() {
        int[] in = {1,3};
        assertEquals(1, search(in, 3));
    }

    @Test
    public void test3() {
        int[] in = {1};
        assertEquals(0, search(in, 1));
    }

    @Test
    public void test2() {
        int[] in = {1};
        assertEquals(4, search(in, 2));
    }

    @Test
    public void test() {
        int[] in = {4,5,6,7,0,1,2};
        assertEquals(4, search(in, 0));
    }
}
