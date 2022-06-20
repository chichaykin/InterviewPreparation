package google;

import java.util.HashMap;
import java.util.Map;

public class StringMaxRemovals {
    Map<Character, Integer> sMap = new HashMap<>();
    Map<Character, Integer> pMap = new HashMap<>();

    public int maximumRemovals(String s, String p, int[] removable) {
        if (s.length() < p.length()) return 0;
        int max = 0;
        int marks[] = new int[s.length()];
        for (char ch : s.toCharArray()) {
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }
        for (char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }
        for (int r = 0; r < removable.length; r++) {
            marks[removable[r]] = 1;
            char c = s.charAt(r);
            sMap.put(c, sMap.get(c) - 1);
            //check is substring
            if (!checksub(s, p, marks, max)) return max;
            max++;
        }
        return max;
    }

    boolean checksub(String s, String p, int[] marks, int max) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen - max < pLen) return false;

        for (Map.Entry<Character, Integer> e : pMap.entrySet()) {
            if (sMap.get(e.getKey()) < e.getValue()) return false;
        }

        int sLeft = 0, pLeft = 0;

        while (sLeft < sLen && pLeft < pLen) {
            if (s.charAt(sLeft) == p.charAt(pLeft) && marks[sLeft] != 1) {
                pLeft++;
            }
            sLeft++;
        }

        return pLeft == pLen;
    }
}
