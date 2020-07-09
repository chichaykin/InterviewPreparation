package leetcode

import org.junit.Test
import java.net.URI
import java.util.*
import kotlin.collections.HashMap
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
/// https://leetcode.com/problems/is-graph-bipartite/submissions/
@Suppress("MemberVisibilityCanBePrivate", "ClassName")
class `Is Graph Bipartite` {
    val colors = HashMap<Int, Boolean>()

    fun isBipartite(graph: Array<IntArray>): Boolean {
        colors.clear()
        for(node in graph.indices) {
            if (!colors.containsKey(node)
                    && isInvalid(node, graph)) {
                return false
            }
        }
        return true
    }

    private fun isInvalid(node: Int, graph: Array<IntArray>): Boolean {
        val stack = ArrayDeque<Int>()
        stack.push(node)
        colors.putIfAbsent(node, true)
        while(!stack.isEmpty()) {
            val current = stack.pop()
            val currentColor = colors[current]!!
            graph[current].forEach {
                if (colors.containsKey(it)) {
                    if (currentColor == colors[it]) return true
                } else {
                    colors[it] = !currentColor
                    stack.push(it)
                }
            }
        }
        return false
    }

    @Test
    fun testSingle() {
        val input = arrayOf(intArrayOf())
        assertTrue(isBipartite(input))
    }

    @Test
    fun test5() {
        val input = arrayOf(intArrayOf(4),intArrayOf(),intArrayOf(4),intArrayOf(4),intArrayOf(0,2,3))
        assertTrue(isBipartite(input))
    }

    @Test
    fun test4() {
        val input = arrayOf(intArrayOf(), intArrayOf(2), intArrayOf(1,3), intArrayOf(2))
        assertTrue(isBipartite(input))
    }

    @Test
    fun test3() {
        val input = arrayOf(intArrayOf(1), intArrayOf(0, 3), intArrayOf(3), intArrayOf(1, 2))
        assertTrue(isBipartite(input))
    }

    @Test
    fun test() {
        val input = arrayOf(intArrayOf(1, 3), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(0, 2))
        assertTrue(isBipartite(input))
    }

    @Test
    fun test2() {
        val input = arrayOf(intArrayOf(1, 2, 3), intArrayOf(0, 2), intArrayOf(0, 1, 3), intArrayOf(0, 2))
        assertFalse(isBipartite(input))
    }

    @Test
    fun host() {
        assertEquals("mcd-gateway.stg-myteksi.com", URI("https://mcd-gateway.stg-myteksi.com/v2/track/").host)
    }
}