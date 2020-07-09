package leetcode

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

class LRUCache(private val capacity: Int) {
    private val map = object : LinkedHashMap<Int, Int>(capacity) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?): Boolean {
            return size > capacity
        }
    }

    fun get(key: Int): Int {
        map[key]?.apply {
            return this
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        map[key] = value
    }
}

class LRUTest {
    @Test
    fun test() {
        val cache = LRUCache(2)
        assertEquals(-1, cache.get(1))
        cache.put(1,1)
        cache.put(2,2)
        cache.put(1,5)
        assertEquals(2, cache.get(2))
        assertEquals(5, cache.get(1))
    }
}

