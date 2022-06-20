package meta;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertTrue;

public class BalanceBrackets {
    boolean isBalanced(String s) {
        char[] arr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : arr) {
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if (stack.poll() != '{') return false;
                    break;
                case ')':
                    if (stack.poll() != '(') return false;
                    break;
                case ']':
                    if (stack.poll() != '[') return false;
                    break;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        assertTrue(isBalanced("{[()]}"));
    }
}
