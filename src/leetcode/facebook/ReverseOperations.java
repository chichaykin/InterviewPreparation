package leetcode.facebook;

import org.junit.Test;

import java.util.Stack;

public class ReverseOperations {
    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    // Add any helper functions you may need here
    // [2,4,3,6] -> [4,2,3,6]

    Node reverse(Node head) {
        Node node = head, prevOdd = head;
        while (node != null && node.data % 2 != 0) {
            prevOdd = node; node = node.next;
        }

        if (head == node) head = null;

        Stack<Node> stack = new Stack<>();
        while (node != null && node.data % 2 == 0) {
            stack.push(node);
            node = node.next;
        }

        // node points to null or next odd element
        Node even = null;
        while (!stack.isEmpty()) {
            if (even == null) {
                even = stack.pop();
                if (head == null) head = even;
                else prevOdd.next = even;
            } else {
                even.next = stack.pop();
                even = even.next;
            }
        }
        if (even != null) even.next = node;

        if (node != null)
            node.next = reverse(node.next);

        return head;
    }

    Node createLinkedList(int[] arr) {
        Node head = null;
        Node tempHead = head;
        for (int v : arr) {
            if (head == null) {
                head = new Node(v);
                tempHead = head;
            } else {
                head.next = new Node(v);
                head = head.next;
            }
        }
        return tempHead;
    }

    @Test
    public void test() {
        int[] arr_2 = {2, 18, 24, 3, 5, 7, 9, 6, 12};
        //int[] expected2 = {24, 18, 2, 3, 5, 7, 9, 12, 6};
        Node head_2 = createLinkedList(arr_2);
        //Node expected_2 = createLinkedList(expected2);
        Node output_2 = reverse(head_2);

    }
}
