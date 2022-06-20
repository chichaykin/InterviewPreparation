package facebook;

import leetcode.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CircularDoublyLinkedList {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        List<Node> list = new ArrayList<>();
        dfs(root, list);
        Node first = list.get(0);
        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                Node prev = list.get(i-1); Node cur = list.get(i);
                prev.right = cur; cur.left = prev;
            }
        }
        Node last = list.get(list.size() - 1);
        first.left = last;
        last.right = first;
        return first;
    }

    private void dfs(Node root, List<Node> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }

    @Test
    public void test() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);

        Node head = treeToDoublyList(root);
        Node node = head;
        do {
            System.out.println(node.val);
            node = node.right;
        } while(node != head);
    }

}
