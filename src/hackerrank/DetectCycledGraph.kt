package hackerrank

import Graph
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test
import kotlin.collections.HashSet


class DetectCycledGraph {
    private val greySet = HashSet<Int>()
    private val blackSet = HashSet<Int>()

    fun hasCycledGraph(graph: Graph): Boolean {
        val whiteSet = HashSet<Int>(graph.allVertices)
        greySet.clear()
        blackSet.clear()
        for(v in whiteSet) {
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

        assertTrue(hasCycledGraph(graph))
    }

    @Test
    fun noCycle() {
        val graph = Graph()
        graph.addEdges(4, 1)
        graph.addEdges(4, 5)
        graph.addEdges(1, 2)
        graph.addEdges(5, 6)

        assertFalse(hasCycledGraph(graph))
    }

    @Test
    fun noCycle2() {
        val graph = Graph()
        graph.addEdges(4, 1)
        graph.addEdges(4, 5)
        graph.addEdges(1, 2)
        graph.addEdges(5, 6)
        graph.addEdges(2, 6)

        assertFalse(hasCycledGraph(graph))
    }
}