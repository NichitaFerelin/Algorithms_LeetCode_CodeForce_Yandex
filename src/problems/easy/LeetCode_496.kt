package problems.easy

import java.util.*


class LeetCode_496 {

    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val nextGreaterContainer = HashMap<Int, Int>(nums2.size)
        val withoutGreaterStack = Stack<Int>()

        nums2.forEach { number ->
            while (withoutGreaterStack.isNotEmpty() && withoutGreaterStack.peek() < number) {
                nextGreaterContainer[withoutGreaterStack.pop()] = number
            }

            withoutGreaterStack.push(number)
        }

        return IntArray(nums1.size) { index ->
            val numberToFind = nums1[index]
            nextGreaterContainer.getOrDefault(numberToFind, -1)
        }
    }
}