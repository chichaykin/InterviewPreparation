package meta;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyAtoi {
    public int myAtoi(String s) {
        char[] ar = s.toCharArray();
        int i = 0;
        long result = 0;
        int sign = 1;
        for (; i < ar.length && ar[i] == ' '; i++) ;
        if (i == ar.length) return 0;
        if (ar[i] == '-') {
            sign = -1;
            i++;
        } else if (ar[i] == '+') {
            i++;
        }
        int d = 1;
        for (; i < ar.length && Character.isDigit(ar[i]) && result < Integer.MAX_VALUE; i++) {
            int digit = ar[i] - '0';
            result = result * d + digit;
            if (result >= Integer.MAX_VALUE) return 0;
        }

        result *= sign;

        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) result;
    }

    @Test
    public void test() {
        assertEquals(0, myAtoi(" "));
    }
}
