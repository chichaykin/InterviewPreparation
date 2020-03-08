/**
 *
 */
data class Graph(var allVertices: HashSet<Int> = HashSet()) {
    private var vertices: HashMap<Int, HashSet<Int>> = HashMap()
    fun addEdges(edge1: Int, edge2: Int) {
        vertices.putIfAbsent(edge1, HashSet())
        vertices[edge1]!!.add(edge2)
        allVertices.add(edge1)
        allVertices.add(edge2)
    }

    fun adjacent(vertex: Int): Set<Int> {
        return vertices[vertex] ?: emptySet()
    }
}