package hackerrank

import Graph
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test
import kotlin.collections.HashSet


class DetectCycledGraph {

    fun hasGraphCycles2(graph: Graph): Boolean {
        var parent = HashMap<Int, Int>()
        for (v: Int in graph.allVertices) {
            for(e: Int in graph.adjacent(v)) {
                var pV = find(parent, v)
                var pE = find(parent, e)
                if (pV == pE) return true
                union(parent, pE, pV)
            }
        }
        return false;
    }

    private fun find(parent: HashMap<Int, Int>, v: Int): Int {
        if (parent[v] == null)
            return v
        return find(parent, parent[v]!!)
    }

    private fun union(parent: HashMap<Int, Int>, v1: Int, v2: Int) {
        parent[v1] = v2
    }

    private val greySet = HashSet<Int>()
    private val blackSet = HashSet<Int>()
    fun hasGraphCycles(graph: Graph): Boolean {
        val whiteSet = HashSet<Int>(graph.allVertices)
        greySet.clear()
        blackSet.clear()
        for (v in whiteSet) {
            if (dfs(v, graph)) {
                return true
            }
        }

        return false
    }

    private fun dfs(vertex: Int, graph: Graph): Boolean {
        if (blackSet.contains(vertex)) return false

        if (greySet.contains(vertex)) return true

        greySet.add(vertex)
        for (adjacent in graph.adjacent(vertex)) {
            if (dfs(adjacent, graph)) return true
        }
        greySet.remove(vertex)
        blackSet.add(vertex)
        return false
    }

    @Test
    fun hasCycle() {
        val graph = Graph()
        graph.addEdges(4, 1)
        graph.addEdges(4, 5)
        graph.addEdges(1, 2)
        graph.addEdges(5, 6)
        graph.addEdges(6, 4)

        assertTrue(hasGraphCycles(graph))
    }

    @Test
    fun noCycle() {
        val graph = Graph()
        graph.addEdges(4, 1)
        graph.addEdges(4, 5)
        graph.addEdges(1, 2)
        graph.addEdges(5, 6)

        assertFalse(hasGraphCycles(graph))
    }

    @Test
    fun noCycle2() {
        val graph = Graph()
        graph.addEdges(4, 1)
        graph.addEdges(4, 5)
        graph.addEdges(1, 2)
        graph.addEdges(5, 6)
        graph.addEdges(2, 6)

        assertFalse(hasGraphCycles(graph))
    }
}