import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class WordMachine {
    private static final int MAX_INT = 1048575;

    public int solution(String S) {
        String[] words = S.split(" ");
        Deque<Integer> stack = new ArrayDeque<>();
        for (String word : words) {
            switch (word) {
                case "POP":
                    if (stack.isEmpty()) return -1;
                    stack.pop();
                    continue;
                case "DUP":
                    if (stack.isEmpty()) return -1;
                    stack.push(stack.peek());
                    break;
                case "+":
                    if (stack.size() < 2) return -1;
                    int res = sum(stack.pop(), stack.pop());
                    if (res == -1) return -1;
                    stack.push(res);
                    break;
                case "-":
                    if (stack.size() < 2) return -1;
                    res = sum(stack.pop(), -1 * stack.pop());
                    if (res == -1) return -1;
                    stack.push(res);
                    break;
                default: {
                    int number = tryParseInt(word);
                    if (number < 0 || number > MAX_INT) return -1;
                    stack.push(number);
                }
            }
        }
        return stack.isEmpty() ? -1 : stack.pop();
    }

    private int tryParseInt(String word) {
        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException e) {
            //skip
        }
        return -1;
    }

    private int sum(int pop1, int pop2) {
        int res = pop1 + pop2;
        return res < 0 || res > MAX_INT ? -1 : res;
    }

    @Test
    public void test() {
        Assert.assertEquals(8, solution("4 5 6 - 7 +"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(7, solution("13 DUP 4 POP 5 DUP + DUP + -"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(-1, solution("5 6 + -"));
    }

    @Test
    public void test4() {
        Assert.assertEquals(-1, solution("3 DUP 5 - -"));
    }
}
