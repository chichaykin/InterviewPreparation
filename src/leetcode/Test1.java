package leetcode;

import org.junit.Test;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class Test1 {
    @Test
    public void test() {
        assertEquals(79, marcsCakewalk(new int[]{7, 4, 9, 6}));
    }
    static long marcsCakewalk(int[] calorie) {
        Arrays.sort(calorie);
        long result = 0;
        for(int i=calorie.length-1; i >= 0; i--) {
            int n = calorie.length-i-1;
            result += calorie[i] * Math. pow(2,n);
        }
        return result;
    }

    @Test
    public void test1() {
        assertEquals(7, solve(new int[]{2, 4, 6, 1}));
    }

    static int solve(int[] a) {
        Arrays.sort(a);
        int result = 0;
        for(int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                result++;
                System.out.println(a[i]);
            }
            int val = a[i];
            StringBuilder builder = new StringBuilder("" +  a[i]);
            for(int j=i+1; j < a.length; j++) {
                val += a[j];
                if (val % 2 == 0) {
                    builder.append(a[j]);
                    System.out.println(builder.toString());
                    result++;
                }
                if ((a[j] + a[i]) %2 == 0){
                    System.out.println(a[j] + ", " + a[i]);
                    result++;
                }
            }
        }
        return result;
    }
}
