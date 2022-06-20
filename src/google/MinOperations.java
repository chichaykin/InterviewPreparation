package google;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MinOperations {
    public int[] minOperations(String boxes) {
        int[] ar = new int[boxes.length()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = boxes.charAt(i) - '0';
        }
        int min[] = new int[ar.length], balls = 0;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] != 0) {
                min[0] += i;
                balls++;
            }
        }

        int left = 0, right = balls;
        for (int i = 1; i < ar.length; i++) {
            int count = min[i - 1];
            if (ar[i] != 0) {
                right--;
                count--;
            }
            if (ar[i - 1] != 0) left++;
            count = count - right + left;
            min[i] = count;
        }
        return min;
    }

    @Test
    public void test() {
        int[] ex = {6,5,4,5,6};
        assertArrayEquals(ex, minOperations("10101"));
    }


}
