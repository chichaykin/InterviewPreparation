package hackerrank;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class WeightedUniformStrings {

    String[] weightedUniformStrings2(String s, int[] queries) {
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < s.length(); ) {
            int cnt = 0;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
                st.add(cnt * (s.charAt(i) - 'a' + 1));
                i++;
            }
            st.add((cnt + 1) * (s.charAt(i) - 'a' + 1));
            i++;
        }
        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (st.contains(queries[i])) {
                res[i] = "Yes";
            } else {
                res[i] = "No";
            }
        }
        return res;
    }

    String[] weightedUniformStrings(String s, int[] queries) {
        String[] result = new String[queries.length];
        char[] ar = s.toCharArray();
        char prev = 'Z';
        int val = 0;
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            int single = ar[i] - 'a' + 1;
            if (prev == ar[i]) {
                val += single;
            } else {
                val = single;
            }
            prev = ar[i];
            set.add(val);
            System.out.println(val);
        }

        for (int i = 0; i < queries.length; i++) {
            if (set.contains(queries[i])) {
                result[i] = "Yes";
            } else result[i] = "No";
        }
        return result;
    }

    @Test
    public void test2() {
        String input = "aaabbbbcccddd";
        int[] queries = {
                5,
                9,
                7,
                8,
                12,
                5
        };

        String[] expected = {
                "No",
                "Yes",
                "No",
                "Yes",
                "Yes",
                "No"
        };
        String[] result = weightedUniformStrings(input, queries);
        for (int i = 0; i < queries.length; i++) {
            assertEquals("query: " + queries[i], expected[i], result[i]);
        }
    }

    @Test
    public void test() {
        String input = "abccddde";
        int[] queries = {
                6,
                1,
                3,
                12,
                5,
                9,
                10};

        String[] expected = {
                "Yes",
                "Yes",
                "Yes",
                "Yes",
                "Yes",
                "No",
                "No"};
        String[] result = weightedUniformStrings(input, queries);
        for (int i = 0; i < queries.length; i++) {
            assertEquals("query: " + queries[i], expected[i], result[i]);
        }
    }
}
