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
}

internal class TickerServiceImpl : TickerService {
    private val history = TreeMap<Long, Double>()
    private var curMinTime: Long = 0

    override fun correctPrice(price: Double, timestamp: Long) {
        val oldPrice = history[timestamp]
        if (oldPrice != null && curMinTime == timestamp && oldPrice < price) {
            // Trace all right values to find real min
            for ((key, value) in history.tailMap(curMinTime, false)) {
                if (value < price) {
                    curMinTime = key
                    break
                }
            }
        }
        history[timestamp] = price
        if (history[curMinTime]!! > price) {
            curMinTime = timestamp
        }
    }

    override fun setCurrentPrice(price: Double, timestamp: Long) {
        if (history.isEmpty()) curMinTime = timestamp
        history[timestamp] = price
        history[curMinTime]?.let {
            if (it > price) curMinTime = timestamp
        }
    }

    override val lastValue: Double
        get() = if (history.isEmpty()) 0.0 else history.lastEntry().value
    override val min: Double
        get() {
            history[curMinTime]?.let {
                return it
            }
            return 0.0
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
        service.setCurrentPrice(8.0, 3)
        assertEquals(8.0, service.min)
        service.correctPrice(10.0, 2)
        assertEquals(8.0, service.min)
        service.correctPrice(7.0, 2)
        assertEquals(7.0, service.min)
        assertEquals(8.0, service.lastValue)
    }
}