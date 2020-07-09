package leetcode.facebook;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class LongestString {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        Set<Character> set = new HashSet<>(s.length());
        char[] ar = s.toCharArray();
        int r = 0, l=0, max = 1;
        while (r < ar.length && l <= r) {
            char ch = ar[r];
            if (set.contains(ch)) {
                set.remove(ar[l++]);
            } else {
                set.add(ch);
                max = Math.max(set.size(), max);
                r++;
            }
        }
        return Math.max(max, set.size());
    }

    @Test
    public void test0() {
        assertEquals(3, lengthOfLongestSubstring("dvdf"));
    }

    @Test
    public void test() {
        assertEquals(3, lengthOfLongestSubstring("ababc"));
    }

    @Test
    public void test2() {
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void test3() {
        assertEquals(1, lengthOfLongestSubstring("bbbb"));
    }

    @Test
    public void test4() {
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }

}
