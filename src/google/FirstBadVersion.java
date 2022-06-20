package google;

import org.junit.Assert;
import org.junit.Test;

public class FirstBadVersion {
        private int bad;

        public boolean isBadVersion(int n) {
            return bad <= n;
        }

        public int firstBadVersion(int n) {
            int lo = 1, hi = n; //4
            int middle = 1;
            while (lo < hi) {
                middle = lo + (hi - lo) / 2; //2
                System.out.println("Middle: " + middle);
                if (isBadVersion(middle)) {
                    hi = middle;
                    if (lo == hi - 1) return hi;
                } else {
                    lo = middle; //2
                }
            }
            return middle;
        }


        @Test
        public void test() {
            bad = 3;
            Assert.assertEquals(3, firstBadVersion(4));
        }
}
