package facebook;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RotationalCipher {
    String rotationalCipher(String input, int rotationFactor) {
        if (input.isEmpty() || rotationFactor == 0) return input;

        StringBuilder builder = new StringBuilder(input.length());
        for(char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                char newChar = (char) (((ch - 'A' + rotationFactor) % 26) + 'A');
                builder.append(newChar);
            } else if (Character.isLowerCase(ch)) {
                char newChar = (char) (((ch - 'a' + rotationFactor) % 26) + 'a');
                builder.append(newChar);
            } else if (Character.isDigit(ch)) {
                int d = (ch - '0') + rotationFactor;
                builder.append(d % 10);
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    @Test
    public void test() {
        assertEquals("Cheud-726?", rotationalCipher("Zebra-493?", 3));
    }

    @Test
    public void test2() {
        assertEquals("nopqrstuvwxyzABCDEFGHIJKLM9012345678",
                rotationalCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39));
    }
}
