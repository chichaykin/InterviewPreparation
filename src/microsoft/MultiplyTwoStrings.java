package microsoft;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/multiply-strings/
public class MultiplyTwoStrings {
    public String multiply(String num1, String num2) {
        int[] n1 = new int[num1.length()];
        for (int i = 0; i < num1.length(); i++) {
            n1[i] = num1.charAt(i) - '0';
        }

        int[] n2 = new int[num2.length()];
        for (int i = 0; i < num2.length(); i++) {
            n2[i] = num2.charAt(i) - '0';
        }

        int[] result = new int[num1.length() + num2.length()];
        //n2*n1
        for (int i1 = n1.length - 1; i1 >= 0; i1--) {
            for (int i2 = n2.length - 1; i2 >= 0; i2--) {
                int prod = n1[i1] * n2[i2];
                int sum = prod + result[i1 + i2 + 1];
                result[i1 + i2 + 1] = sum % 10;
                result[i1 + i2] += sum / 10;
            }
        }

        StringBuffer buffer = new StringBuffer();
        for (int b : result) {
            if (buffer.length() == 0 && b == 0) continue;
            buffer.append(b);
        }
        return buffer.toString();
    }

    @Test
    public void test() {
        assertEquals("1064", multiply("2", "532"));
    }

    @Test
    public void test2() {
        assertEquals("11704", multiply("22", "532"));
    }

    @Test
    public void test3() {
        assertEquals("1089", multiply("33", "33"));
    }
}
