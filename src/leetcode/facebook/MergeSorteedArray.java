package leetcode.facebook;

import java.util.Arrays;

public class MergeSorteedArray {
    int[] merge(int[] in1, int[] in2) {
        if (in1.length == 0) return in2;
        if (in2.length == 0) return in1;
        int size1 = in1.length, size2 = in2.length;
        int[] result = new int[size1 + size2];
        int i = 0, j = 0, index = 0;
        while (i < size1 && j < size2) {
            if (index - 1 > 0 && result[index-1] == in1[i]) { i++; }
            if (index - 1 > 0 && result[index-1] == in2[j]) { i++; }
            if
        }
        return Arrays.copyOf(result, index);
    }
}
