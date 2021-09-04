package problems.leetcode.easy

class LeetCode_1491 {
    fun average(salary: IntArray): Double {
        val allSalaries = HashMap<Int, Unit>(salary.size)
        var minSalary = Int.MAX_VALUE
        var maxSalary = Int.MIN_VALUE

        salary.forEach {
            allSalaries[it] = Unit
            if (it > maxSalary) maxSalary = it
            if (it < minSalary) minSalary = it
        }

        allSalaries.remove(minSalary)
        allSalaries.remove(maxSalary)
        return allSalaries.keys.sum().toDouble() / allSalaries.keys.size.toDouble()
    }
}