package microsoft;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

//https://leetcode.com/explore/interview/card/microsoft/47/sorting-and-searching/257
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A.length <= 1) return A.length;
        int count = 1;
        for(int left=0, right=1; right < A.length; right++) {
            if (A[left] == A[right]) continue;
            A[++left] = A[right];
            count++;
        }
        return count;
    }


    @Test
    public void test() {
        assertEquals(4, removeDuplicates(new int[]{1,1,1,2,2,3,4}));
    }


    @Test
    public void test2() {
        assertEquals(1, removeDuplicates(new int[]{1,1,1,1}));
    }

    @Test
    public void test3() {
        assertEquals(2, removeDuplicates(new int[]{1,1,1,2}));
    }
}
