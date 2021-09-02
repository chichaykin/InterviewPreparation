package leetcode.google;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class AddBoldtag {
    public String addBoldTag(String s, String[] words) {
        if (words.length == 0) return s;
        Set<Integer> begin = new TreeSet<>();
        Set<Integer> end = new TreeSet<>();
        for (String word : words) {
            for (int i = 0; i < s.length(); i++) {
                int start = s.indexOf(word, i);
                if (start != -1) {
                    begin.add(start);
                    end.add(start + word.length());
                }
            }
        }

        StringBuilder builder = new StringBuilder(s);
        int closed = 0;
        int curIndex = 0;

        Integer[] ends = end.toArray(new Integer[]{});
        Integer[] begins = begin.toArray(new Integer[]{});

        int endInd = end.size() - 1, beginInd = begin.size() - 1;
        while (endInd >= 0 && beginInd >= 0) {
            //System.out.println(String.format("Start: %d, end: %d", begins[beginInd], ends[endInd]));
            if (closed == 0) {
                curIndex = ends[endInd];
                builder.insert(curIndex, "</b>");
                endInd--;
                closed++;
            } else {
                if (ends[endInd] >= begins[beginInd]) {
                    closed++;
                    endInd--;
                } else {
                    closed--;
                    if (closed == 0) {
                        curIndex = begins[beginInd];
                        builder.insert(curIndex, "<b>");
                    }
                    beginInd--;
                }
            }
        }

        if (begins.length > 0) {
            curIndex = begins[0];
            builder.insert(curIndex, "<b>");
        }

        return builder.toString();
    }

    @Test
    public void test() {
        assertEquals("abcxyz123", "<b>abc</b>xyz<b>123</b>", addBoldTag("abcxyz123", new String[]{"abc", "123"}));
    }

    @Test
    public void test2() {
        assertEquals("aaabbcc", "<b>aaabbcc</b>",
                addBoldTag("aaabbcc", new String[]{"aaa","aab","bc","aaabbcc"}));
    }

    @Test
    public void test3() {
        assertEquals("aaabbcc", "aaabbcc",
                addBoldTag("aaabbcc", new String[]{"d"}));
    }
}
