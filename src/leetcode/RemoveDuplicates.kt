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
}