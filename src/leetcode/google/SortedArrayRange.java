package leetcode.google;

import java.util.ArrayList;
import java.util.List;

public class SortedArrayRange {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            add(lower, upper, result);
            return result;
        }

        if (lower < nums[0]) {
            add(lower, nums[0] - 1, result);
        }
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - prev) > 1) {
                add(prev + 1, nums[i] - 1, result);
            }
            prev = nums[i];
        }

        if (prev < upper) {
            add(prev + 1, upper, result);
        }

        return result;
    }

    private void add(int lower, int upper, List<String> result) {
        StringBuilder builder = new StringBuilder();
        builder.append(lower);
        if (lower != upper) builder.append("->").append(upper);
        result.add(builder.toString());
    }
}
