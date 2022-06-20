package google;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class informAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (informTime[headID] == 0) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            List<Integer> list = map.getOrDefault(manager[i], new ArrayList<>());
            list.add(i);
            map.putIfAbsent(manager[i], list);
        }
        return dfs(map, headID, manager, informTime);
    }

    private int dfs(Map<Integer, List<Integer>> map, int headID, int[] manager, int[] informTime) {
        if (informTime[headID] == 0) return 0;
        int time = 0;
        for (int sub : map.get(headID)) {
            time = Math.max(time, dfs(map, sub, manager, informTime));
        }
        return informTime[headID] + time;
    }

    @Test
    public void test() {
        int[] manager = {-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        int[] informTime = {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        assertEquals(3, numOfMinutes(15, 0, manager, informTime));
    }


}
