package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> prev = result.get(i - 1);
            for (int j = 0; j <= i; j++) {
                int left = (j - 1) < 0 ? 0 : prev.get(j - 1);
                int right = j < prev.size() ? prev.get(j) : 0;
                int sum = left + right;
                list.add(sum);
            }
            result.add(list);
        }
        return result;
    }

    @Test
    public void test() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(1, 1));
        expected.add(Arrays.asList(1, 2, 1));
        expected.add(Arrays.asList(1, 3, 3, 1));
        expected.add(Arrays.asList(1, 4, 6, 4, 1));
        assertEquals(expected, generate(5));
    }
}
