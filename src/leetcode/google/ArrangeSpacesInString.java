package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrangeSpacesInString {
    public String reorderSpaces(String text) {
        int spaces = 0, words = 0;
        boolean isWord = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaces++;
                if (isWord) {
                    isWord = false;
                    words++;
                }
            } else {
                isWord = true;
            }
        }
        if (isWord) words++;

        int insert = spaces / (words - 1);
        StringBuilder builder = new StringBuilder(text.length());
        for (int i = 0, w = words; i < text.length() && w > 0; i++) {
            if (text.charAt(i) != ' ') builder.append(text.charAt(i));
            else if (i > 0 && text.charAt(i - 1) != ' ' && --w > 0) {
                for (int j = 0; j < insert; j++) builder.append(' ');
            }
        }
        int last = spaces % (words - 1);
        for (int j = 0; j < last; j++) builder.append(' ');
        return builder.toString();
    }

    @Test
    public void test() {
        assertEquals("this   is   a   sentence", reorderSpaces("  this   is  a sentence "));
    }
}
