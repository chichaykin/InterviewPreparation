package google

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

data class Range(val start: Int, val stop: Int, val priority: Int, var valid: Boolean = true)

internal class ExamRoomSolution(n: Int) {
    private var rightest: Int = n - 1
    private var rangeMap: MutableMap<Int, Range> = HashMap()
    private var sortedSet = PriorityQueue { o1: Range, o2: Range ->
        return@PriorityQueue if (o2.priority != o1.priority) o2.priority - o1.priority
        else o1.start - o2.start
    }

    fun seat(): Int {
        var range: Range? = null
        while (!sortedSet.isEmpty()) {
            range = sortedSet.poll()
            if (range.valid) {
                break
            }
        }
        val nextSeat: Int
        if (range!!.start == 0) {
            nextSeat = 0
            if (range.start != range.stop) updateRanges(range.start + 1, range.stop)
        } else if (range.stop == rightest) {
            nextSeat = rightest
            if (range.start != range.stop) updateRanges(range.start, range.stop - 1)
        } else {
            nextSeat = (range.stop - range.start) / 2 + range.start
            if (nextSeat > range.start) updateRanges(range.start, nextSeat - 1)
            if (nextSeat < range.stop) updateRanges(nextSeat + 1, range.stop)
        }
        rangeMap.remove(nextSeat)
        return nextSeat
    }

    private fun updateRanges(start: Int, stop: Int) {
        val priority = if (start == 0 || stop == rightest) stop - start else (stop - start) / 2
        val range = Range(start, stop, priority)
        if (!sortedSet.add(range)) {
            println("Duplicate $range")
        }
        rangeMap[start] = range
        rangeMap[stop] = range
    }

    fun leave(seat: Int) {
        rangeMap.remove(seat)
        var first = seat
        var last = seat
        val left = seat - 1
        val right = seat + 1
        if (left >= 0 && rangeMap[left] != null) {
            val leftRange = rangeMap.remove(left)
            leftRange!!.valid = false
            first = leftRange.start
        }
        if (right <= rightest && rangeMap[right] != null) {
            val rightRange = rangeMap.remove(right)
            rightRange!!.valid = false
            last = rightRange.stop
        }
        updateRanges(first, last)
    }

    init {
        val range = Range(0, rightest, rightest)
        sortedSet.add(range)
    }
}

class ExamRoom {
    @Test
    fun test() {
        val solution = ExamRoomSolution(10);
        assertEquals(0, solution.seat());
        assertEquals(9, solution.seat());
        assertEquals(4, solution.seat());
        assertEquals(2, solution.seat());
        solution.leave(4)
        assertEquals(5, solution.seat());
    }

    @Test
    fun test2() {
        val solution = ExamRoomSolution(4);
        assertEquals(0, solution.seat());
        assertEquals(3, solution.seat());
        assertEquals(1, solution.seat());
        assertEquals(2, solution.seat());
        solution.leave(1)
        solution.leave(3)
        assertEquals(1, solution.seat());
    }

    @Test
    fun test3() {
        val solution = ExamRoomSolution(10);
        assertEquals(0, solution.seat())
        assertEquals(9, solution.seat())
        assertEquals(4, solution.seat())
        solution.leave(0)
        solution.leave(4)
        assertEquals(0, solution.seat());
        assertEquals(4, solution.seat());
        assertEquals(2, solution.seat());
        assertEquals(6, solution.seat());
        assertEquals(1, solution.seat());
        assertEquals(3, solution.seat());
        assertEquals(5, solution.seat());
        assertEquals(7, solution.seat());
        assertEquals(8, solution.seat());
        solution.leave(0)
    }
}