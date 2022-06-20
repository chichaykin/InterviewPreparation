package facebook;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    List<String> list;
    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        bfs(root, "");
        return list;
    }

    private void bfs(TreeNode root, String prefix) {
        if (root == null) return;
        StringBuilder builder = new StringBuilder(prefix);
        if (builder.length() != 0) builder.append("->");
        builder.append(root.val);
        prefix = builder.toString();
        if (root.left == null && root.right == null) {
            list.add(prefix);
            return;
        }
        bfs(root.left, prefix);
        bfs(root.right, prefix);
    }
}
