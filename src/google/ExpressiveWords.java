package google;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (fit(s, word)) count++;
        }
        return count;
    }

    private boolean fit(String s, String word) {
        int sInd = 0, wInd = 0;
        while (sInd < s.length() && wInd < word.length()) {
            int wCount = 0, sCount = 0;
            if (word.charAt(wInd) != s.charAt(sInd)) return false;

            char ch = word.charAt(wInd);
            wCount = 1;
            sCount = 1;
            while (++wInd < word.length() && word.charAt(wInd) == ch) wCount++;
            while (++sInd < s.length() && s.charAt(sInd) == ch) sCount++;
            if (sCount < wCount) return false;
            if ((sCount > wCount) && sCount > 1 && sCount < 3) return false;
        }
        return !(sInd < s.length() || wInd < word.length());
    }

    @Test
    public void test222() {
        Set<List> set = new HashSet<>();
        set.add(Arrays.asList(1, 2));
        set.add(Arrays.asList(1, 2));
        assertEquals(1, set.size());
    }

    @Test
    public void test() {
        assertEquals(1, expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
    }

    @Test
    public void test1() {
        assertEquals(3, expressiveWords("zzzzzyyyyy", new String[]{"zzyy", "zy", "zyy"}));
    }

    @Test
    public void test2() {
        assertEquals(0, expressiveWords("abcd", new String[]{"abc"}));
    }

    @Test
    public void test3() {
        assertEquals(0, expressiveWords("aaa", new String[]{"aaaa"}));
    }
}
