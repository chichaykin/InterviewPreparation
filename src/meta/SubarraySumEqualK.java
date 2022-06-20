package meta;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SubarraySumEqualK {
    public int subarraySum(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums.length == 0) return 0;
        int l = 0, r = nums.length - 1;
        int count = 0;
        while (l <= r) {
            if (r != 0 && (nums[r - 1] + nums[r]) < k) break;
            if (nums[r] == k) {
                count++;
                r--;
            }
            if (l == r) break;
            if (k == (nums[l] + nums[r])) count++;
            if (k >= (nums[l] + nums[r])) l++;
            else if (k < (nums[l] + nums[r])) r--;
        }
        return count;
    }

    @Test
    public void test() {
        int[] in = {1,2,1,2,1};
        assertEquals(4, subarraySum(in, 3));
    }
}
