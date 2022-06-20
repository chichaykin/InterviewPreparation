package facebook;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> inEdges = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
            inEdges.put(i, 0);
        }

        for (int[] prerequisite : prerequisites) {
            int dependant = prerequisite[0];
            int course = prerequisite[1];
            map.get(course).add(dependant);
            inEdges.put(dependant, inEdges.get(dependant) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        inEdges.forEach((key, count) -> {
            if (count == 0) queue.add(key);
        });
        while (!queue.isEmpty()) {
            int course = queue.remove();
            result.add(course);
            for (int dependant : map.get(course)) {
                inEdges.put(dependant, inEdges.get(dependant) - 1);
                if (inEdges.get(dependant) == 0) queue.add(dependant);
            }
        }
        return result.size() < numCourses ? new int[0] : result.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[]{0,1,2,3}, findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}));
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{0,1}, findOrder(2, new int[][]{{1,0}}));
    }
}
