package leetcode

import org.junit.Test
import java.util.*
import kotlin.collections.HashSet
import kotlin.test.assertEquals


class NumberOfConnectedComponents {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        var count = 0
        val visited = HashSet<Int>()
        val map = HashMap<Int, ArrayList<Int>>()
        for (edge in edges) {
            map[edge[0]] = ArrayList()
            map[edge[1]] = ArrayList()
        }
        for (edge in edges) {
            map[edge[0]]!!.add(edge[1])
            map[edge[1]]!!.add(edge[0])
        }
        for (i in 0 until n) {
            if (visited.add(i)) {
                println("Visited: $i")
                count++
                visit(map, visited, i)
            }
        }
        return count
    }

    private fun visit(map: HashMap<Int, ArrayList<Int>>,
                      visited: java.util.HashSet<Int>,
                      i: Int) {
        map[i]!!.apply {
            for(node in this) {
                if (visited.add(node)) {
                    println("Visited: $node")
                    visit(map, visited, node)
                }
            }
        }
    }

    fun countComponents2(n: Int, edges: Array<IntArray>): Int {
        var n = n
        val roots = IntArray(n)
        for (i in 0 until n) roots[i] = i
        for (e in edges) {
            val root1 = find(roots, e[0])
            val root2 = find(roots, e[1])
            if (root1 != root2) {
                roots[root1] = root2 // union
                n--
            }
        }
        return n
    }

    fun find(roots: IntArray, id: Int): Int {
        var id = id
        while (roots[id] != id) {
            roots[id] = roots[roots[id]] // optional: path compression
            id = roots[id]
        }
        return id
    }

    @Test
    fun test() {
        val input = arrayOf(intArrayOf(0, 1),
                intArrayOf(1, 2), intArrayOf(3, 4))
        assertEquals(2, countComponents2(5, input))
    }

    @Test
    fun test2() {
        val input = arrayOf(intArrayOf(1, 0))
        assertEquals(1, countComponents(2, input))
    }

    @Test
    fun test3() {
        val input = arrayOf(intArrayOf(4, 0),
                intArrayOf(3, 1), intArrayOf(2, 3), intArrayOf(1, 2))
        assertEquals(2, countComponents2(5, input))
    }
}