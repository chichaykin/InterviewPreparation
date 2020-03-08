package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, 0, res);
        return res;
    }

    void dfs(TreeNode x, int level, List<Integer> res) {
        if (x == null) return;

        if (res.size() == level) res.add(x.val);

        dfs(x.right, level + 1, res);
        dfs(x.left, level + 1, res);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        Integer[] expected = new Integer[] {1, 2};
        assertArrayEquals(expected, rightSideView(root).toArray(new Integer[0]));
    }
}
