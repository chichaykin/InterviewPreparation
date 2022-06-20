package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] >= 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count);
    }

    @Test
    public void test() {
        assertEquals(4, findLengthOfLCIS(new int[]{1,3,5,4,2,3,4,5}));
    }
}
