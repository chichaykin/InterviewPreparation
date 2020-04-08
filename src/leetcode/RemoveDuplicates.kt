package leetcode

import org.junit.Test
import kotlin.test.assertEquals

class RemoveDuplicates {
    fun removeDuplicates(char: CharArray) {

    }

    @Test
    fun  test() {
        var input = charArrayOf('a', 'a', 'a')
        removeDuplicates(input)
        assertEquals(charArrayOf('a'), input)
    }

    @Test
    fun t() {
        val b = StringBuffer()
        b.append("sdsdsd\nsdsdsdsdsdsdsdsdsdsdsds")
        println(b.take(10))
    }
}