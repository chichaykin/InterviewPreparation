package leetcode.google;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MinSwap {
    int min;
    int[] dp;
    public int minSwap(int[] nums1, int[] nums2) {
        min = Integer.MAX_VALUE;
        dp = new int[nums1.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        minSwap(nums1, nums2, 1, 0, true);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private void minSwap(int[] nums1, int[] nums2, int i, int swaps, boolean prevValidChange) {
        if (i >= nums1.length) return;
        if (nums1[i] <= nums1[i - 1] || nums2[i] <= nums2[i - 1]) {
            swaps++;
            if (prevValidChange && isPossibleChange(nums1, nums2, i - 1)) {
                swap(nums1, nums2, i - 1);
                minSwap(nums1, nums2, i + 1, swaps, true);
                swap(nums1, nums2, i - 1);
            }

            swap(nums1, nums2, i);
            minSwap(nums1, nums2, i + 1, swaps, false);
            swap(nums1, nums2, i);
        } else {
            minSwap(nums1, nums2, i + 1, swaps, true);
        }
        if (swaps != 0) min = Math.min(swaps, min);
    }

    private boolean isPossibleChange(int[] nums1, int[] nums2, int i) {
        if (i - 1 < 0) return true;

        return nums1[i-1] < nums2[i] && nums2[i-1] < nums1[i];
    }

    private void swap(int[] a, int[] b, int i) {
        int temp = a[i];
        a[i] = b[i];
        b[i] = temp;
    }

    @Test
    public void test0() {
        int[] a = {3};
        int[] b = {1};
        assertEquals(0, minSwap(a, b));
    }

    @Test
    public void test() {
        int[] a = {3, 3, 8, 9, 10};
        int[] b = {1, 7, 4, 6, 8};
        assertEquals(1, minSwap(a, b));
    }

    @Test
    public void test2() {
        int[] a = {0, 4, 4, 5, 9};
        int[] b = {0, 1, 6, 8, 10};
        assertEquals(1, minSwap(a, b));
    }

    @Test
    public void test3() {
        int[] a = {0, 7, 8, 10, 10, 11, 12, 13, 19, 18};
        int[] b = {4, 4, 5, 7, 11, 14, 15, 16, 17, 20};
        assertEquals(4, minSwap(a, b));
    }
}
