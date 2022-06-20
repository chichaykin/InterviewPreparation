package microsoft;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/compare-version-numbers/
public class CompareVersions {
    public int compareVersion(String version1, String version2) {
        String[] revisions1 = version1.split("\\."), revisions2 = version2.split("\\.");

        int size = Math.max(revisions1.length, revisions2.length);

        for (int i=0; i < size; i++) {
            String v1 = revisions1.length > i ? revisions1[i] : "";
            String v2 = revisions2.length > i ? revisions2[i] : "";
            int res = compare(v1, v2);
            if (res != 0) return res;
        }

        return 0;
    }

    private int compare(String v1, String v2) {
        int i1 = v1.equals("") ? 0: Integer.parseInt(v1);
        int i2 = v2.equals("") ? 0: Integer.parseInt(v2);
        return i1 > i2 ? 1 : (i1 < i2 ? -1 : 0);
    }

    @Test
    public void test() {
        assertEquals(0, compareVersion("001.02", "1.2"));
    }

    @Test
    public void test2() {
        assertEquals(-1, compareVersion("01", "1.1"));
    }

    @Test
    public void test3() {
        assertEquals(1, compareVersion("1.05", "1.1"));
    }
}
