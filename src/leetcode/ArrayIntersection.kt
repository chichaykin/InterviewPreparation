package leetcode

class ArrayIntersection {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val map1 = HashMap<Int, Int>();
        val result = ArrayList<Int>()
        for(i in nums1) {
            map1[i] = map1.getOrDefault(i, 0) + 1
        }
        for(i in nums2) {
            var count = map1.getOrDefault(i, 0)
            if (count > 0) {
                result.add(i)
                count--
                map1[i] = count
            }
        }
        return result.toIntArray()
    }
}