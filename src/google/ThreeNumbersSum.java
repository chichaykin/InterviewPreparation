package google;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//https://leetcode.com/explore/interview/card/google/59/array-and-strings/3049/
public class ThreeNumbersSum {
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;

        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) map.put(nums[i], i);
        }
        System.out.println("Array sorted: " + Arrays.toString(nums));
        Set<String> exist = new HashSet<>();
        try {
            for (int i = 0; i < nums.length - 2 && nums[i] <=0; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    int sum = nums[i] + nums[j];
                    if (sum > 0) break;
                    int last = -sum;
                    if (map.getOrDefault(last, j) > j) {
                        String hash = hashCode(nums[i], nums[j], last);
                        if (exist.contains(hash)) {
                            continue;
                        }
                        exist.add(hash);
                        result.add(Arrays.asList(nums[i], nums[j], last));
                    }
                }
            }
        } finally {
            System.out.println("map: " + map);
        }
        return result;
    }

    public String hashCode(int a, int b, int c) {
        return a + Integer.toString(b) + c;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        return res;
    }
    void twoSum(int[] nums, int i, List<List<Integer>> res) {
        var seen = new HashSet<Integer>();
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1])
                    ++j;
            }
            System.out.println("Seen: " + nums[j]);
            seen.add(nums[j]);
        }
    }

    @Test
    public void test0() {
        int[] in = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-1, -1, 2));
        expected.add(Arrays.asList(-1, 0, 1));
        List<List<Integer>> result = threeSum(in);
        System.out.println("Result: " + result);
        System.out.println("Expect: " + expected);
        Assert.assertTrue(expected.equals(result));
    }

    @Test
    public void test1() {
        int[] in = {-1, 0, 1, 2, -1, -4, 0, 0};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-1, -1, 2));
        expected.add(Arrays.asList(-1, 0, 1));
        expected.add(Arrays.asList(0, 0, 0));
        List<List<Integer>> result = threeSum(in);
        System.out.println("Result: " + result);
        System.out.println("Expect: " + expected);
        Assert.assertTrue(expected.equals(result));
    }

    @Test
    public void test2() {
        int[] in = {0, 0, 0, 0};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 0, 0));
        List<List<Integer>> result = threeSum(in);
        System.out.println("Result: " + result);
        System.out.println("Expect: " + expected);
        Assert.assertTrue(expected.equals(result));
    }

    @Test
    public void test3() {
        int[] in = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-4, -2, 6));
        expected.add(Arrays.asList(-4, 0, 4));
        expected.add(Arrays.asList(-4, 1, 3));
        expected.add(Arrays.asList(-4, 2, 2));
        expected.add(Arrays.asList(-2, -2, 4));
        expected.add(Arrays.asList(-2, 0, 2));
        List<List<Integer>> result = threeSum(in);
        System.out.println("Result: " + result);
        System.out.println("Expect: " + expected);
        Assert.assertTrue(expected.equals(result));
    }
}
