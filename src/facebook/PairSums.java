package facebook;

import java.util.HashMap;
import java.util.Map;

public class PairSums {
    int numberOfWays(int[] arr, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for(int i: arr) {
            int diff = k - i;
            if (map.containsKey(diff)) {
                int rem = map.get(diff) - 1;
                if (rem == 0) map.remove(diff);
                else map.put(diff, rem);
                count++;
            }
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return count;
    }
}
