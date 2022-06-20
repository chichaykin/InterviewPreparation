package facebook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();
        int lastInc = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = lastInc; j < B.length; j++) {
                System.out.println("[" + A[i][0] + "," + A[i][1] + "], [" + B[j][0] + "," + B[j][1] + "]");

                if (A[i][1] < B[j][0]) {
                    break;
                } else if (A[i][0] > B[j][1]) {
                    lastInc = j + 1;
                    continue;
                } else {
                    int start = Math.max(A[i][0], B[j][0]);
                    int end = Math.min(A[i][1], B[j][1]);
                    result.add(new int[]{start, end});
                    lastInc = j;
                }
            }
        }
        return result.toArray(new int[0][]);
    }

    @Test
    public void test() {
        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        assertArrayEquals(new int[][]{{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}},
                intervalIntersection(A, B));

    }
}
