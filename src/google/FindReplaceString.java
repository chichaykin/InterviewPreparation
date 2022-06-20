package google;

import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class FindReplaceString {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i], i);
        }

        StringBuilder builder = new StringBuilder(s);
        map.descendingMap().forEach((index, oldIndex) -> {
            if (s.indexOf(sources[oldIndex], index) == index) {
                builder.replace(index, index + sources[oldIndex].length(), targets[oldIndex]);
            }
        });

        return builder.toString();
    }

    @Test
    public void test() {
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"a", "cd"}, targets = {"eee", "ffff"};
        assertEquals(s,"eeebffff", findReplaceString(s, indices, sources, targets));
    }
}
