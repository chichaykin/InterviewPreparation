package google;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TrimMean {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        int n = arr.length;
        int num = n / 20;
        for (int i = num; i < arr.length - num; i++) {
            sum += arr[i];
        }
        return sum / (arr.length - 2 * num);
    }

    @Test
    public void test1() {
        int[] in = {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        assertEquals(2, trimMean(in), 0);
    }

    @Test
    public void test2() {
        int[] in = {6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0};
        assertEquals(4, trimMean(in), 0);
    }
}
