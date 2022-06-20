package facebook;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        int size = A.length;
        if (size < 3) return 0;
        int slices = 0;
        for (int i = 0; i < size - 2; i++) {
            int diff = A[i] - A[i + 1];
            for (int prev = i + 1, next = i + 2, items = 3; next < size; prev++, next++, items++) {
                if (A[prev] - A[next] != diff) {
                    break;
                }
                if (items >= 3) {
                    slices++;
                }
            }

        }
        return slices;
    }

    @Test
    public void test() {
        assertEquals(3, numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }
}
