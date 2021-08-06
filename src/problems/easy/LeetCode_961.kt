package problems.easy

class LeetCode_961 {
    fun repeatedNTimes(nums: IntArray): Int {
        val repeatTimesTarget = nums.size / 2
        val repeatsContainer = HashMap<Int, Int>()
        nums.forEach { number ->
            val repeatsAtContainer = repeatsContainer[number]
            if (repeatsAtContainer == null) {
                repeatsContainer[number] = 1
            } else repeatsContainer[number] = repeatsAtContainer + 1
        }

        repeatsContainer.forEach {
            if (it.value == repeatTimesTarget) {
                return it.key
            }
        }
        return -1
    }
}