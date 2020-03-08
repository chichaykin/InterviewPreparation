package leetcode

class Intersection {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val result = hashSetOf<Int>()
        val nums1set = hashSetOf<Int>()
        for(i in nums1) nums1set.add(i)
        for(i in nums2) {
            if (nums1set.contains(i)) result.add(i)
        }
        return result.toIntArray()
    }
}