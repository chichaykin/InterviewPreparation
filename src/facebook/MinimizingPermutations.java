package facebook;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MinimizingPermutations {
    private boolean increasing(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] >= arr[i]) return false;
        }
        return true;
    }

    int minOperations(int[] arr) {
        if (increasing(arr)) return 0;
        int size = arr.length;

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Set<List<Integer>> visited = new HashSet<>();
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(list); visited.add(list);
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            int n = q.size();
            System.out.println(String.format("n: %d", n));
            while (n > 0) {
                n--;
                list = q.poll();
                int i = 0;
                while (list.get(i) == i + 1) {
                    i++;
                }
                for (; i < size - 1; i++) {
                    for (int j = i + 1; j < size; j++) {
                        List<Integer> reversed = reverse(list, i, j);
                        //System.out.println(String.format("s: %d, e: %d: %s", i, j, reversed));
                        if (isIncreasing(reversed)) {
                            return count;
                        }
                        if (!q.contains(reversed)) {
                            visited.add(reversed);
                            q.add(reversed);
                        }
                    }
                }
            }
        }

        return count;
    }

    private boolean isIncreasing(List<Integer> reversed) {
        for (int i = 0; i < reversed.size(); i++) {
            if (reversed.get(i) != i + 1) return false;
        }
        return true;
    }

    private List<Integer> reverse(List<Integer> list, int left, int right) {
        List<Integer> reversed = new ArrayList(list);
        while (left < right) {
            int tmp = reversed.get(left);
            reversed.set(left, reversed.get(right));
            reversed.set(right, tmp);
            left++;
            right--;
        }
        return reversed;
    }

    @Test
    public void test() {
        int[] arr_1 = {1, 2, 5, 4, 3};
        assertEquals(1, minOperations(arr_1));
    }


}
