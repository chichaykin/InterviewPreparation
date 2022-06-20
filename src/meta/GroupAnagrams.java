package meta;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> hashToWords = new HashMap<>();

        for(String word: strs) {
            char ar[] = word.toCharArray();
            Arrays.sort(ar);
            int code = Arrays.hashCode(ar);
            List<String> list = hashToWords.getOrDefault(code, new ArrayList<>());
            list.add(word);
            hashToWords.putIfAbsent(code, list);
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> group : hashToWords.values()) {
            result.add(group);
        }
        return  result;
    }
}
