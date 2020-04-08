package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Solution {
    private Random rand = new Random();
    Map<Integer, Integer> map = new HashMap<>();
    private int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
    }

    public int pick(int target) {
        int index = Arrays.binarySearch(nums, target);
        int startIndex = index;
        while(startIndex - 1 > 0 && nums[startIndex - 1] == target) startIndex--;
        int endIndex = index;
        while(endIndex + 1 < nums.length && nums[endIndex + 1] == target) endIndex++;
        int diff = endIndex - startIndex + 1;
        return rand.nextInt(diff) + index;
    }
}


public class RandomInt {

    @Test
    public void test() {
        Solution sol = new Solution(new int[]{1,2,3,3,3,4});
        System.out.println(sol.pick(3));
        System.out.println(sol.pick(3));
        System.out.println(sol.pick(3));
        System.out.println(sol.pick(3));
    }
}
