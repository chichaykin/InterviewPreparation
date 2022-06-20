package meta;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SlidingWindowMean {

    public double[] medianSlidingWindow(int[] nums, int k) {
        int size = nums.length;
        int l = 0;
        double[] result = new double[size - k + 1];
        int[] buffer = new int[k];
        while (l < result.length) {
            result[l] = median(nums, l, buffer);
            l++;
        }
        return result;
    }

    private double median(int[] nums, int l, int[] buffer) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = nums[l + i];
        }

        Arrays.sort(buffer);
        int med = (buffer.length - 1) / 2;
        if (buffer.length % 2 == 0) {
            return Long.sum(buffer[med], buffer[med + 1])/ 2.0;
        }
        return buffer[med];
    }

    @Test
    public void test3() {
        int[] in = {1,4,2,3};
        double[] exp = {2.5};
        assertArrayEquals(exp, medianSlidingWindow(in, 4), 0.0);
    }

    @Test
    public void test2() {
        int[] in = {2147483647,2147483647};
        double[] exp = {2147483647};
        assertArrayEquals(exp, medianSlidingWindow(in, 2), 0.0);
    }

    @Test
    public void test() {
        int[] in = {1, 3, -1, -3, 5, 3, 6, 7};
        double[] exp = {1.0, -1.0, -1.0, 3.0, 5.0, 6.0};
        assertArrayEquals(exp, medianSlidingWindow(in, 3), 0.0);
    }


}
