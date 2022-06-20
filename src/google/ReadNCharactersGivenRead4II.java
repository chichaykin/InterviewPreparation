package google;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

//https://leetcode.com/explore/interview/card/google/59/array-and-strings/436/
public class ReadNCharactersGivenRead4II {
    int bufPos = 0;
    char internal[] = new char[4];
    int buffer_size = 0;

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int pos = 0, read = 0;
        while (pos < n) {
            if (buffer_size - bufPos > 0 && bufPos > 0) {
                read = buffer_size - bufPos;
            } else {
                bufPos = 0;
                buffer_size = read = read4(internal);
            }
            int chars = Math.min(read, n - pos);
            int upper = pos + chars;
            for (; pos < upper; pos++, bufPos++) {
                buf[pos] = internal[bufPos];
            }
            if (read == 0 || pos == n) break;
        }
        return pos;
    }

    private char[] fileBuffer;
    private int iFileBuffer;

    private int read4(char[] internal) {
        int upperBound = Math.min(fileBuffer.length - iFileBuffer, 4) + iFileBuffer;
        int i = 0;
        for (; iFileBuffer < upperBound; i++, iFileBuffer++) {
            internal[i] = fileBuffer[iFileBuffer];
        }
        return i;
    }

    @Test
    public void test5() {
        iFileBuffer = 0;
        fileBuffer = "abcde".toCharArray();
        char[] buffer = new char[4];
        assertEquals(4, read(buffer, 4));
        buffer = new char[1];
        assertEquals(1, read(buffer, 1));
        buffer = new char[1];
        assertEquals(0, read(buffer, 1));
    }

    @Test
    public void test() {
        iFileBuffer = 0;
        fileBuffer = "abc".toCharArray();
        char[] buffer = new char[4];
        assertEquals(1, read(buffer, 1));
        assertEquals(2, read(buffer, 2));
        assertEquals(0, read(buffer, 1));
    }

    @Test
    public void test2() {
        iFileBuffer = 0;
        fileBuffer = "ab".toCharArray();
        char[] buffer = new char[1];
        assertEquals(1, read(buffer, 1));
        buffer = new char[2];
        assertEquals(1, read(buffer, 2));
        assertArrayEquals(new char[]{'b', '\0'}, buffer);
    }

    @Test
    public void test3() {
        iFileBuffer = 0;
        fileBuffer = "abc".toCharArray();
        char[] buffer = new char[3];
        assertEquals(3, read(buffer, 4));
        buffer = new char[1];
        assertEquals(0, read(buffer, 1));
        assertArrayEquals(new char[]{'\0'}, buffer);
    }

    @Test
    public void test4() {
        iFileBuffer = 0;
        fileBuffer = "abcd".toCharArray();
        char[] buffer = new char[1];
        assertEquals(1, read(buffer, 1));
        assertArrayEquals(new char[]{'a'}, buffer);
        assertEquals(1, read(buffer, 1));
        assertArrayEquals(new char[]{'b'}, buffer);
        assertEquals(1, read(buffer, 1));
        assertArrayEquals(new char[]{'c'}, buffer);
        assertEquals(1, read(buffer, 2));
        assertArrayEquals(new char[]{'d'}, buffer);
    }
}
