package amazon;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class maximuQuality {
    long maximumQuality(List<Integer> list, int channels) {
        Collections.sort(list, Collections.reverseOrder());
        double sum = 0;
        while (channels > 1) {
            sum += list.remove(0);
        }

        int middle = list.size() / 2;
        if (list.size() % 2 == 0) {
            sum += (list.get(middle) + list.get(middle - 1)) / 2;
        } else {
            sum += list.get(middle);
        }
        return (long) Math.ceil(sum);
    }

    public static int minMoves(List<Integer> arr) {
        int movesLeft = 0, movesRight = 0;
        int size = arr.size();
        for (int i = 0, last = 0, prev = 0; i < size; i++) {
            if (arr.get(i) == 1) {
                if (last != i) {
                    movesLeft += i - last;
                    if (prev == 1) movesLeft -= 1;
                    last += 1;
                }
            }
            prev = arr.get(i);
        }

        for (int i = size - 1, last = size - 1, prev = 0; i >= 0; i--) {
            if (arr.get(i) == 1) {
                if (last != i) {
                    movesRight += last - i;
                    if (prev == 1) movesRight -= 1;
                    last -= 1;
                }
            }
            prev = arr.get(i);
        }
        System.out.println(String.format("movesLeft %d", movesLeft));
        System.out.println(String.format("movesRight %d", movesRight));
        return Math.min(movesLeft, movesRight);
    }

    @Test
    public void testMinMoves() {
        assertEquals(1, minMoves(Arrays.asList(0, 0, 1, 0)));
    }

    @Test
    public void testMinMoves2() {
        assertEquals(1, minMoves(Arrays.asList(1, 0, 1, 0)));
    }

    @Test
    public void testMinMoves0() {
        assertEquals(0, minMoves(Arrays.asList(1, 1, 1, 0)));
    }

    @Test
    public void testMinMoves00() {
        assertEquals(0, minMoves(Arrays.asList(0, 1, 1, 1)));
    }

    @Test
    public void testMinMoves3() {
        assertEquals(4, minMoves(Arrays.asList(0, 0, 1, 1, 0, 0, 0)));
    }
}
