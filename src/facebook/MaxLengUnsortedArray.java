package facebook;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxLengUnsortedArray {
    int x, y;
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 2) return nums.length;

        int max = 1, curLen = 1;
        for(int i=1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                curLen++;
            } else {
                max = Math.max(max, curLen);
                curLen = 1;
            }
        }
        return Math.max(max, curLen);
    }

    @Test
    public void test() {
        assertEquals(3, findLengthOfLCIS(new int[]{1,3,5,4,7}));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaxLengUnsortedArray that = (MaxLengUnsortedArray) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
