package google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;

class Solution {
    StringBuilder in = new StringBuilder(100);
    TreeMap<String, Integer> map = new TreeMap<>();

    public Solution(String[] sentences, int[] times) {
        for (int i = 0; i < times.length; i++) {
            map.put(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        if (c == '#') {
            String sentence = in.toString();
            in.setLength(0);
            map.put(sentence, map.getOrDefault(sentence, 0) + 1);
            return result;
        }
        in.append(c);
        String sentence = in.toString();
        map.tailMap(sentence).forEach((key, occurrence) -> {
            if (key.startsWith(sentence)) result.add(key);
        });

        return result.stream().sorted((o1, o2) -> {
            int rank1 = map.get(o1), rank2 = map.get(o2);
            if (rank1 == rank2) return o1.compareTo(o2);
            else return rank2 - rank1;
        }).limit(3).collect(Collectors.toList());
    }
}

public class AutocompleteSystem {
    @Test
    public void test() {
        String[] in = {"i love you", "island", "iroman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        Solution s = new Solution(in, times);
        assertArrayEquals(new String[]{"i love you", "island", "i love leetcode"}, s.input('i').toArray(new String[0]));
        assertArrayEquals(new String[]{"i love you", "i love leetcode"}, s.input(' ').toArray(new String[0]));
        assertArrayEquals(new String[]{}, s.input('a').toArray(new String[0]));
        assertArrayEquals(new String[]{}, s.input('#').toArray(new String[0]));
    }

}
