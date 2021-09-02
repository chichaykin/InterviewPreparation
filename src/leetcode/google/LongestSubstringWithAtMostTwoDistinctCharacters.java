package leetcode.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/featured/card/google/59/array-and-strings/3054/
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    /*
    Input: s = "eceba"
    Output: 3
    Explanation: The substring is "ece" which its length is 3.
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char ar[] = s.toCharArray();
        int left = 0, right = 0, max = 1;
        Map<Character, Integer> map = new HashMap<>();
        while (right < ar.length) {
            int count = map.getOrDefault(ar[right], 0);
            map.put(ar[right], count + 1);
            while (map.size() > 2) {
                char lchar = ar[left];
                count = map.get(lchar) - 1;
                if (count == 0) map.remove(lchar);
                else map.put(lchar, count);
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, lengthOfLongestSubstringTwoDistinct("ec"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, lengthOfLongestSubstringTwoDistinct("e"));
    }

    @Test
    public void test4() {
        Assert.assertEquals(5, lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }
}
