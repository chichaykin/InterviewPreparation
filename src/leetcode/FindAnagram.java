package leetcode;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

public class FindAnagram {

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.isEmpty()) return result;
        int size = p.length();
        char[] parr = p.toCharArray();
        Arrays.sort(parr);
        int len = s.length() - size + 1;
        for (int i = 0; i < len; i++) {
            char[] ar = s.substring(i, i + size).toCharArray();
            Arrays.sort(ar);
            if (Arrays.compare(ar, parr) == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int plen = p.length(), slen = s.length();
        if (s.isEmpty() || slen < plen) return result;

        Map<Character, Integer> pmap = new HashMap<>();
        for (int i = 0; i < plen; i++) {
            Character c = p.charAt(i);
            pmap.put(c, pmap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> smap = new HashMap<>();
        for (int i = 0; i < slen; i++) {
            Character c = s.charAt(i);
            smap.put(c, smap.getOrDefault(c, 0) + 1);
            if (i + 1 < plen) continue;

            if (smap.equals(pmap)) {
                result.add(i - plen + 1);
            }

            int start = i - plen + 1;
            if (start >= 0) {
                char prev = s.charAt(start);
                int value = smap.get(prev) - 1;
                if (value == 0) smap.remove(prev);
                else smap.put(prev, value);
            }
        }
        return result;
    }

    @Test
    public void test() {
        Integer expected[] = {0, 6};
        assertArrayEquals(expected, findAnagrams("cbaebabacd", "abc").toArray(new Integer[0]));
    }

    @Test
    public void test2() {
        Integer expected[] = {0, 1, 2};
        assertArrayEquals(expected, findAnagrams("abab", "ab").toArray(new Integer[0]));
    }
}
