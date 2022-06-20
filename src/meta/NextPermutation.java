package meta;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

//Medium
//https://leetcode.com/problems/next-permutation/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int end = nums.length - 1, right = end;
        while (right > 0) {
            if (nums[right] > nums[right - 1]) {
                Arrays.sort(nums, right, nums.length);
                int i = right;
                while (nums[right - 1] >= nums[i] && i <= end) i++;
                swap(nums, right - 1, i);
                Arrays.sort(nums, right, nums.length);
                return;
            }
            right--;
        }

        int l = 0, r = end;
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    @Test
    public void test0() {
        int[][] num = {
                {1, 5, 1},
                {2, 3, 1},
                {1, 3, 2},
                {1, 2, 3},
                {3, 2, 1},
                {1, 1, 5},
                {1, 4, 5, 2},
                {5,4,7,5,3,2}
        };
        int[][] expected = {
                {5, 1, 1},
                {3, 1, 2},
                {2, 1, 3},
                {1, 3, 2},
                {1, 2, 3},
                {1, 5, 1},
                {1, 5, 2, 4},
                {5,5,2,3,4,7}
        };
        for (int i = 0; i < num.length; i++) {
            nextPermutation(num[i]);
            assertArrayEquals(Arrays.toString(expected[i]), expected[i], num[i]);
        }
    }
}
