package leetcode.google;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class hasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i : deck) count.put(i, count.getOrDefault(i, 0) + 1);
        for (int i : count.values()) res = gcd(i, res);
        return res > 1;
    }

    public int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

    @Test
    public void testGCD() {
        System.out.println(gcd(40,30));
    }

    @Test
    public void test0() {
        int[] in = {1, 1, 1, 2, 2, 2, 3, 3};
        assertEquals(false, hasGroupsSizeX(in));
    }

    @Test
    public void test() {
        int[] in = {0, 0, 0, 1, 1, 1, 2, 2, 2};
        assertEquals(true, hasGroupsSizeX(in));
    }

    @Test
    public void test1() {
        int[] in = {1, 2, 3, 4, 4, 3, 2, 1};
        assertEquals(true, hasGroupsSizeX(in));
    }

    @Test
    public void test2() {
        int[] in = {1, 1, 1, 2, 2, 2, 3, 3};
        assertEquals(false, hasGroupsSizeX(in));
    }

    @Test
    public void test3() {
        int[] in = {1};
        assertEquals(false, hasGroupsSizeX(in));
    }

    @Test
    public void test4() {
        int[] in = {1, 1};
        assertEquals(true, hasGroupsSizeX(in));
    }

    @Test
    public void test5() {
        int[] in = {1, 1, 2, 2, 2, 2};
        assertEquals(true, hasGroupsSizeX(in));
    }

    @Test
    public void test6() {
        int[] in = {0, 0, 0, 1, 1, 1, 2, 2, 2};
        assertEquals(true, hasGroupsSizeX(in));
    }

    @Test
    public void test7() {
        int[] in = {1, 1, 1, 2, 2, 2, 3, 3};
        assertEquals(false, hasGroupsSizeX(in));
    }

    @Test
    public void test8() {
        int[] in = {0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3};
        assertEquals(true, hasGroupsSizeX(in));
    }
}
