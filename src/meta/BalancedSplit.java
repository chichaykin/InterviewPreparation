package meta;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BalancedSplit {
    boolean balancedSplitExists(int[] arr) {
        if (arr.length < 2) return false;
        int sum = 0;
        for(int i : arr) sum += i;
        int rightSum = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            rightSum += arr[i];
            sum -= arr[i];
            if (sum < rightSum) break;
            if (sum == rightSum && arr[i] != arr[i-1]) return true;
        }
        return false;
    }
    boolean balancedSplitExists2(int[] arr) {
        if (arr.length < 2) return false;
        Arrays.sort(arr); //N*logN
        return isEquals(arr, 0, arr.length - 1, arr[0], arr[arr.length - 1]);
    }

    private boolean isEquals(int[] arr, int l, int r, int sum1, int sum2) {
        if (arr[l] == arr[r]) return false;
        if (l + 1 == r) return sum1 == sum2;

        if (arr[l] == arr[l + 1])
            return isEquals(arr, l + 1, r, sum1 + arr[l + 1], sum2);
        if (arr[r] == arr[r - 1])
            return isEquals(arr, l, r - 1, sum1, sum2 + arr[r - 1]);

        return isEquals(arr, l + 1, r, sum1 + arr[l + 1], sum2)
                    || isEquals(arr, l, r - 1, sum1, sum2 + arr[r - 1]);
    }

    @Test
    public void test4() {
        assertTrue(balancedSplitExists(new int[]{4, 4, 9, 1}));
    }

    @Test
    public void test3() {
        assertFalse(balancedSplitExists(new int[]{4, 4}));
    }

    @Test
    public void test2() {
        assertFalse(balancedSplitExists(new int[]{3, 6, 3, 4, 4}));
    }

    @Test
    public void test1() {
        assertTrue(balancedSplitExists(new int[]{1, 1, 2}));
    }
}
