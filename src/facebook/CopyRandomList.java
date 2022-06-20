package facebook;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int i, Node random) {
        val = i; this.random = random;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        return dfs(head, map);
    }

    private Node dfs(Node original, Map<Node, Node> map) {
        Node newNode = null;
        if (original != null) {
            newNode = map.get(original);
            if (newNode != null) return newNode;
            newNode = new Node(original.val);
            map.put(original, newNode);
            if (original.next != null) {
                newNode.next = dfs(original.next, map);
            }
            if (original.random != null) {
                newNode.random = dfs(original.random, map);
            }
        }
        return newNode;
    }

    @Test
    public void test() {
        Node head = new Node(7);
        head.next = new Node(13, head);
        Node last = new Node(1, head);
        head.next.next = new Node(11, last);
        head.next.next.next = new Node(10,head.next);
        head.next.next.next.next = last;
        Node result = copyRandomList(head);
        while (result != null) {
            System.out.print("[" + result.val + "," + (result.random != null? result.random.val : "null") + "], ");
            result = result.next;
        }
    }
}
