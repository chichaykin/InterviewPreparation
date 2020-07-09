package leetcode.facebook;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if (index == -1) return new int[]{-1, -1};
        int temp = index;
        int left = index;
        while (--index >= 0 && nums[index] == target) left = index;
        int right = index = temp;
        while (++index < nums.length && nums[index] == target) right = index;
        return new int[]{left, right};
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int res = nums[m] - target;
            if (res == 0) return m;
            if (res > 0) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }

    @Test
    public void testR2() {
        int[] in = new int[]{2, 2};
        assertArrayEquals(new int[]{0, 1}, searchRange(in, 2));
    }

    @Test
    public void testR() {
        int[] in = new int[]{5, 7, 7, 8, 8, 10};
        assertArrayEquals(new int[]{-1, -1}, searchRange(in, 6));
        in = new int[]{5, 7, 7, 8, 8, 10};
        assertArrayEquals(new int[]{3, 4}, searchRange(in, 8));
    }

    @Test
    public void test() {
        int[] in = new int[]{};
        assertEquals(-1, binarySearch(in, 4));
        in = new int[]{0, 1};
        assertEquals(1, binarySearch(in, 1));
        in = new int[]{0};
        assertEquals(0, binarySearch(in, 0));
        in = new int[]{0, 1, 3, 5, 8, 10};
        assertEquals(5, binarySearch(in, 10));
        assertEquals(4, binarySearch(in, 8));
    }
}
