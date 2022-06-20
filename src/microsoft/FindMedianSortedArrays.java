package microsoft;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FindMedianSortedArrays {
    int n1, n2, medianIdx;
    boolean even;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) return median(nums2);
        if (nums2.length == 0) return median(nums1);
        n1 = nums1.length;
        n2 = nums2.length;
        medianIdx = (n1 + n2) / 2;
        even = (n1 + n2) % 2 == 0;

        if (nums1[n1 - 1] <= nums2[0]) {
            return median(nums1, nums2);
        } else if (nums1[0] >= nums2[n2 - 1]) {
            return median(nums2, nums1);
        } else {
            return mergeMedian(nums1, nums2);
        }
    }

    // 20 30 40
    //   32, 33
    // av #3
    // -----------------
    // 20 30 40
    //   27, 28
    // av #3
    private double mergeMedian(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (m > n) {
            return mergeMedian(B, A);
        }
        int l = 0, r = m, i = 0, j = 0;
        while (l <= r) {
            i = (l + r) / 2;
            j = (m + n + 1) / 2 - i;
            int maxLeftA = i == 0 ? Integer.MIN_VALUE : A[i - 1];
            int minRightA = i == m ? Integer.MAX_VALUE : A[i];
            int maxLeftB = j == 0 ? Integer.MIN_VALUE : B[j - 1];
            int minRightB = j == n ? Integer.MAX_VALUE : B[j];
            if (minRightA >= maxLeftB && maxLeftA <= minRightB) {
                boolean even = (m + n) % 2 == 0;
                double leftMax = Math.max(maxLeftA, maxLeftB);
                return (even) ? (leftMax + Math.min(minRightA, minRightB)) / 2 : leftMax;
            }
            if (minRightA < maxLeftB) {
                l = i + 1;
            } else {
                r = i - 1;
            }
        }
        throw new IllegalArgumentException();
    }

    private double median(int[] num1, int[] num2) {
        int sum = 0;
        for (int i = even ? 2 : 1; i > 0; i--, medianIdx++) {
            if (medianIdx < n1) sum += num1[medianIdx];
            else sum += num2[medianIdx];
        }
        return sum / (even ? 2 : 1);
    }

    private double median(int[] num) {
        int av = num.length / 2;
        if (num.length % 2 == 0) {
            return (num[av] + num[av - 1]) / 2;
        }
        return num[av];
    }

    @Test
    public void test() {
        assertEquals(2.0, mergeMedian(new int[]{1, 3}, new int[]{2}));
    }

    @Test
    public void test2() {
        assertEquals(2.5, mergeMedian(new int[]{1, 3, 4}, new int[]{2}));
    }

    @Test
    public void test3() {
        assertEquals(2.0, mergeMedian(new int[]{}, new int[]{2}));
    }
}
