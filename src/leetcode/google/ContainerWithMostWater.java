package leetcode.google;

import org.junit.Assert;
import org.junit.Test;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxSquare = 0;
        int i = 0, j = height.length - 1;
        while (i != j) {
            int h = Math.min(height[i], height[j]);
            int square = h * (j - i);
            System.out.println("Square: " + square + ", i: " + i + ", j: " + j);
            maxSquare = Math.max(maxSquare, square);
            if (height[i] < height[j]) i++;
            else j--;
        }
        return maxSquare;
    }

    @Test
    public void test00() {
        Assert.assertEquals(17, maxArea(new int[]{2,3,4,5,18,17,6}));
    }

    @Test
    public void test0() {
        Assert.assertEquals(2, maxArea(new int[]{10, 1, 1}));
    }

    @Test
    public void test() {
        Assert.assertEquals(1, maxArea(new int[]{1, 1}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, maxArea(new int[]{1, 1, 2}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(16, maxArea(new int[]{4, 3, 2, 1, 4}));
    }
}
