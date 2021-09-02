package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class longestSubarray {
    public int longestSubarray(int[] nums, int limit) {
        if (nums.length == 1) return 1;
        int first = 0, next = 1, len = 1, max = 0;
        while (first < nums.length - 1 && next < nums.length) {
            if (Math.abs(nums[first] - nums[next]) <= limit) {
                len++;
                next++;
            } else {
                max = Math.max(max, len);
                len = 1;
                first++;
                next = first + 1;
            }
        }
        return Math.max(max, len);
    }

    @Test
    public void test() {
        int[] in = {1,5,6,7,8,10,6,5,6};
        assertEquals(5, longestSubarray(in, 4));
    }
}
