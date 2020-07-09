package leetcode.facebook;

import leetcode.TreeNode;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

class Level {
    int val;
    int level;

    public Level(int val, int level) {
        this.val = val;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Level{" +
                "val=" + val +
                ", level=" + level +
                '}';
    }
}

public class BinaryTreeVerticalOrderTraversal {
    int min = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Level>> columnsByLevel = new ArrayList<>();
        dfs(root, columnsByLevel, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Level> columns : columnsByLevel) {
            Collections.sort(columns, Comparator.comparingInt(a -> a.level));
            List<Integer> list = new ArrayList<>();
            columns.forEach(l -> list.add(l.val));
            result.add(list);
        }
        return result;
    }

    private void dfs(TreeNode node, List<List<Level>> result, int column, int level) {
        if (node == null) return;

        dfs(node.left, result, column - 1, level + 1);

        int current = column - min;
        if (current < 0) {
            while(column != min) {
                min--;
                result.add(0, new ArrayList<>());
            }
            current = 0;
        }
        if (current == result.size()) {
            result.add(new ArrayList<>());
        }
        Level levelInfo = new Level(node.val, level);
        result.get(current).add(levelInfo);

        dfs(node.right, result, column + 1, level + 1);
    }

    @Test
    public void test2() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(2));
        expected.add(Arrays.asList(3));
        expected.add(Arrays.asList(1,5,4));
        expected.add(Arrays.asList(6));

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.left.left = new TreeNode(3);
        root.right.left.left.left = new TreeNode(2);
        root.right.left.left.right = new TreeNode(4);

        assertEquals(expected, verticalOrder(root));
    }

    @Test
    public void test() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(4));
        expected.add(Arrays.asList(9,5));
        expected.add(Arrays.asList(3,0,1));
        expected.add(Arrays.asList(8,2));
        expected.add(Arrays.asList(7));

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.left.right.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.left.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        assertEquals(expected, verticalOrder(root));
    }
}
