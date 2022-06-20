package facebook

import org.junit.Test
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.min
import kotlin.test.assertEquals

@Suppress("MemberVisibilityCanBePrivate")
class AlienOrder {

    fun alienOrder(words: Array<String>): String {
        val map = HashMap<Char, ArrayList<Char>>()
        val incoming = HashMap<Char, Int>()
        words.forEach {
            it.toCharArray().forEach { char ->
                map.putIfAbsent(char, ArrayList())
                incoming[char] = 0
            }
        }
        for (i in 0 until words.size - 1) {
            val current = words[i]
            val next = words[i + 1]
            if (current.length > next.length && current.startsWith(next)) return ""
            for (j in 0 until min(current.length, next.length)) {
                val c = current[j]
                val n = next[j]
                if (c != n) {
                    map[c]!!.add(n)
                    incoming[n] = incoming[n]!! + 1
                    break
                }
            }
        }

        val queue = LinkedList<Char>()
        incoming.filterValues { it == 0 }.keys.forEach{ queue.add(it)}

        val builder = StringBuilder()
        while(!queue.isEmpty()) {
            val char = queue.remove()
            builder.append(char)
            //if (incoming[char] == 0) incoming.remove(char)
            map[char]!!.forEach {
                val edges = incoming[it]!! - 1
                incoming[it] = edges
                if (edges == 0) queue.add(it)
            }
        }

        return if(builder.length < incoming.size) builder.toString() else ""
    }


    @Test
    fun test() {
        val input = arrayOf("wrt", "wrf", "er", "ett", "rftt")
        assertEquals("wertf", alienOrder(input))
    }

    @Test
    fun duplicates() {
        val input = arrayOf("z", "x", "z")
        assertEquals("", alienOrder(input))
    }

    @Test
    fun test2() {
        val input = arrayOf("ab", "adc")
        assertEquals("abdc", alienOrder(input))
    }

    @Test
    fun test3() {
        val input = arrayOf("aac", "aabb", "aaba")
        assertEquals("cba", alienOrder(input))
    }

    @Test
    fun test4() {
        val input = arrayOf("z", "z")
        assertEquals("z", alienOrder(input))
    }
}