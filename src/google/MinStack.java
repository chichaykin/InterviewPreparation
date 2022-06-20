package google;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class MinStack {
    class Node {
        int val;
        int min;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }


    Deque<Node> stack = new ArrayDeque<>(30000);

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {
        Node head = stack.peek();
        int min = (head != null) ? ((head.min < val) ? head.min : val) : val;
        stack.push(new Node(val, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

    @Test
    public void test() {
        push(-2);
        push(0);
        push(-1);
        Assert.assertEquals(-2, getMin());
        Assert.assertEquals(-1, top());
        pop();
        Assert.assertEquals(-2, getMin());

    }
}