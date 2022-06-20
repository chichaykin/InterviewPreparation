package meta;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FindMedianInStream {
    int[] findMedian(int[] arr) {
        // Write your code here
        int[] result = new int[arr.length];
        result[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while(j > 0 && arr[j] < arr[j-1]) {
                swap(arr, j, j-1);
                j--;
            }
            int size = i + 1;
            if (size % 2 == 0) {
                result[i] = (arr[i / 2] + arr[i / 2 + 1])/2;
            } else {
                result[i] = arr[i / 2];
            }
        }
        return result;
    }

    private void swap(int[] arr, int j, int i) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    @Test
    public void test() {
        int[] in = {5, 15, 1, 3};
        int[] expected = {5, 10, 5, 4};
        assertArrayEquals(expected, findMedian(in));
    }
}
