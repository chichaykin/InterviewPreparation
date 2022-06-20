package microsoft;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

//https://leetcode.com/problems/excel-sheet-column-title/
public class ConvertToTitleExcel {
    public String convertToTitle(int columnNumber) {
        StringBuffer buffer = new StringBuffer();
        while(columnNumber > 0) {
            columnNumber--;
            int res = columnNumber % 26;
            char s = (char)('A' + res);
            buffer.append(s);
            columnNumber /= 26;
        }
        return buffer.reverse().toString();
    }

    @Test
    public void test0() {
        assertEquals("AB", convertToTitle(28));
    }

    @Test
    public void test() {
        assertEquals("AA", convertToTitle(27));
    }
}
