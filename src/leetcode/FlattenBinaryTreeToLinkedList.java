package leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/322/
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode parent = null;

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
                node.left = null;
            }
            if (node.right != null) {
                stack.push(node.right);
                node.right = null;
            }
            if (parent != null) {
                TreeNode nextRight = parent.right;
                parent.right = node;
                node.right = nextRight;
            }
            parent = node;
        }
    }

    @Test
    public void test() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
