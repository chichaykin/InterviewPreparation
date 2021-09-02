package leetcode.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

//https://leetcode.com/problems/sum-of-subarray-minimums/
public class SumOfSubarrayMinimums {
    /*
    Input: arr = [3,1,2,4]
    Output: 17
    Explanation:
    Sub arrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
    Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
    Sum is 17.
     */
    public int sumSubarrayMins(int[] A) {
        int len = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[len];
        int[] right = new int[len];
        for(int i = 0; i < A.length; i++) {
            left[i] = i + 1;
            right[i] = len - i;
        }
        // previous less element
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        System.out.println("next less element");
        stack = new Stack<>();
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && A[stack.peek()] > A[i]) {
                //System.out.println(String.format("A[%d]=%d, stack.peek()=%d", i, A[i], stack.peek()));
                right[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        int ans = 0;
        int mod = (int)1e9 + 7;
        for(int i = 0; i < len; i++) {
            System.out.println(String.format("A[%d]=%d, left=%d, right=%d", i, A[i], left[i], right[i]));
            ans = (ans + A[i] * left[i] * right[i]) % mod;
        }
        return ans;
    }

    @Test
    public void test() {
        Assert.assertEquals(17, sumSubarrayMins(new int[]{3,1,2,4}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(444, sumSubarrayMins(new int[]{11,81,94,43,3}));
    }
}
