//package google;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.*;
//
////https://leetcode.com/problems/word-ladder-ii/
//public class WordLadder2 {
//    List<List<String>> result = new ArrayList<>();
//    String endWord;
//
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        Set<String> dictionary = new HashSet<>(wordList);
//        if (!dictionary.contains(endWord)) return result;
//        this.endWord = endWord;
//        dictionary.remove(beginWord);
//        List<String> seq = new ArrayList<>();
//        seq.add(beginWord);
//        bfs(dictionary, seq, new ArrayList<>(seq));
//
//        return result;
//    }
//
//    private void bfs(Set<String> dictionary, List<String> sequence, List<String> levelList) {
//        List<String> newSet = new ArrayList<>();
//        for(String word : levelList) {
//            sequence.add()
//            char[] chars = word.toCharArray();
//            for (int j = 0; j < chars.length; j++) {
//                char tmp = chars[j];
//                for (char c = 'a'; c <= 'z'; c++) {
//                    if (c == chars[j]) continue;
//                    chars[j] = c;
//                    String next = new String(chars);
//                    if (endWord.equals(next)) {
//                        List<String> newList = new ArrayList<>(sequence);
//                        newList.add(next);
//                        result.add(newList);
//                        continue;
//                    }
//
//                    if (dictionary.contains(next)) {
//                        newSet.add(next);
//                        dictionary.remove(next);
//                    }
//                }
//                chars[j] = tmp;
//            }
//        }
//
//        if (newSet.isEmpty()) return;
//        if (!result.isEmpty()) return;
//
//        bfs(dictionary, sequence, newSet);
//    }
//
//    @Test
//    public void test() {
//        List<List<String>> answer = new ArrayList<>();
//        answer.add(Arrays.asList("hit", "hot", "dot", "dog", "cog"));
//        answer.add(Arrays.asList("hit", "hot", "lot", "log", "cog"));
//        String[] input = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
//        Assert.assertEquals(answer, findLadders("hit", "cog", Arrays.asList(input)));
//    }
//
//    @Test
//    public void test2() {
//        String[] input = new String[]{"hot", "dot", "dog", "lot", "log"};
//        Assert.assertEquals(new ArrayList<>(), findLadders("hit", "cog", Arrays.asList(input)));
//    }
//
//    @Test
//    public void test3() {
//        String[] input = new String[]{"hot", "dog"};
//        Assert.assertEquals(new ArrayList<>(), findLadders("hot", "dog", Arrays.asList(input)));
//    }
//}
