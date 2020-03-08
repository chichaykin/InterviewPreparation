package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AlienDictionary {
    int map[] = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1) return true;

        for (int i=0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i-1], words[i]) > 0) return false;
        }
        return true;
    }

    private int compare(String word1, String word2) {
        int minLength = Math.min(word1.length(), word2.length());
        for(int i=0; i < minLength; i++) {
            int ind1 = map[word1.charAt(i) - 'a'];
            int ind2 = map[word2.charAt(i) - 'a'];
            if (ind1 != ind2) return ind1 - ind2;
        }
        return word1.length() - word2.length();
    }

    @Test
    public void test() {
        assertTrue(isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    @Test
    public void test2() {
        assertFalse(isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
    }

    @Test
    public void test3() {
        assertFalse(isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
