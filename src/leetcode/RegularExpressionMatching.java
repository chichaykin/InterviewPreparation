package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/regular-expression-matching/

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    @Test
    public void test5() {
        assertEquals(true, isMatch("aab", "c*a*b"));
    }

    @Test
    public void test4() {
        assertEquals(true, isMatch("ab", ".*"));
    }

    @Test
    public void test3() {
        assertEquals(true, isMatch("aa", "a*"));
    }

    @Test
    public void test2() {
        assertEquals(true, isMatch("aa", "a."));
    }

    @Test
    public void test() {
        assertEquals(false, isMatch("aa", "a"));
    }
}
