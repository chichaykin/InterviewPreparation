package meta;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReverseArrayMakeItEqual {
    boolean areTheyEqual(int[] a, int[] b) {
        // Write your code here
        if (a.length != b.length) return false;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && a[i] != b[j]) j++;
            if (j == n) return false;

            swapRange(b, i, j);
        }
        return true;
    }

    private void swapRange(int[] b, int l, int r) {
        while (l != r) {
            int temp = b[l];
            b[l] = b[r];
            b[r] = temp;
            l++;
            r--;
        }
    }

    @Test
    public void test() {
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 4, 3, 2};
        assertTrue(areTheyEqual(a, b));
    }

    @Test
    public void test2() {
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 4, 3, 3};
        assertFalse(areTheyEqual(a, b));
    }
}
