package leetcode.google;

import java.util.LinkedList;
import java.util.Queue;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) return;

        Queue<Integer> q = new LinkedList<>();
        for (int num : nums) {
            q.add(num);
        }

        int i = 0;
        while (!q.isEmpty()) {
            int n = q.remove();
            if (i == 0) {
                nums[i] = n;
            } else if ( (i+1) % 2 == 0) {
                if (nums[i-1] <= n) {
                    nums[i] = n;
                } else {
                    int temp = nums[i-1];
                    nums[i-1] = n;
                    nums[i] = temp;
                }
            } else {
                if (nums[i-1] >= n) {
                    nums[i] = n;
                } else {
                    int temp = nums[i-1];
                    nums[i-1] = n;
                    nums[i] = temp;
                }
            }
            i++;
        }
    }
}
