package leetcode.google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArrayForm {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = num.length - 1; i >= 0; i--) {
            int current = num[i] + k;
            result.add(0, current % 10);
            k = current / 10;
        }

        while (k != 0) {
            result.add(0, k % 10);
            k = k / 10;
        }

        return result;
    }

    @Test
    public void test() {
        int[] num = {1, 2, 0, 0};
        assertEquals(Arrays.asList(1, 2, 3, 4), addToArrayForm(num, 34));
    }

    @Test
    public void test2() {
        int[] num = {2, 7, 4};
        assertEquals(Arrays.asList(4,5,5), addToArrayForm(num, 181));
    }

    @Test
    public void test3() {
        int[] num = {2, 1, 5};
        assertEquals(Arrays.asList(1,0,2,1), addToArrayForm(num, 806));
    }

    @Test
    public void test4() {
        int[] num = {9,9,9,9,9,9,9,9,9,9};
        assertEquals(Arrays.asList(1,0,0,0,0,0,0,0,0,0,0), addToArrayForm(num, 1));
    }
}
