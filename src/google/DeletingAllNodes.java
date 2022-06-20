package google;

import leetcode.TreeNode;
import org.junit.Test;

import java.util.*;

public class DeletingAllNodes {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        dfs(root, set, result, true);
        return result;
    }

    private TreeNode dfs(TreeNode node, Set<Integer> deleteSet, List<TreeNode> result, boolean insertNextNode) {
        if (node == null) return null;
        boolean deleteNode = deleteSet.remove(node.val);
        if (!deleteNode && insertNextNode) {
            result.add(node);
        }
        node.left = dfs(node.left, deleteSet, result, deleteNode);
        node.right = dfs(node.right, deleteSet, result, deleteNode);

        return deleteNode ? null : node;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        delNodes(root, new int[]{3,5});
    }
}
