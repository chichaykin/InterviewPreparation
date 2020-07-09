@file:Suppress("ClassName")

package leetcode

import org.junit.Test
import java.util.HashMap
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * <ref link="https://leetcode.com/problems/partition-equal-subset-sum/"/>
 */
class `Partition Equal Subset Sum` {

    fun canPartition(nums: IntArray): Boolean {
        var sum = 0
        nums.forEach { sum += it }
        if (sum % 2 != 0) return false
        return canPartition(nums, 0, sum / 2, HashMap<String, Boolean>())
    }

    private fun canPartition(nums: IntArray, i: Int, sum: Int, map: HashMap<String, Boolean>): Boolean {
        if (i >= nums.size) return false
        if (sum == 0) return true
        val key = "$i:$sum"
        map[key]?.apply { return this }
        val hasPartition = canPartition(nums, i + 1, sum, map) || canPartition(nums, i + 1, sum - nums[i], map)
        map[key] = hasPartition
        return hasPartition
    }

    @Test
    fun test() {
        assertTrue(canPartition(intArrayOf(1, 5, 11, 5)))
    }

    @Test
    fun test2() {
        assertFalse(canPartition(intArrayOf(1, 2, 3, 5)))
    }
}