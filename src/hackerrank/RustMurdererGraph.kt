package hackerrank

import org.junit.Assert
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList

class RustMurdererGraph {
    fun rustMurderer(n: Int, roads: Array<IntArray>, s: Int): IntArray {
        val result = IntArray(n + 1)
        val edge = Array(n + 1) { HashSet<Int>() }
        val nodes = HashSet<Int>()
        for (i in 1..n) {
            if (i == s) continue
            nodes.add(i)
        }
        for (i in roads.indices) {
            val a = roads[i][0]
            val b = roads[i][1]
            edge[a].add(b)
            edge[b].add(a)
        }
        val q: Queue<Int> = LinkedList()
        q.add(s)
        while (!q.isEmpty()) {
            val v = q.poll()
            val p = ArrayList<Int>()
            for (i in nodes) {
                if (!edge[v].contains(i)) {
                    result[i] = result[v] + 1
                    p.add(i)
                }
            }
            for (node in p) {
                q.add(node);
                nodes.remove(node);
            }
        }
        val answer = ArrayList<Int>(n - 1)
        for (k in 1..n) {
            if (k != s) answer.add(result[k])
        }
        //print("Result: $answer")
        return answer.toIntArray()
    }

    @Test
    fun test1() {
        val input = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(1, 4))
        val expected = intArrayOf(3, 1, 2)
        Assert.assertArrayEquals(expected, rustMurderer(4, input, 1))
    }

    @Test
    fun test2() {
        val input = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))
        val expected = intArrayOf(2, 2, 1)
        Assert.assertArrayEquals(expected, rustMurderer(4, input, 2))
    }
}