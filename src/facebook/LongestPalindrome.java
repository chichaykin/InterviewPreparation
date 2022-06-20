package facebook;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int size = s.length();
        if (size < 2) return s;
        char[] str = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        String result = "";
        for (int i = 0; i < size - 1; i++) {
            builder.append(str[i]);
            int left = i, right = i + 1;
            int lastEqual = left;
            for (; right < size; right++) {
                if (str[left] == str[right]) {
                    builder.append(str[right]);
                    lastEqual = right;
                } else {
                    break;
                }
            }
            if (right < size) {
                if (lastEqual != right) { left = left - 1; }
                for (; left >= 0 && right < size; left--, right++) {
                    if (str[left] == str[right]) {
                        builder.insert(0, str[left]).append(str[right]);
                    } else {
                        break;
                    }
                }
            }

            if (result.length() < builder.length()) result = builder.toString();
            builder.setLength(0);
        }
        return result;
    }

    @Test
    public void test3() {
        assertEquals("tattarrattat", longestPalindrome("tattarrattat"));
    }

    @Test
    public void test2() {
        assertEquals("bb", longestPalindrome("cbbd"));
    }

    @Test
    public void test() {
        assertEquals("bab", longestPalindrome("babad"));
    }
}
