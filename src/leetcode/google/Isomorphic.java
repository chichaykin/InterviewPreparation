package leetcode.google;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char tChar = t.charAt(i), sChar = s.charAt(i);
            if (map.containsKey(tChar)) {
                if (map.get(tChar) != sChar) return false;
            } else {
                if (!set.add(sChar)) return false;
                map.put(tChar, sChar);
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertEquals(false, isIsomorphic("foo", "bar"));
    }

    @Test
    public void test2() {
        assertEquals(true, isIsomorphic("paper", "title"));
    }
}
