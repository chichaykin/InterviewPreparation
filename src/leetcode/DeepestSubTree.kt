package leetcode

import org.junit.Test
import kotlin.test.assertEquals

internal class DeepestSubTree {
    fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
        return subtree(root, 0)?.first
    }

    private fun subtree(root: TreeNode?, i: Int): Pair<TreeNode, Int>? {
        if (root == null) return null

        val curLevel = i + 1
        var left = subtree(root.left, curLevel)
        var right = subtree(root.right, curLevel)

        if (left != null && right != null) {
            if (left.second > right.second) return left
            if (right.second > left.second) return right
            return Pair(root, left.second)
        }
        return left ?: (right ?: Pair(root, i))
    }

    @Test
    fun test() {
        var root = TreeNode(3)
        root.left = TreeNode(5)
        root.left.left = TreeNode(6)
        val expected = TreeNode(2)
        root.left.right = expected
        root.left.right.right = TreeNode(4)
        root.left.right.left = TreeNode(7)
        root.right = TreeNode(1)
        root.right.right = TreeNode(8)
        root.right.left = TreeNode(0)
        assertEquals(expected, subtreeWithAllDeepest(root))
    }
}