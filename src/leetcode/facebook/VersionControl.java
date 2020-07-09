package leetcode.facebook;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int m = l + (r-l)/2;
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    boolean[] versions = new boolean[]{true, true, true, true, true};

    @Test
    public void test5() {
        for (int start = 0; start < 4; start++) {
            for (int i = 0; i < start + 1; i++) {
                versions[i] = false;
            }
            //System.out.println(Arrays.toString(versions));
            assertEquals(Arrays.toString(versions), start + 2, firstBadVersion(5));
        }
    }

    @Test
    public void test() {
        versions = new boolean[]{false, false, true};
        assertEquals(3, firstBadVersion(3));
    }

    private boolean isBadVersion(int i) {
        return versions[i - 1];
    }
}
