package leetcode

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class BSTIterator(root: TreeNode) {
    private val stack = LinkedList<TreeNode>()
    init {
        addStack(root)
    }

    /** @return the next smallest number */
    fun next(): Int {
        val node = stack.pollLast()
        if (node.right != null) addStack(node.right)
        return node.`val`
    }

    private fun addStack(n: TreeNode) {
        var node: TreeNode? = n
        while (node != null) {
            stack.add(node)
            node = node.left
        }
    }

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean {
        return !stack.isEmpty()
    }
}

internal class TestBSF {
    @Test
    fun test() {
        val root = TreeNode(7)
        root.left = TreeNode(3)
        root.right = TreeNode(15)
        root.right.left = TreeNode(9)
        root.right.right = TreeNode(20)
        val iterator = BSTIterator(root)
        assertEquals(3, iterator.next())
        assertEquals(7, iterator.next())
        assertEquals(true, iterator.hasNext())
        assertEquals(9, iterator.next())
        assertEquals(true, iterator.hasNext())
        assertEquals(15, iterator.next())
        assertEquals(true, iterator.hasNext())
        assertEquals(20, iterator.next())
        assertFalse(iterator.hasNext())
    }
}