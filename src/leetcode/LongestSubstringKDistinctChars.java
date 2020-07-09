package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LongestSubstringKDistinctChars {

    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        int result = 0;
        int i = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            if (map.size() <= k) {
                result = Math.max(result, j - i + 1);
            } else {
                while (map.size() > k) {
                    char l = s.charAt(i);
                    int count = map.get(l);
                    if (count == 1) {
                        map.remove(l);
                    } else {
                        map.put(l, map.get(l) - 1);
                    }
                    i++;
                }
            }

        }

        return result;
    }

    public int lengthOfLongestSubstringKDistinct3(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            Character ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.size() <= k) {
                max = Math.max(max, j - i + 1);
            } else {
                while (map.size() > k) {
                    ch = s.charAt(i);
                    int value = map.get(ch) - 1;
                    if (value == 0) map.remove(ch);
                    else map.put(ch, value);
                    i++;
                }
            }
        }
        return max;
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] ar = s.toCharArray();
        int start = 0, end = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            char c = ar[end];
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() <= k) {
                max = Math.max(max, end - start + 1);
            } else if (map.size() > k) {
                int count = map.get(ar[start]) - 1;
                if (count == 0) map.remove(ar[start]);
                else map.put(ar[start], count);
                start++;
            }
            end++;
        }
        return max;
    }

    @Test
    public void test3() {
        assertEquals(1, lengthOfLongestSubstringKDistinct("a", 2));
    }

    @Test
    public void test2() {
        assertEquals(1, lengthOfLongestSubstringKDistinct("a", 1));
    }

    @Test
    public void test1() {
        assertEquals(3, lengthOfLongestSubstringKDistinct("eceba", 2));
    }

}
