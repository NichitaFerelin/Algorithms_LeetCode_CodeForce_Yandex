package problems.medium

import java.util.*


class LeetCode_1985 {

    fun kthLargestNumber(nums: Array<String>, k: Int): String {
        val minHeap = PriorityQueue(Comparator { o1: String, o2: String ->
            if (o1.length == o2.length) o1.compareTo(o2) else o1.length.compareTo(o2.length)
        })

        for (num in nums) {
            minHeap.offer(num)
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }
        return minHeap.poll()
    }
}