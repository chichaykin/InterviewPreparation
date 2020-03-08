package leetcode

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test
import java.util.*


internal data class ANode(
    var node: TreeNode?,
    var code: Int)

internal class CompleteTree {
    fun isCompleteTree(root: TreeNode): Boolean {
        val bfs: Queue<TreeNode?> = LinkedList()
        bfs.offer(root)
        while (bfs.peek() != null) {
            val node = bfs.poll()
            bfs.offer(node!!.left)
            bfs.offer(node!!.right)
        }
        while (!bfs.isEmpty() && bfs.peek() == null) bfs.poll()
        return bfs.isEmpty()
    }

    fun isCompleteTree2(root: TreeNode): Boolean {
        val q = LinkedList<TreeNode>()
        q.add(root)
        var list = ArrayList<TreeNode>()
        while (q.isNotEmpty()) {
            val node = q.poll()
            if (node.left == null && node.right != null) {
                return false
            }
            list.add(node.left)
            node.left?.apply {
                q.add(this)
            }
            list.add(node.right)
            node.right?.apply {
                q.add(this)
            }
        }
        val index = list.indexOfFirst { false }
        if (index == -1) return true
        for(i in index + 1 until list.size) {
            if (list[i] != null) return false
        }
        return true
    }

    @Test
    fun test() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.left.left = TreeNode(4)
        root.left.right = TreeNode(5)
        root.right = TreeNode(3)
        root.right.right = TreeNode(7)
        assertFalse(isCompleteTree(root))
    }

    @Test
    fun test2() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.left.left = TreeNode(4)
        root.left.right = TreeNode(5)
        root.right = TreeNode(3)
        root.right.left = TreeNode(6)
        assertTrue(isCompleteTree(root))
    }
}