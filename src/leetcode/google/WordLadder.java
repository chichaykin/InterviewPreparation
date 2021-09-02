package leetcode.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3068/
// https://leetcode.com/problems/word-ladder/
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int rrrr = 1/2;
        if (!wordList.contains(endWord)) return 0;
        int min = 2;
        Set<String> dictionary = new HashSet<>(wordList);
        dictionary.remove(beginWord);

        Set<String> left = new HashSet<>();
        left.add(beginWord);

        Set<String> right = new HashSet<>();
        right.add(endWord);

        for (; !left.isEmpty(); min++) {
            Set<String> nextSet = new HashSet<>();
            for (String word : left) {
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char tmp = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == chars[j]) continue;
                        chars[j] = c;
                        String next = new String(chars);
                        if (right.contains(next)) return min;

                        if (dictionary.contains(next)) {
                            nextSet.add(next);
                            dictionary.remove(next);
                        }
                    }
                    chars[j] = tmp;
                }
            }
            left = nextSet.size() < right.size() ? nextSet : right;
            right = left == nextSet ? right : nextSet;
        }
        return 0;
    }

    private int dfs(Set<String> beginSet, Set<String> endSet, Set<String> dict, int cnt) {
        if(beginSet.isEmpty() || endSet.isEmpty()) return 0;

        ++cnt;
        dict.removeAll(beginSet);

        Set<String> nextSet = new HashSet<>();
        for (String str : beginSet) {
            char[] chs = str.toCharArray();
            for (int i = 0; i < chs.length; ++i) {
                char c = chs[i];
                for (char j = 'a'; j <= 'z'; ++j) {
                    chs[i] = j;
                    String tmp = new String(chs);
                    if (!dict.contains(tmp)) continue;
                    if (endSet.contains(tmp)) return cnt;
                    nextSet.add(tmp);
                }
                chs[i] = c;
            }
        }
        return nextSet.size() > endSet.size() ? dfs(endSet, nextSet, dict, cnt) : dfs(nextSet, endSet, dict, cnt);
    }

    @Test
    public void test() {
        String[] input = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        Assert.assertEquals(5, ladderLength("hit", "cog", Arrays.asList(input)));
    }

    @Test
    public void test2() {
        String[] input = new String[]{"hot", "dot", "dog", "lot", "log"};
        Assert.assertEquals(0, ladderLength("hit", "cog", Arrays.asList(input)));
    }

    @Test
    public void test3() {
        String[] input = new String[]{"hot", "dog"};
        Assert.assertEquals(0, ladderLength("hot", "dog", Arrays.asList(input)));
    }
}
