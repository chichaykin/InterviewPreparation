package meta;

import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;

//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
//Input: s = "lee(t(c)o)de)"
//Output:    "lee(t(c)o)de"
public class MinRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();

        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            char lch = s.charAt(l);
            if (lch == ')') l++;
            else if (lch != '(') {
                left.append(lch);
                l++;
            }

            if (l > r) break;

            char rch = s.charAt(r);
            if (rch == '(') r--;
            else if (rch != ')') {
                right.insert(0, rch);
                r--;
            } else if (lch == '(') {
                left.append(lch);
                l++;
                right.insert(0, rch);
                r--;
            }
        }
        return left.append(right).toString();
    }

    @Test
    public void test() {
        assertEquals("", minRemoveToMakeValid("))((("));
    }

    @Test
    public void test2() {
        assertEquals("lee(t(co)de)", minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    @Test
    public void test3() {
        assertEquals("ab(c)d", minRemoveToMakeValid("a)b(c)d"));
    }

}
