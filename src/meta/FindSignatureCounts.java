package meta;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.Assert.assertArrayEquals;

public class FindSignatureCounts {
    int[] findSignatureCounts(int[] arr) {
        Queue<int[]> q = new ArrayDeque<>();
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            q.add(new int[]{i + 1, arr[i]});
            result[i] = 1;
        }

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                int[] sign = q.poll();
                int owner = sign[0];
                int signer = sign[1];
                if (owner != signer) {
                    result[owner - 1] += 1;
                    sign[1] = arr[signer - 1]; // next signer
                    q.add(sign);
                }
            }
        }

        return result;
    }

    @Test
    public void run() {
        int[] arr_1 = {2, 1};
        int[] expected_1 = {2, 2};
        int[] output_1 = findSignatureCounts(arr_1);
        assertArrayEquals(expected_1, output_1);

        int[] arr_2 = {1, 2};
        int[] expected_2 = {1, 1};
        int[] output_2 = findSignatureCounts(arr_2);
        assertArrayEquals(expected_2, output_2);
    }
}
