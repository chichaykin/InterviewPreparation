package leetcode

internal class LowestCommonAncestorOfDeepestLeave {

    fun lcaDeepestLeaves2(root: TreeNode): TreeNode? {
        return lca2(root, 0)?.first
    }

    private fun lca2(node: TreeNode, level: Int): Pair<TreeNode, Int>? {
        if (node == null) return null

        val pLeft = lca2(node.left, level + 1)
        val pRight = lca2(node.right, level + 1)

        when {
            pLeft != null -> {
                if (pRight != null) {
                    when {
                        pRight.second > pLeft.second -> return Pair(pRight.first, pRight.second)
                        pRight.second < pLeft.second -> return Pair(pLeft.first, pLeft.second)
                    }
                } else {
                    return Pair(pLeft.first, pLeft.second)
                }
            }
            else -> {
                return pRight ?: Pair(node, level)
            }
        }
        return Pair(node, level)
    }

    var lcaNode: TreeNode? = null
    var maxDepth = 0
    fun lcaDeepestLeaves(root: TreeNode): TreeNode? {
        lca(root, 0)
        return lcaNode
    }

    private fun lca(r: TreeNode, d: Int): Int {
        var left = 0
        var right = 0
        if (r.left != null) {
            left = lca(r.left, d + 1)
        }
        if (r.right != null) {
            right = lca(r.right, d + 1)
        }
        if (left == right && right >= maxDepth) {
            lcaNode = r
            maxDepth = right
        } else if (left > maxDepth) {
            maxDepth = left
            lcaNode = r.left
        } else if (right > maxDepth) {
            maxDepth = right
            lcaNode = r.right
        }
        return if (r.left == null && r.right == null) d else Math.max(left, right)
    }
}