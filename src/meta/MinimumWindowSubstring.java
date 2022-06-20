package meta;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

//https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring {
    public String minWindow(String string, String template) {
        int[] map = new int[128];
        char[] s = string.toCharArray();
        char[] t = template.toCharArray();
        for (char ch : t) {
            map[ch] += 1;
        }
        int begin = 0, end = 0, accumulated = 0, min = Integer.MAX_VALUE, head = 0;
        while (end < s.length) {
            if (map[s[end++]]-- > 0) accumulated++; //in t
            while (accumulated == t.length) { //valid
                if (end - begin < min) min = end - (head = begin);
                if (map[s[begin++]]++ == 0) accumulated--;  //make it invalid
            }
        }
        return min == Integer.MAX_VALUE ? "" : string.substring(head, head + min);
    }

    public String minWindow2(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if (len1 < len2) return "";

        int[] tmap = new int[128];
        for (char ch : t.toCharArray()) {
            tmap[ch] += 1;
        }

        String minWord = "";
        int min = Integer.MAX_VALUE;
        int start = -1, end = 0;
        int accumulated = 0;
        int[] smap = new int[128];
        while (end < len1) {
            char lChar = s.charAt(end);
            int tAmount = tmap[lChar];
            if (tAmount != 0) {
                if (start == -1) start = end;
                int sAmount = smap[lChar] + 1;
                smap[lChar] = sAmount;
                if (sAmount <= tAmount) accumulated++;
                while (t.length() == accumulated) {
                    if (min > end - start + 1) {
                        min = end - start + 1;
                        minWord = s.substring(start, end + 1);
                    }
                    char startChar = s.charAt(start);
                    sAmount = smap[startChar] - 1;
                    if (sAmount >= 0) {
                        smap[startChar] = sAmount;
                        if (sAmount < tmap[startChar]) accumulated--;
                    }
                    start++;
                }
            }
            end++;
        }
        return minWord;
    }

    @Test
    public void test4() {
        assertEquals("a", minWindow("ab", "a"));
    }

    @Test
    public void test3() {
        assertEquals("aa", minWindow("aa", "aa"));
    }

    @Test
    public void test2() {
        assertEquals("b", minWindow("ab", "b"));
    }

    @Test
    public void test1() {
        assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
    }
}
