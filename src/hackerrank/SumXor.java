package hackerrank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumXor {
    static long sumXor(long n) {
        long num = 0;
        while(n != 0) {
            if (n%2 == 0)
                num++;
            n=n>>1;
        }
        return (long)Math.pow(2,num);
    }

    @Test
    public void test() {
        assertEquals(2, sumXor(2));
        assertEquals(2, sumXor(5));
    }
}
