package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConfusingNumberII {
    int[] rotation = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
    int[] valid = {0, 1, 6, 8, 9};
    long limit;
    private int count;

    public int confusingNumberII(int n) {
        limit = n;
        dfs(0, 0, 1);
        return count;
    }

    private void dfs(long num, long rotatedNum, int base) {
        if (num > limit)
            return;
        System.out.println(String.format("%d %d %d", num, rotatedNum, base));
        if (num != rotatedNum)
            count++;
        for (int d : valid) {
            if (num == 0 && d == 0) continue;
            dfs(num * 10 + d, rotation[d] * base + rotatedNum, base * 10);
        }
    }

    public int _confusingNumberII(int n) {
        int count = 0;
        next:
        for (int i = 6; i <= n; i++) {
            if (isConfusing(i)) count++;
        }
        return count;
    }

    private boolean isConfusing(int i) {
        int d = i, rotated = 0;
        while (d > 0) {
            int r = d % 10;
            if (rotation[r] == -1) return false;
            d /= 10;
            rotated = rotated * 10 + rotation[r];
        }

        return rotated != i;
    }


    @Test
    public void test() {
        assertEquals(6, confusingNumberII(20));
    }

    @Test
    public void test2() {
        assertEquals(19, confusingNumberII(100));
    }
}
