package leetcode;

import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
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
        for (int i = calorie.length - 1; i >= 0; i--) {
            int n = calorie.length - i - 1;
            result += calorie[i] * Math.pow(2, n);
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
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                result++;
                System.out.println(a[i]);
            }
            int val = a[i];
            StringBuilder builder = new StringBuilder("" + a[i]);
            for (int j = i + 1; j < a.length; j++) {
                val += a[j];
                if (val % 2 == 0) {
                    builder.append(a[j]);
                    System.out.println(builder.toString());
                    result++;
                }
                if ((a[j] + a[i]) % 2 == 0) {
                    System.out.println(a[j] + ", " + a[i]);
                    result++;
                }
            }
        }
        return result;
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator % denominator == 0) {
            return String.format("%d", numerator / denominator);
        }
        double n = numerator / (double) denominator;
        DecimalFormat format = new DecimalFormat("0.##");
        format.setRoundingMode(RoundingMode.DOWN);
        String res = format.format(n);
        int i = 0;
        while (res.charAt(i++) != '.') ;
        if (i + 1 == res.length()) return res;
        for (int j = i + 1; j < res.length(); j++) {
            if (res.charAt(j - 1) != res.charAt(j - 1))
                return res;
        }
        return new StringBuilder(res.substring(0, i))
                .append("(")
                .append(res.charAt(i))
                .append(")").toString();

    }

    @Test
    public void tetssss() {
        System.out.println(fractionToDecimal(4, 333));
    }


}
