package leetcode

import org.junit.Test
import kotlin.math.max
import kotlin.test.assertEquals

class LongestArithmeticSequence {
    fun longestArithSeqLength(A: IntArray): Int {
        var max = 1
        for (i in A.indices) {
            max = max(max, maxSeq(i, A))
        }
        return max
    }

    private fun maxSeq(i: Int, a: IntArray): Int {
        var result = 1
        var j = i + 1
        while (i < a.size && j < a.size) {
            val diff = a[j] - a[i]
            var length = 2
            var el = a[j] + diff
            for(p in j + 1 until a.size) {
                if (a[p] == el) {
                    println("${a[i]}, ${a[j]}, ${a[p]} ")
                    el = a[p] + diff
                    length++
                }
            }
            result = max(result, length)
            j++
        }
        return result
    }

    @Test
    fun test() {
        assertEquals(3, longestArithSeqLength(intArrayOf(9,4,7,2,10)))
    }

    @Test
    fun test2() {
        assertEquals(4, longestArithSeqLength(intArrayOf(20,1,15,3,10,5,8)))
    }

    @Test
    fun test3() {
        assertEquals(2, longestArithSeqLength(intArrayOf(24,13,1,100,0,94,3,0,3)))
    }

    @Test
    fun test4() {
        assertEquals(2, longestArithSeqLength(intArrayOf(0,8,45,88,48,68,28,55,17,24)))
    }
}