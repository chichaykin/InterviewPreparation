package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Duplicates {
    public static void removeDuplicates(List<Integer> list) {
    }

    @Test
    public void test() {
        List<Integer> list = new LinkedList<>();
        removeDuplicates(list);
        assertEquals(Arrays.asList('a', 'b', '\0'), list );
    }
}
