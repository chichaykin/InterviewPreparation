package leetcode

import org.junit.Test

import org.junit.Assert.assertEquals
import kotlin.collections.LinkedHashMap

/**
 * https://leetcode.com/problems/swap-for-longest-repeated-character-substring/
 */
class SwapForLongestRepeatedCharacterSubstring {

    @Test
    fun test() {
        //        assertEquals(3, maxRepOpt1("ababa"));
        //        assertEquals(6, maxRepOpt1("aaabaaa"));
        //        assertEquals(4, maxRepOpt1("aaabbaaa"));
        //        assertEquals(5, maxRepOpt1("aaaaa"));
        //        assertEquals(1, maxRepOpt1("abcdef"));
        assertEquals(7, maxRepOpt1("aabaaabaaaba").toLong())
    }

    private fun maxRepOpt1(text: String): Int {
        val map = LinkedHashMap<Char, Int>()
        for (key in text) {
            val count = map.getOrDefault(key, 0)
            map[key] = count + 1
        }

        val max = 1
        for (e in map.entries) {
            //max = Math.max(max, map.entrySet())
        }

        return max
    }
}

