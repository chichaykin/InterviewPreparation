package leetcode;

import static java.lang.Integer.max;

public class LongestASequence {
    public int longestArithSeqLength(int[] A) {
        var max = 1;
        for (int i = 0; i < A.length; i++) {
            max = max(max, maxSeq(i, A));
        }
        return max;
    }

    private int maxSeq(int i, int[] a) {
        var result = 1;
        var j = i + 1;
        var size = a.length;
        while (i < size && j < size) {
            var diff = a[j] - a[i];
            var length = 2;
            var el = a[j] + diff;
            for (int p = j + 1; p < size; p++) {
                if (a[p] == el) {
                    el = a[p] + diff;
                    length++;
                }
            }
            result = Math.max(result, length);
            j++;
        }
        return result;
    }
}
