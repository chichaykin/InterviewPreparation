package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Bulb {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }

    @Test
    public void test() {
        assertEquals(1, bulbSwitch(3));
        assertEquals(2, bulbSwitch(5));
        assertEquals(2, bulbSwitch(8));
        assertEquals(3, bulbSwitch(9));
        assertEquals(3, bulbSwitch(15));
    }
}
