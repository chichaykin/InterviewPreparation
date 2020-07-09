package leetcode.facebook;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int p = 1;
        int size = nums.length;
        for (int i = size - 1; i >= 0; i--) {
            p *= nums[i];
            result[i] = p;
        }
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < size) {
                result[i] = result[i + 1] * left;
            } else {
                result[i] = left;
            }
            left *= nums[i];
        }
        return result;
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[]{0, 1}, productExceptSelf(new int[]{1, 0}));
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{24, 12, 8, 6}, productExceptSelf(new int[]{1, 2, 3, 4}));
    }
}
