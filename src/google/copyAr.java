package google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class copyAr {
    public void duplicateZeros(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        for (int i = 0, j = 0; j < copy.length; j++, i++) {
            if (copy[i] == 0) {
                arr[j] = 0; j++;
                if (j< arr.length) arr[j] = 0;
            } else {
                arr[j] = copy[i];
            }
        }
    }

    @Test
    public void test() {
        int[] in = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(in);
        Assert.assertArrayEquals(new int[]{1, 0, 0, 2, 3, 0, 0, 4}, in);

    }

    @Test
    public void test2() {
        int[] in = {1,0,7,2,4,3,1,0,2,6};
        duplicateZeros(in);
        Assert.assertArrayEquals(new int[]{1,0,0,7,2,4,3,1,0,0}, in);

    }


}
