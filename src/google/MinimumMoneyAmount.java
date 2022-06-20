package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumMoneyAmount {

    int[][] dp;
    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        return cost(1, n);
    }

    private int cost(int start, int end) {
        if (start >= end) return 0;
        if (dp[start][end] != 0) return dp[start][end];
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int low = cost(start, i - 1), high = cost(i + 1, end);
            int val = Math.max(low, high) + i;
            min = Math.min(min, val);
        }
        System.out.println(String.format("Max: %d, Start: %d, End: %d", min, start, end));
        dp[start][end] = min;
        return min;
    }

    @Test
    public void test1() {
        assertEquals(0, getMoneyAmount(1));
    }

    @Test
    public void test2() {
        assertEquals(1, getMoneyAmount(2));
    }

    @Test
    public void test3() {
        assertEquals(2, getMoneyAmount(3));
    }

    @Test
    public void test4() {
        assertEquals(4, getMoneyAmount(4));
    }

    @Test
    public void test10() {
        assertEquals(16, getMoneyAmount(10));
    }
}
