package problems.leetcode.easy

class LeetCode_387 {

    class ContainerItem(var counter: Int, var index: Int)

    fun firstUniqChar(s: String): Int {
        val containerUnique = LinkedHashMap<Char, ContainerItem>()
        s.forEachIndexed { index, symbol ->
            val itemAtContainer = containerUnique[symbol]
            if (itemAtContainer == null) {
                containerUnique[symbol] = ContainerItem(1, index)
            } else itemAtContainer.counter += 1
        }

        containerUnique.forEach {
            if (it.value.counter == 1) return it.value.index
        }

        return -1
    }
}