package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShortestWayToFormString {

    public int shortestWay(String source, String target) {
        char[] cs = source.toCharArray(), ts = target.toCharArray();
        int[][] idx = new int[26][cs.length];
        for (int i = 0; i < cs.length; i++) idx[cs[i] - 'a'][i] = i + 1;
        for (int i = 0; i < 26; i++) {
            for (int j = cs.length - 1, pre = 0; j >= 0; j--) {
                if (idx[i][j] == 0)
                    idx[i][j] = pre;
                else
                    pre = idx[i][j];
            }
        }
        int res = 1, j = 0;
        for (int i = 0; i < ts.length; i++) {
            if (j == cs.length) {
                j = 0;
                res++;
            }
            if (idx[ts[i] - 'a'][0] == 0) return -1;
            j = idx[ts[i] - 'a'][j];
            if (j == 0 ) {
                res++;
                i--;
            }
        }
        return  res;
    }

    @Test
    public void test() {
        assertEquals(2, shortestWay("abc", "abcbc"));
    }

    @Test
    public void test2() {
        assertEquals(-1, shortestWay("abc", "acdbc"));
    }

    @Test
    public void test3() {
        assertEquals(3, shortestWay("aaaaa", "aaaaaaaaaaaaa"));
    }

    @Test
    public void test4() {
        assertEquals(3, shortestWay("xyz", "xzyxz"));
    }
}
