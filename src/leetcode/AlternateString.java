package leetcode;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class AlternateString {

    static class Pair {
        Pair(char c, int n) {
            this.c = c;
            this.amount = n;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "c=" + c +
                    ", amount=" + amount +
                    '}';
        }

        char c;
        int amount;
    }

    static int alternate(String s) {
        char[] input = s.toCharArray();
        int[] arr = new int[26];
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            arr[input[i] - 'a'] += 1;
            set.add(input[i]);
        }

        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                char c = (char) (i + 'a');
                list.add(new Pair(c, arr[i]));
            }
        }
        Collections.sort(list, (p1, p2) -> p2.amount - p1.amount);
        System.out.println("list: " + list.toString());
        for (int j = 0; j < list.size(); j++) {
            Pair p1 = list.get(j);
            for (int i = j + 1; i < list.size(); i++) {
                Pair p2 = list.get(i);
                if (p1.amount - p2.amount <= 1) {
                    int result = check(s, p1.c, p2.c, set);
                    if (result > 0) return result;
                }
            }
        }
        return 0;
    }

    private static int check(String s, char c1, char c2, Set<Character> set) {
        for (char c : set) {
            if (c != c1 && c != c2) {
                s = s.replace(Character.toString(c), "");
            }
        }

        System.out.println(s);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) return 0;
        }

        System.out.println("Result: " + s);
        return s.length();
    }


    @Test
    public void test() {
        assertEquals(8, alternate("cwomzxmuelmangtosqkgfdqvkzdnxerhravxndvomhbokqmvsfcaddgxgwtpgpqrmeoxvkkjunkbjeyteccpugbkvhljxsshpoymkryydtmfhaogepvbwmypeiqumcibjskmsrpllgbvc"));
//        assertEquals(8, alternate("asdcbsdcagfsdbgdfanfghbsfdab"));
//        assertEquals(5, alternate("beabeefeab"));
    }
}
