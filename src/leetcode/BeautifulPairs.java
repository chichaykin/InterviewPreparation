package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class BeautifulPairs {

    @Test
    public void test() {
        assertEquals(4, beautifulPairs(new int[] {1, 2, 3, 4 }, new int[] {1, 2, 3, 4 }));
    }

    @Test
    public void test2() {
        assertEquals(6, beautifulPairs(new int[] {3, 5, 7, 11, 5, 8}, new int[] {5, 7, 11, 10, 5, 8}));
    }

    @Test
    public void test3() {
        assertEquals(0, beautifulPairs(new int[] {1}, new int[] {1}));
    }

    static int beautifulPairs(int[] A, int[] B) {
        Set<Integer> aset = new HashSet<>();
        Set<Integer> bset = new HashSet<>();
        int size = A.length;
        for(int i=0; i < size; i++) {
            for(int j=0; j < size; j++) {
                if (A[i] == B[j]) {
                    if (!aset.contains(i) && !bset.contains(j)) {
                        aset.add(i); bset.add(j);
                        break;
                    }
                }
            }

        }
        if (size != aset.size())
            return aset.size() + 1;
        else if (size == 1) {
            return 0;
        }
        return aset.size();
    }
}
