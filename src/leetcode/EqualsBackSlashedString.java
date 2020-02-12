package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EqualsBackSlashedString {

    public boolean backspaceCompare(String S, String T) {
        return remove(S).equals(remove(T));
    }

    String remove(String s) {
        StringBuilder builder = new StringBuilder(s);
        int i = 0;
        while (i < builder.length()) {
            if (builder.charAt(i) == '#') {
                i = i - 1 >= 0 ? i - 1 : 0;
                builder.delete(i, i==0 ? 1 : i + 2);
            } else {
                i++;
            }
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    @Test
    public void test() {
        assertTrue(backspaceCompare("ab#c", "ad#c"));
    }

    @Test
    public void test2() {
        assertTrue(backspaceCompare("ab##", "c#d#"));
    }

    @Test
    public void test3() {
        assertFalse(backspaceCompare("isfcow#", "isfco#w#"));
    }
}
