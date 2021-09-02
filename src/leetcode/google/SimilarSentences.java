package leetcode.google;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SimilarSentences {
    public boolean areSentencesSimilar2(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;

        Map<String, Set<String>> map = new HashMap<>(similarPairs.size());
        for (List<String> pair : similarPairs) {
            String key1 = pair.get(0), key2 = pair.get(1);
            if (!map.containsKey(key1)) map.put(key1, new HashSet<>());
            if (!map.containsKey(key2)) map.put(key2, new HashSet<>());
            add(map, key1, key2);
            add(map, key2, key1);
        }

        Set<String> emptySet = new HashSet<>();
        for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];
            if (!word1.equals(word2)
                    && !map.getOrDefault(word1, emptySet).contains(word2)) {
                return false;
            }
        }
        return true;
    }

    private void add(Map<String, Set<String>> map, String key1, String key2) {
        if (!map.get(key1).add(key2)) return;
        List<String> neighbours = new ArrayList<>(map.get(key2));
        for (int i = 0; i < neighbours.size(); i++) {
            String s = neighbours.get(i);
            if (key1.equals(s)) continue;
            add(map, key1, s);
            add(map, s, key1);
        }
    }

    class UF {
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> size = new HashMap<>();

        boolean connected(String w1, String w2) {
            if (parent.isEmpty() || !parent.containsKey(w1) || !parent.containsKey(w2))
                return false;

            return find(w1) == find(w2);
        }

        String find(String w) {
            while (w != parent.get(w)) {
                String p = parent.get(parent.get(w));
                parent.put(w, p);
                w = p;
            }
            return w;
        }

        void union(String w1, String w2) {
            String pW1 = parent.containsKey(w1) ? find(w1): w1;
            String pW2 = parent.containsKey(w2) ? find(w2): w2;
            int w1Size = size.getOrDefault(pW1, 1);
            int w2Size = size.getOrDefault(pW2, 1);

            if (w1Size > w2Size) {
                parent.put(pW2, pW1);
                size.put(pW1, w1Size + w2Size);
            } else {
                parent.put(pW1, pW2);
                parent.putIfAbsent(pW2, pW2);
                size.put(pW2, w1Size + w2Size);
            }
        }
    }

    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        UF uf = new UF();
        for (List<String> pair : similarPairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];
            if (!word1.equals(word2)
                    && !uf.connected(word1, word2)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String[] s1 = {"great", "acting", "skills"};
        String[] s2 = {"fine", "drama", "talent"};
        String[][] dic = {{"great", "good"}, {"fine", "good"}, {"drama", "acting"}, {"skills", "talent"}};
        List<List<String>> list = new ArrayList<>();
        for (String[] strings : dic) list.add(Arrays.asList(strings));
        assertTrue(areSentencesSimilar(s1, s2, list));
    }

    @Test
    public void test2() {
        String[] s1 = {"I", "love", "leetcode"};
        String[] s2 = {"I", "love", "onepiece"};
        String[][] dic = {{"manga", "onepiece"}, {"platform", "anime"}, {"leetcode", "platform"}, {"anime", "manga"}};
        List<List<String>> list = new ArrayList<>();
        for (String[] strings : dic) list.add(Arrays.asList(strings));
        assertTrue(areSentencesSimilar(s1, s2, list));
    }

    @Test
    public void test3() {
        String[] s1 = {"great","acting","skills"};
        String[] s2 = {"fine","drama","talent"};
        String[][] dic = {};
        List<List<String>> list = new ArrayList<>();
        for (String[] strings : dic) list.add(Arrays.asList(strings));
        assertFalse(areSentencesSimilar(s1, s2, list));
    }
}
