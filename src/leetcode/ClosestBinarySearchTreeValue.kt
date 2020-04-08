package leetcode

import junit.framework.TestCase
import org.junit.Test
import kotlin.math.abs

internal class ClosestBinarySearchTreeValue {
    fun closestValue2(root: TreeNode, target: Double): Int {
        return s(root, target, makePair(root.`val`, target)).first
    }

    private fun s(node: TreeNode, target: Double, cur: Pair<Int, Double>): Pair<Int, Double> {
        node.left?.apply {
            if (node.`val` > target)
                s(this, target, makePair(this.`val`, target)).apply {
                    if (this.second < cur.second) return this
                }
        }
        node.right?.apply {
            if (node.`val` < target) {
                s(this, target, makePair(this.`val`, target)).apply {
                    if (this.second < cur.second) return this
                }
            }
        }
        return cur
    }

    private fun makePair(value: Int, target: Double): Pair<Int, Double> {
        return Pair(value, abs(target - value))
    }

    fun closestValue(root: TreeNode, target: Double): Int {
        val a = root.`val`
        val kid = (if (target < a) root.left else root.right) ?: return a
        val b = closestValue(kid, target)
        return if (abs(a - target) < abs(b - target)) a else b
    }

    @Test
    fun test() {
        val root = TreeNode(13)
        root.left = TreeNode(4)
        root.left.right = TreeNode(5)
        root.left.left = TreeNode(1)
        root.left.left.right = TreeNode(2)
        root.left.left.right.right = TreeNode(3)
        root.left.left.left = TreeNode(0)
        TestCase.assertEquals(3, closestValue2(root, 3.14))
    }

    @Test
    fun test22() {

    }
}