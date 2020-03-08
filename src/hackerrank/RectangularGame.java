package hackerrank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangularGame {
    long solve(int[][] steps) {
        long x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
        for (int[] pair : steps) {
            x = Math.min(pair[0], x);
            y = Math.min(pair[1], y);
        }
        return x * y;
    }

    @Test
    public void test() {
        int[][] input = {
                {1000000, 1000000},
                {1000000, 1000000},
                {1000000, 1000000}
        };

        assertEquals(1000000000000L, solve(input));
    }
}
