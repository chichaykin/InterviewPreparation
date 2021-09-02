package leetcode.google;

import org.junit.Assert;
import org.junit.Test;

public class DominoRotation {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;

        int[] t = new int[7];
        int[] b = new int[7];
        int[] d = new int[7];
        for (int i = 0; i < n; i++) {
            t[tops[i]] = t[tops[i]] + 1;
            b[bottoms[i]] = b[bottoms[i]] + 1;
            if (bottoms[i] == tops[i]) d[tops[i]] = d[tops[i]] + 1;
        }

        int maxInd = 0;
        int max = 0;
        for (int i = 1; i < 7; i++) {
            if (t[i] + b[i] > max) {
                max = t[i] + b[i];
                maxInd = i;
            }
        }

        if (n > (max - d[maxInd])) return -1;

        return t[maxInd] > b[maxInd] ? n - t[maxInd] : n - b[maxInd];
    }

    @Test
    public void test() {
        int[] top = {2, 1, 2, 4, 2, 2};
        int[] bottom = {5, 2, 6, 2, 3, 2};

        Assert.assertEquals(2, minDominoRotations(top, bottom));
    }

    @Test
    public void test2() {
        int[] top =     {3, 5, 1, 2, 3};
        int[] bottom =  {3, 6, 3, 3, 4};

        Assert.assertEquals(-1, minDominoRotations(top, bottom));
    }
}
