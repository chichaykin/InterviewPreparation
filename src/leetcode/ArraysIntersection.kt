package leetcode

import java.util.*
import kotlin.collections.ArrayList

class ArraysIntersection {
    fun arraysIntersection(arr1: IntArray, arr2: IntArray, arr3: IntArray): List<Int> {
        val ar: IntArray = intersection(arr1, arr2)
        return intersection(ar, arr3).toList()
    }

    private fun intersection(arr1: IntArray, arr2: IntArray): IntArray {
        val result = ArrayList<Int>()

        for(i in arr1) {
            for(j in arr2) {
                if ( i < j ) break
                if (i == j) {
                    result.add(i)
                }
            }
        }
        return result.toIntArray()
    }

    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val result = ArrayList<Int>()
        for(i in nums1) {
            for (j in nums2.withIndex()) {
                if (i == j.value) {
                    if (j.index + 1 < nums2.size
                            && nums2[j.index + 1] > j.value) {
                        result.add(nums2[j.index + 1])
                        break
                    }
                    result.add(-1)
                    break
                }
            }
        }
        return result.toIntArray()
    }
}