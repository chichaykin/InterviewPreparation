package leetcode

import org.junit.Test
import kotlin.test.assertEquals

/**
 * https://leetcode.com/interview/1
 */
@Suppress("MemberVisibilityCanBePrivate", "ClassName", "LocalVariableName", "ReplaceJavaStaticMethodWithKotlinAnalog")
class `dividend and divisor` {

    fun divide(dividend: Int, divisor: Int): Int {
        var sum = 0L
        var quotient = 0L
        val sign = (dividend < 0).xor(divisor < 0)
        val _divisor = Math.abs(divisor.toLong())
        val _dividend = Math.abs(dividend.toLong())
        if (_divisor == 1L) return convertToInt(_dividend, sign)
        sum += _divisor
        while (sum <= _dividend) {
            quotient += 1
            sum += _divisor
        }
        return convertToInt(quotient, sign)
    }

    private fun convertToInt(value: Long, sign: Boolean): Int {
        val res = if (sign) value * -1 else value
        if (res > Int.MAX_VALUE) return Int.MAX_VALUE
        else if (res < Int.MIN_VALUE) return Int.MIN_VALUE
        return res.toInt()
    }

    @Test
    fun test9() {
        assertEquals(2147483647, divide(2147483647, 1))
    }

    @Test
    fun test8() {
        assertEquals(-2147483648, divide(-2147483648, 1))
    }

    @Test
    fun test7() {
        assertEquals(-1, divide(-1, 1))
    }

    @Test
    fun test6() {
        assertEquals(0, divide(-3, 7))
    }

    @Test
    fun test5() {
        assertEquals(2147483647, divide(-2147483648, -1))
    }

    @Test
    fun test4() {
        assertEquals(-2, divide(7, -3))
    }

    @Test
    fun test2() {
        assertEquals(-3, divide(-10, 3))
    }

    @Test
    fun test() {
        assertEquals(3, divide(10, 3))
    }
}