package problems.medium

class LeetCode_1817 {

    fun findingUsersActiveMinutes(logs: Array<IntArray>, k: Int): IntArray {
        val resultArr = IntArray(k)
        val userActivityContainer = HashMap<Int, Set<Int>>(logs.size)

        logs.forEach { user ->
            val userId = user[0]
            val userActiveMinute = user[1]
            val userAtContainer = userActivityContainer[userId]
            if (userAtContainer == null) {
                userActivityContainer[userId] = setOf(userActiveMinute)
            } else {
                val newSet = userAtContainer.toMutableSet().apply {
                    add(userActiveMinute)
                }
                userActivityContainer[userId] = newSet
            }
        }

        userActivityContainer.forEach {
            val totalActiveMinutes = it.value.size
            resultArr[totalActiveMinutes - 1]++
        }

        return resultArr
    }
}