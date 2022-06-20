package google;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/explore/interview/card/google/67/sql-2/472/
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String input, int k) {
        StringBuilder builder = new StringBuilder(input.length());
        int chars = 0;
        char[] array = input.toCharArray();
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == '-') continue;
            chars++;
            if (chars > k) {
                builder.insert(0, "-");
                chars = 1;
            }
            builder.insert(0, Character.toUpperCase(array[i]));
        }
        return builder.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("5F3Z-2E9W", licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }

    @Test
    public void test2() {
        Assert.assertEquals("2-5G-3J", licenseKeyFormatting("2-5g-3-J", 2));
    }

    @Test
    public void test3() {
        Assert.assertEquals("24A0-R74K", licenseKeyFormatting("2-4A0r7-4k", 4));
    }
}
