package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FractionalToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        long divider = denominator;
        long div = numerator / divider;
        long rem = numerator % divider;
        if (rem == 0) return Long.toString(div);

        divider = Math.abs((long)denominator);
        rem = Math.abs(rem);
        StringBuilder builder = new StringBuilder();
        long sign = ((long)numerator) * denominator;
        if (sign < 0) builder.append("-");
        builder.append(Math.abs(div)).append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (rem != 0) {
            rem *= 10;
            Integer position = map.get(rem);
            if (position != null) {
                builder.insert(position, "(").append(")");
                break;
            }
            div = rem / divider;
            map.put(rem, builder.length());
            builder.append(div);
            rem = rem % divider;
        }

        return builder.toString();
    }

    public String fractionToDecimal2(int numerator, int denominator) {
        System.out.println("Numerator: " + numerator + ", denominator: " + denominator);
        if (numerator == 0) return "0";
        int div = numerator / denominator;
        int rem = numerator % denominator;
        if (rem == 0) return Integer.toString(div);

        StringBuilder builder = new StringBuilder();
        builder.append(div).append(".");
        rem = Math.abs(rem);
        denominator = Math.abs(denominator);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(rem, builder.length());
        System.out.println("rem: " + rem + ", index: " + builder.length());
        while (rem != 0) {
            rem *= 10;
            builder.append(rem / denominator);
            rem = rem % denominator;
            System.out.println("rem: " + rem + ", index: " + builder.length());
            if (map.containsKey(rem)) {
                int index = map.get(rem);
                builder.insert(index, "(");
                builder.append(")");
                break;
            } else {
                map.put(rem, builder.length());
            }
        }
        return builder.toString();
    }

    @Test
    public void simple0() {
        assertEquals("2147483648", fractionToDecimal(
                -2147483648, -1));
    }

    @Test
    public void simple() {
        assertEquals("0.0000000004656612873077392578125", fractionToDecimal(
                -1, -2147483648));
    }

    @Test
    public void periodic() {
        assertEquals("0.(3)", fractionToDecimal(1, 3));
    }

    @Test
    public void periodic2() {
        assertEquals("0.(012)", fractionToDecimal(4, 333));
    }

    @Test
    public void periodic3() {
        assertEquals("0.1(6)", fractionToDecimal(1, 6));
    }

    @Test
    public void test() {
        assertEquals("0.125", fractionToDecimal(1, 8));
        assertEquals("0.5", fractionToDecimal(1, 2));
        assertEquals("0", fractionToDecimal(0, 5));
        assertEquals("2", fractionToDecimal(10, 5));
    }
}
