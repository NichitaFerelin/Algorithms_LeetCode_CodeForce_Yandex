package algorithms

object BinarySearch {

    fun search(nums: IntArray, target: Int): Int {
        var leftBorder = 0
        var rightBorder = nums.lastIndex

        while (leftBorder <= rightBorder) {
            val middle = leftBorder + (rightBorder - leftBorder) / 2
            when {
                target == nums[middle] -> return middle
                target > nums[middle] -> leftBorder = middle + 1
                target < nums[middle] -> rightBorder = middle - 1
            }
        }

        return -1
    }
}