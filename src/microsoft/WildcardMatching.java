package microsoft;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

//hard
//https://leetcode.com/explore/interview/card/microsoft/46/backtracking/155/
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int si = 0, pi = 0, lastStar = -1, lastSymbol = -1;
        while (si < s.length()) {
            if (pi < p.length() && (p.charAt(pi) == '?' || s.charAt(si) == p.charAt(pi))) {
                pi++;
                si++;
            } else if (pi < p.length() && p.charAt(pi) == '*') {
                lastStar = pi;
                lastSymbol = si;
                pi++;
            } else if (lastStar != -1) {
                pi = lastStar + 1;
                lastSymbol++;
                si = lastSymbol;
            } else {
                return false;
            }
        }
        while (pi < p.length() && p.charAt(pi) == '*') pi++;
        return si == s.length() && pi == p.length();
    }

    @Test
    public void test9() {
        assertTrue(isMatch("c", "*?*"));
    }

    @Test
    public void test8() {
        assertTrue(isMatch("aaaa", "***a"));
    }

    @Test
    public void test7() {
        assertTrue(isMatch("abcabczzzde", "*abc???de*"));
    }

    @Test
    public void test6() {
        assertTrue(isMatch("", "****"));
    }

    @Test
    public void test5() {
        assertTrue(isMatch("acdcb", "a*"));
    }

    @Test
    public void test4() {
        assertFalse(isMatch("acdcb", "a*c?b"));
    }

    @Test
    public void test3() {
        assertTrue(isMatch("adceb", "*a*b"));
    }

    @Test
    public void test2() {
        assertFalse(isMatch("cb", "?a"));
    }

    @Test
    public void test1() {
        assertTrue(isMatch("aa", "*"));
    }

    @Test
    public void test() {
        assertFalse(isMatch("aa", "a"));
    }
}
