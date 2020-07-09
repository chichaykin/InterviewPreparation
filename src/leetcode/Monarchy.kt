package leetcode

interface Monarchy {
    fun birth(child: String, parent: String)
    fun death(name: String) // if a person dies, they are removed from monarchy but their children are still considered monarchs
    fun getOrderOfSuccession(): List<String>?
}

private data class Node(val parent: Node?, val name: String, val children: List<Node>)

class MonarchyImpl : Monarchy {
    override fun birth(child: String, parent: String) {

    }

    override fun death(name: String) {

    }

    override fun getOrderOfSuccession(): List<String> {
        return emptyList()
    }
}