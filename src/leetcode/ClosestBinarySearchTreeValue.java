package leetcode;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        TreeNode node = root;
        double diff = Math.abs(root.val - target);
        while(true) {
            if (node.val > target) {
                if (node.left == null) return node.val;
                double leftDiff = Math.abs(node.left.val - target);
                if (leftDiff > diff) return node.val;
                else {
                    node = node.left;
                    diff = leftDiff;
                }
            } else {
                if (node.right == null) return node.val;
                double rightDiff = Math.abs(node.right.val - target);
                if (rightDiff > diff) return node.val;
                else {
                    node = node.right;
                    diff = rightDiff;
                }
            }
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(13);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(2);
        root.left.left.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(0);

        assertEquals(3, closestValue(root, 3.14));

    }
}
