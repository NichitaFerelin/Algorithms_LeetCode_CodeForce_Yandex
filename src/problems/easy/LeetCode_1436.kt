package problems.easy

class LeetCode_1436 {

    fun destCity(paths: List<List<String>>): String {
        val pathsContainer = HashMap<String, String>(paths.size)
        paths.forEach { path ->
            val from = path[0]
            val to = path[1]
            pathsContainer[from] = to
        }
        pathsContainer.forEach {
            if (pathsContainer[it.value] == null) {
                return it.value
            }
        }

        return ""
    }
}