package leetcode.facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMaxProduct {
    int[] findMaxProduct(int[] arr) {
        int[] result = new int[arr.length];
        List<Integer> maxHeap = new ArrayList<>(4);
        for(int i=0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            Collections.sort(maxHeap);
            if (maxHeap.size() < 3) {
                result[i] = -1;
            } else {
                if (maxHeap.size() > 3) maxHeap.remove(0);
                result[i] =  maxHeap.get(0) * maxHeap.get(1) * maxHeap.get(2);
            }
        }
        return result;
    }
}
