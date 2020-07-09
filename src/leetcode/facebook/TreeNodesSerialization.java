package leetcode.facebook;

import leetcode.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class TreeNodesSerialization {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            builder.append(node != null ? node.val : "null");
            builder.append(";");
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] nodes = data.split(";");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            String value = nodes[i++];
            if (!value.equals("null")) {
                node.left = new TreeNode(Integer.parseInt(value));
                queue.add(node.left);
            }
            value = nodes[i++];
            if (!value.equals("null")) {
                node.right = new TreeNode(Integer.parseInt(value));
                queue.add(node.right);
            }
        }
        return root;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        //assertEquals("1;2;3;null;null;4;5", serialize(root));
        String value = serialize(root);
        assertEquals(root, deserialize(value));
    }
}
