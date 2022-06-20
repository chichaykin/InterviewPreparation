package microsoft;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class LetterCombinationsPhoneNumber {
    char[][] map = {
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'},
    };
    public List<String> letterCombinations(String digits) {
        return combine(digits, 0, new ArrayList<>());
    }

    private List<String> combine(String digits, int cur, ArrayList<String> in) {
        if (cur >= digits.length()) return in;

        ArrayList<String> result = new ArrayList<>();
        int indx = digits.charAt(cur) - '0';
        int chars = map[indx-1].length;
        if (cur == 0) {
            for(int i=0; i < chars; i++) {
                result.add(Character.toString(map[indx-1][i]));
            }
        } else {
            for(int i=0; i < chars; i++) {
                for(String it : in) {
                    result.add(it + map[indx - 1][i]);
                }
            }
        }
        return combine(digits, cur + 1, result);
    }

    @Test
    public void test() {
        Set<String> ex = new HashSet<>(Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf"));
        Set<String> result = new HashSet<>(letterCombinations("23"));
        assertEquals(ex, result);
    }
}
