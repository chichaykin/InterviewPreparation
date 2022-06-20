package facebook;

import leetcode.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;


public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
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
    public void test4() {
        Node root = new Node(4);

        int[] result = formList(treeToDoublyList(root));
        int expected[] = {4};
        assertArrayEquals(expected, result);
    }

    @Test
    public void test3() {
        Node root = new Node(27);
        root.right = new Node(55);
        root.right.right = new Node(58);
        root.right.right.right = new Node(59);
        root.right.right.right.right = new Node(68);
        root.left = new Node(-99);
        root.left.right = new Node(-34);
        root.left.right.right = new Node(-8);
        root.left.right.right.right = new Node(8);

        int[] result = formList(treeToDoublyList(root));
        int expected[] = {-99, -34, -8, 8, 27, 55, 58, 59, 68};
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {
        Node root = new Node(-1);
        root.right = new Node(1);
        root.right.right = new Node(9);
        int[] result = formList(treeToDoublyList(root));
        int expected[] = {-1, 1, 9};
        assertArrayEquals(expected, result);
    }

    @Test
    public void test() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.right = new Node(3);
        root.left.left = new Node(1);
        root.right = new Node(5);
        int[] result = formList(treeToDoublyList(root));
        int expected[] = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, result);
    }

    private int[] formList(Node node) {
        List<Integer> list = new ArrayList<>();
        Node tail = node;
        do {
            list.add(node.val);
            node = node.right;
        } while (node != tail);
        return list.stream().mapToInt(i -> i).toArray();
    }
}
