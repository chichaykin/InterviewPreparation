package facebook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class MinimumLengthSubstrings {

    int minLengthSubstring(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if (len1 < len2) return -1;
        if (len2 == 0) return 0;

        int[] tArray = new int[26];
        for (char ch : t.toCharArray()) {
            tArray[ch - 'a'] += 1;
        }

        Map<Character, List<Integer>> mapCharToIndex = new LinkedHashMap<>();
        int min = Integer.MAX_VALUE;
        int start = 0, current = 0;
        int accumullated = 0;
        while (current < len1) {
            char lChar = s.charAt(current);
            int letters = tArray[lChar - 'a'];
            if (letters != 0) {
                mapCharToIndex.putIfAbsent(lChar, new ArrayList<>());
                List<Integer> found = mapCharToIndex.get(lChar);
                if (letters > found.size()) {
                    found.add(current);
                    accumullated++;
                } else {
                    found.add(current);
                    if (start == found.remove(0)) {
                        start = found.get(0);
                    }
                }
                if (len2 == accumullated) {
                    min = Math.min(min, current - start + 1);
                }
            }
            current++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    @Test
    public void run() {
        String s_1 = "dcbefebce";
        String t_1 = "fd";
        int expected_1 = 5;
        int output_1 = minLengthSubstring(s_1, t_1);
        assertEquals(expected_1, output_1);

        String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2 = "cbccfafebccdccebdd";
        int expected_2 = -1;
        int output_2 = minLengthSubstring(s_2, t_2);
        assertEquals(expected_2, output_2);
    }
}
