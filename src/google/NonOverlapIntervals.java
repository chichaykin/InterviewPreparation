package google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class NonOverlapIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int prevStart = intervals[0][0], prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0], e = intervals[i][1];
            if (s > prevEnd) {
                //add prev interval
                res.add(new int[]{prevStart, prevEnd});
                prevStart = s;
            }
            prevEnd = Math.max(prevEnd, e);
        }
        if (res.size() ==0 || res.get(res.size()-1)[1] != prevEnd) {
            res.add(new int[]{prevStart, prevEnd});
        }
        return res.toArray(new int[0][0]);
    }

    @Test
    public void test00() {
        int[][] in = {{1, 4}, {2, 3}};
        int[][] ex = {{1, 4}};
        assertArrayEquals(ex, merge(in));
    }

    @Test
    public void test0() {
        int[][] in = {{1, 4}, {4, 5}};
        int[][] ex = {{1, 5}};
        assertArrayEquals(ex, merge(in));
    }

    @Test
    public void test() {
        int[][] in = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ex = {{1, 6}, {8, 10}, {15, 18}};
        assertArrayEquals(ex, merge(in));
    }
}
