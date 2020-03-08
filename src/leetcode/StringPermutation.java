package leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringPermutation {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int s1map[] = new int[26];
        for (char ch : s1.toCharArray()) {
            s1map[ch - 'a']++;
        }
        int s2map[] = new int[26];
        for (char ch : s2.substring(0, s1.length()).toCharArray()) {
            s2map[ch - 'a']++;
        }
        if (Arrays.equals(s1map, s2map)) return true;
        for (int i = 1; i <= s2.length() - s1.length(); i++) {
            s2map[s2.charAt(i - 1) - 'a']--;
            char last = s2.charAt(i + s1.length() - 1);
            s2map[last - 'a']++;
            if (Arrays.equals(s1map, s2map)) return true;
        }
        return false;
    }

    @Test
    public void test() {
        assertTrue(checkInclusion("ab", "ba"));
    }

    @Test
    public void test1() {
        assertTrue(checkInclusion("ab", "abd"));
    }

    @Test
    public void test2() {
        assertFalse(checkInclusion("ab", "eidboaoo"));
    }

    @Test
    public void test3() {
        assertFalse(checkInclusion("prosperity", "properties"));
    }

}
