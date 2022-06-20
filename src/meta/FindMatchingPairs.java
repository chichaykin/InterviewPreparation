package meta;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

//https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=559324704673058&ppid=454615229006519&practice_plan=0
//https://leetcode.com/discuss/interview-question/632717/facebook-recruiting-portal-matching-pairs
public class FindMatchingPairs {

    int matchingPairs2(String s, String t) {
        Set<String> mismatchS = new HashSet<>();
        char[] sToChar = s.toCharArray();
        char[] tToChar = t.toCharArray();
        int matching = 0;
        Set<Character> set = new HashSet<>();
        boolean isDuplicated = false;
        for (int i = 0; i < sToChar.length; i++) {
            if (set.contains(sToChar[i])) isDuplicated = true;
            set.add(sToChar[i]);
            if (sToChar[i] != tToChar[i]) {
                mismatchS.add(sToChar[i] + "" + tToChar[i]);
            } else
                matching++;
        }
        for (String mism : mismatchS) {
            String reverse = mism.charAt(1) + "" + mism.charAt(0);
            if (mismatchS.contains(reverse)) {
                return matching + 2;
            }
        }
        if (isDuplicated == false) {
            if (mismatchS.size() <= 1)
                matching--;
            if (mismatchS.size() == 0)
                matching--;
        }
        return matching;
    }

    int matchingPairs(String s, String t) {
        Set<String> unMatched = new HashSet<>();
        Set<Character> matched = new HashSet<>();
        int count = 0;
        boolean isDup = false;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == t.charAt(i)) {
                count++;
                if(matched.contains(s.charAt(i))) {
                    isDup = true;
                }
                matched.add(s.charAt(i));
            } else {
                unMatched.add(s.charAt(i) + "" + t.charAt(i));
            }
        }

        if(count == s.length()) {
            return isDup ? count :  count - 2;
        }

        if(count == s.length() - 1) {
            String onlyUnmatched = (String)unMatched.toArray()[0];
            if(isDup || matched.contains(onlyUnmatched.charAt(0)) || matched.contains(onlyUnmatched.charAt(1)))
                return count;
            return count - 1;
        }

        for(String um:unMatched) {
            if(unMatched.contains(um.charAt(1)+""+um.charAt(0))) {
                return count + 2;
            }
        }

        Set<Character> unMatchedS = new HashSet<>();
        Set<Character> unMatchedT = new HashSet<>();

        for(String um : unMatched) {
            if(unMatchedS.contains(um.charAt(1)) || unMatchedT.contains(um.charAt(0))) {
                return count + 1;
            }
            unMatchedS.add(um.charAt(0));
            unMatchedT.add(um.charAt(1));
        }
        return count;
    }

    @Test
    public void test8() {
        assertEquals(2, matchingPairs("abb", "abx"));
    }

    @Test
    public void test7() {
        assertEquals(3, matchingPairs("aab", "aab"));
    }

    @Test
    public void test6() {
        assertEquals(3, matchingPairs("addooo", "bodkyd"));
    }

    @Test
    public void test5() {
        assertEquals(5, matchingPairs("abcde", "adcbe"));
    }

    @Test
    public void test4() {
        assertEquals(1, matchingPairs("mno", "mno"));
    }

    @Test
    public void test3() {
        assertEquals(2, matchingPairs("ab", "ba"));
    }

    @Test
    public void test1() {
        assertEquals(0, matchingPairs("ab", "ab"));
    }

    @Test
    public void test2() {
        assertEquals(4, matchingPairs("abcd", "adcb"));
    }
}
