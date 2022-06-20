package google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Strobogrammatic {
    //969 -> 696 No
    //69 -> 69 Yes
    //689 -> 689 Yes
    //6,9,1,0,8
    char[] rotation = {'0', '1', 'N', 'N', 'N', 'N', '9', 'N', '8', '6'};

    public boolean isStrobogrammatic(String num) {
        char[] res = new char[num.length()];
        char[] org = num.toCharArray();
        for (int r = 0, l = org.length - 1; r < l ; r++, l--) {
            int indL = org[l] - '0';
            int indR = org[r] - '0';
            char charL = rotation[indL];
            char charR = rotation[indR];
            if (charL == 'N' || charR == 'N') return false;
            res[r] = charL;
            res[l] = charR;
        }

        return Arrays.equals(res, org);
    }

    @Test
    public void test() {
        Assert.assertTrue(isStrobogrammatic("69"));
    }
}
