package meta;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/discuss/interview-question/746520/facebook-recruiting-portal-1-billion-users
public class OneBillionUsers {

    int getBillionUsersDay2(float[] growthRates) {
        float[] sumRates = new float[growthRates.length];
        Arrays.fill(sumRates, 1F);
        float sum = 0;
        int days = 0;
        while (sum <= 1000000000) {
            days++;
            sum = 0;
            for (int i = 0; i < growthRates.length; i++) {
                sumRates[i] *= growthRates[i];
                sum += sumRates[i];
            }
        }
        return days;
    }

    public int getBillionUsersDay(float[] growthRates) {
        // Write your code here
        int start = 1;
        int end = 2_000; // considering this to be the upper_limit; can be discussed with the interviewer
        double target = 1_000_000_000;

        while (start < end) {
            double total = 0;
            int mid = start + (end - start) / 2;

            // calculate mid value
            for (float growthRate : growthRates) {
                total += Math.pow(growthRate, mid);
            }

            if (total == target) {
                return mid;
            }
            if (total > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    @Test
    public void test2() {
        assertEquals(79, getBillionUsersDay(new float[]{1.1F, 1.2F, 1.3F}));
    }

    @Test
    public void test1() {
        assertEquals(52, getBillionUsersDay(new float[]{1.5F}));
    }
}
