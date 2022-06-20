package facebook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(t -> t[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1, r = 0; i < intervals.length; i++) {
            int[] prev = result.get(r);
            if (prev[1] >= intervals[i][0]) {
                prev[1] = Math.max(intervals[i][1], prev[1]);
            } else {
                result.add(intervals[i]);
                r++;
            }
        }
        return result.toArray(new int[][]{});
    }

    @Test
    public void test() {
        int[][] input = {{1, 4}, {4, 5}};
        int[][] expected = {{1, 5}};
        assertArrayEquals(expected, merge(input));
    }

    @Test
    public void test2() {
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};
        assertArrayEquals(expected, merge(input));
    }

    @Test
    public void test3() {
        int[][] input = {{1, 4}, {0, 4}};
        int[][] expected = {{0, 4}};
        assertArrayEquals(expected, merge(input));
    }

    @Test
    public void test4() {
        int[][] input = {{1, 4}, {0, 0}};
        int[][] expected = {{0, 0}, {1, 4}};
        assertArrayEquals(expected, merge(input));
    }
}
