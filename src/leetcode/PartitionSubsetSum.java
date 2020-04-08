package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PartitionSubsetSum {

    public int countSubset(int[] arr, int total) {
        Map<String, Integer> map = new HashMap<>();
        return dp(arr, total, arr.length - 1, map);
    }

    private int dp(int[] arr, int total, int i, Map<String, Integer> map) {
        String key = total + ":" + i;
        if (map.containsKey(key)) return map.get(key);

        if (total == 0) return 1;
        else if (i < 0) return 0;
        else if (total < 0) return 0;

        int count;
        if (total < arr[i]) { count = dp(arr, total, i - 1, map); }
        else {
            count = dp(arr, total, i - 1, map) + dp(arr, total - arr[i], i - 1, map);
        }
        map.put(key, count);
        System.out.println(String.format("count: %d, key: %s", count, key));
        return count;
    }

    @Test
    public void test() {
        assertEquals(2, countSubset(new int[]{2, 4, 6, 10}, 16));
    }

}
