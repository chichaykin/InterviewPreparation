package amazon

data class Item(val key: Int, val value: Int, var left: Item? = null, var right: Item? = null)

class LRUCache(private val capacity: Int) {
    private var head: Item? = null
    private var tail: Item? = null
    private val map = HashMap<Int, Item>(capacity)

    operator fun get(key: Int): Int {
        val node = map[key] ?: return -1
        if (node != tail) {
            removeFromList(node)
            addToList(node)
        }
        return node.value
    }

    private fun addToList(node: Item) {
        node.left = tail
        node.right = null
        tail?.right = node
        tail = node
        if (head == null) head = node
    }

    private fun removeFromList(node: Item) {
        if (head == node) {
            head = node.right
        }
        if (tail == node) {
            tail = node!!.left
        }
        node!!.left?.right = node.right
        node.right?.left = node.left
    }

    fun put(key: Int, value: Int) {
        val old = map.remove(key)
        if (old != null) {
            removeFromList(old)
        } else if (map.size == capacity) {
            map.remove(head!!.key)
            removeFromList(head!!)
        }
        Item(key, value).apply {
            addToList(this)
            map[key] = this
        }
    }
}