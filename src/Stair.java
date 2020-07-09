import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * You are climbing a stair case. It takes n(positive integer) steps to reach to the top.
 * Each time you can either climb 1 or 2 steps.
 *  In how many distinct ways can you climb to the top?
 *
 */

public class Stair {

    public int up(int stairs) {
        if (stairs == 0) return 0;
        return calc(stairs, 0);
    }

    private int calc(int stairs, int i) {
        if (i == stairs) return 1;
        else if (i > stairs) return 0;

        return calc(stairs, i + 1) + calc(stairs, i + 2);
    }

    @Test
    public void test() {
        assertEquals(2, up(2));
    }

    @Test
    public void test2() {
        assertEquals(3, up(3));
    }

    @Test
    public void test3() {
        assertEquals(5, up(4));
    }
}
