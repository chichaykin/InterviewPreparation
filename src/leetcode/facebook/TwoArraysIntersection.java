package leetcode.facebook;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TwoArraysIntersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[nums1.length];
        int index = 0, i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            int val = nums1[i];
            if (val == nums2[j]) {
                result[index++] = val;
                while(++i < nums1.length && nums1[i] == val);
                while(++j < nums2.length && nums2[j] == val);
            } else if (val < nums2[j]){
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOf(result, index);
    }

    @Test
    public void test() {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        int[] result = intersection(nums1, nums2);
        assertArrayEquals(Arrays.toString(result), new int[]{2}, result);
    }

    @Test
    public void test2() {
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        int[] result = intersection(nums1, nums2);
        assertArrayEquals(Arrays.toString(result), new int[]{4,9}, result);
    }

}
