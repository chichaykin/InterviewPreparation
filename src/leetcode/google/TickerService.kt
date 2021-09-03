package leetcode.google

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

/**
 * It was asked on Google's onsite interview
 */
internal interface TickerService {
    fun correctPrice(price: Double, timestamp: Long)
    fun setCurrentPrice(price: Double, timestamp: Long)
    val lastValue: Double
    val min: Double
    val max: Double
}

/**
 * Time complexity for correction and adding new values: O(log N)
 * Space complexity: O(N)
 */
internal class TickerServiceImpl : TickerService {
    private val history = HashMap<Long, Double>()
    private val minHeap = PriorityQueue<Double>()
    private var lastValueTime = Long.MIN_VALUE

    /**
     * Time complexity: O(log N)
     */
    override fun correctPrice(newPrice: Double, timestamp: Long) {
        history[timestamp]?.let { oldPrice ->
            minHeap.remove(oldPrice) //O(log N)
        }
        history[timestamp] = newPrice
        minHeap.add(newPrice) //O(log N)
    }

    /**
     * Time complexity: O(log N)
     */
    override fun setCurrentPrice(price: Double, timestamp: Long) {
        history[timestamp] = price
        minHeap.add(price)
        lastValueTime = timestamp
    }

    override val lastValue: Double
        get() {
            return history[lastValueTime] ?: Double.MIN_VALUE
        }

    override val min: Double
        get() {
            return if (minHeap.isNotEmpty()) minHeap.first() else Double.MIN_VALUE
        }

    override val max: Double
        get() {
            return if (minHeap.isNotEmpty()) minHeap.last() else Double.MIN_VALUE
        }
}

class TickerServiceImplTest {
    @Test
    fun test() {
        val service = TickerServiceImpl()
        service.setCurrentPrice(9.0, 1)
        assertEquals(9.0, service.min)

        service.setCurrentPrice(8.0, 2)
        assertEquals(8.0, service.min)

        service.setCurrentPrice(7.0, 3)
        assertEquals(7.0, service.min)

        service.correctPrice(10.0, 3)
        assertEquals(8.0, service.min)

        service.correctPrice(7.0, 2)
        assertEquals(7.0, service.min)
        assertEquals(10.0, service.lastValue)
    }
}