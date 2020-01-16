package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

public class MinLevelMaxSum {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.left = new TreeNode(7);
        root.left.right =  new TreeNode(-8);
        root.left.left = new TreeNode(7);
        assertEquals(2, maxLevelSum(root));
    }

    int minLevel = 1;
    int max = 1;

    public int maxLevelSum(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root.left != null) list.add(root.left);
        if (root.right != null) list.add(root.right);
        max = root.val;
        minLevel = 1;
        return smallest(list, 2);

    }

    private int smallest(List<TreeNode> list, int level) {
        int sum = 0;
        List<TreeNode> nextLevel = new ArrayList<>();
        for (TreeNode node : list) {
            sum += node.val;
            if (node.left != null) nextLevel.add(node.left);
            if (node.right != null) nextLevel.add(node.right);
        }

        if (sum > max) {
            minLevel = level;
            max = sum;
        }

        if (!nextLevel.isEmpty()) {
            return smallest(nextLevel, level + 1);
        }

        return minLevel;
    }
}
