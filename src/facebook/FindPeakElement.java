package facebook;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int size = nums.length;
        if (size < 2) return 0;
        for (int i = 0; i < size - 1; i++) {
            if(nums[i] > nums[i+1]) return i;
        }
        return size-1;
    }

    @Test
    public void test() {
        int[] in = {1,2,3,1};
        assertEquals(2, findPeakElement(in));
    }
}
