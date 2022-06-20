package facebook;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Strobogrammatic {
    Set<String> set = init();

    public boolean isStrobogrammatic(String num) {
        int size = num.length();
        if (size == 0) return false;
        char[] in = num.toCharArray();

        if (size == 1) {
            return set.contains(num);
        }

        for (int i = 0, j = size - 1; i <= j; i++, j--) {
            if (!set.contains(in[i] + "" + in[j])) return false;
        }
        return true;
    }

    private Set<String> init() {
        Set<String> set = new HashSet<>();
        set.add("0");
        set.add("1");
        set.add("8");
        set.add("69");
        set.add("96");
        set.add("11");
        set.add("00");
        set.add("88");
        return set;
    }

    @Test
    public void testNegative() {
        assertFalse(isStrobogrammatic("2"));
        assertFalse(isStrobogrammatic("961"));
    }

    @Test
    public void testPositive() {
        assertTrue(isStrobogrammatic("1"));
        assertTrue(isStrobogrammatic("986"));
        assertTrue(isStrobogrammatic("96"));
        assertTrue(isStrobogrammatic("69"));
        assertTrue(isStrobogrammatic("88"));
    }
}
