package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder b = new StringBuilder(s);
        int index = 0;

        while (index < b.length()) {
            char cur = b.charAt(index);
            if (cur == ']') {
                int squareEnd = index, squareStart = squareEnd - 1;
                while (--squareStart >= 0 && b.charAt(squareStart) != '[') ;
                String sub = b.substring(squareStart + 1, squareEnd);
                int startDigit = squareStart - 1;
                while (startDigit - 1 >= 0 && Character.isDigit(b.charAt(startDigit - 1))) startDigit--;
                String num = b.substring(startDigit, squareStart);
                int repeat = Integer.parseInt(num);
                b.replace(startDigit, squareEnd + 1, "");
                index = startDigit + sub.length() * repeat;
                while (repeat-- > 0) b.insert(startDigit, sub);
            } else index++;
        }
        return b.toString();
    }

    @Test
    public void test() {
        assertEquals("aaabcbc", decodeString("3[a]2[bc]"));
    }

    @Test
    public void test2() {
        assertEquals("aaabcbc", decodeString("aaabcbc"));
    }

    @Test
    public void test3() {
        assertEquals("accaccaccmn", decodeString("3[a2[c]]mn"));
    }
}
