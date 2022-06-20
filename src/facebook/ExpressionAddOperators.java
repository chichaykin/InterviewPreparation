package facebook;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ExpressionAddOperators {
    private List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        bfs(num.toCharArray(), target, 0, new StringBuilder(), 0, 0);
        return result;
    }

    private void bfs(char[] input, int target, int pos, StringBuilder path, long result, long prevArg) {
        if (pos == input.length) {
            if (result == target) this.result.add(path.toString());
            return;
        }

        for(int i = pos; i < input.length; i++) {
            if (pos != i && input[pos] == '0') break;
            long number = Long.parseLong(new String(input, pos, i - pos + 1));
            int length = path.length();
            if (pos == 0) {
                path.append(number);
                bfs(input, target, i + 1, path, number, number);
                path.setLength(length);
            } else {
                path.append("+").append(number);
                bfs(input, target, i + 1, path, result + number, number);
                path.setLength(length);

                path.append("-").append(number);;
                bfs(input, target, i + 1, path, result - number, -number);
                path.setLength(length);

                path.append("*").append(number);;
                bfs(input, target, i + 1, path, result - prevArg + number * prevArg, number * prevArg);
                path.setLength(length);
            }
        }
    }

    @Test
    public void test() {
        Set<String> result = new HashSet<>(addOperators("223", 8));
        Set<String> expected = new HashSet<>(Arrays.asList("2+2*3"));
        assertEquals(expected, result);
    }

    @Test
    public void test2() {
        Set<String> result = new HashSet<>(addOperators("232", 8));
        Set<String> expected = new HashSet<>(Arrays.asList("2*3+2", "2+3*2"));
        assertEquals(expected, result);
    }

    @Test
    public void test3() {
        Set<String> result = new HashSet<>(addOperators("123", 6));
        Set<String> expected = new HashSet<>(Arrays.asList("1+2+3", "1*2*3"));
        assertEquals(expected, result);
    }

    @Test
    public void test4() {
        Set<String> result = new HashSet<>(addOperators("105", 5));
        Set<String> expected = new HashSet<>(Arrays.asList("1*0+5","10-5"));
        assertEquals(expected, result);
    }

    @Test
    public void test5() {
        Set<String> result = new HashSet<>(addOperators("00", 0));
        Set<String> expected = new HashSet<>(Arrays.asList("0*0","0+0", "0-0"));
        assertEquals(expected, result);
    }

    @Test
    public void test6() {
        Set<String> result = new HashSet<>(addOperators("3456237490", 9191));
        Set<String> expected = new HashSet<>(Arrays.asList());
        assertEquals(expected, result);
    }
}
