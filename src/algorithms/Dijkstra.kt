package algorithms

object Dijkstra {

    class Node(val name: Int, var paths: List<Path> = emptyList())

    class Path(val cost: Int, val from: Node, val to: Node)

    fun search(root: Node, target: Node): List<Node>? {
        val pathsCost = HashMap<Node, Path>()
        val notFinishedPaths = HashMap<Node, Unit>()
        val finishedPaths = HashMap<Node, List<Node>>()

        finishedPaths[root] = listOf(root)

        var currentNode = root
        var currentPathCost = 0

        while (true) {
            currentNode.paths.forEach { availablePath ->
                if (finishedPaths[availablePath.to] == null) {
                    notFinishedPaths[availablePath.to] = Unit
                    val newCostToAvailablePath = currentPathCost + availablePath.cost

                    if (pathsCost[availablePath.to] == null) {
                        val newPath = Path(newCostToAvailablePath, currentNode, availablePath.to)
                        pathsCost[availablePath.to] = newPath
                    } else {
                        val previousCost = pathsCost[availablePath.to]!!.cost
                        if (previousCost > newCostToAvailablePath) {
                            val newPath = Path(newCostToAvailablePath, currentNode, availablePath.to)
                            pathsCost[availablePath.to] = newPath
                        }
                    }
                }
            }

            var minAvailableNode: Node? = null
            var costToMinNode = Int.MIN_VALUE
            notFinishedPaths.keys.forEach { notFinishedNode ->
                val costToNode = pathsCost[notFinishedNode]!!.cost
                if (minAvailableNode == null || costToMinNode > costToNode) {
                    costToMinNode = costToNode
                    minAvailableNode = notFinishedNode
                }
            }

            if (minAvailableNode == null) {
                break
            }

            val resultPathToNode = mutableListOf<Node>()
            var tempNode = minAvailableNode
            while (tempNode != null) {
                resultPathToNode.add(0, tempNode)
                tempNode = pathsCost[tempNode]?.from
            }

            finishedPaths[minAvailableNode!!] = resultPathToNode
            notFinishedPaths.remove(minAvailableNode!!)

            currentNode = minAvailableNode!!
            currentPathCost = pathsCost[currentNode]!!.cost

            if (currentNode == target) {
                return finishedPaths[currentNode]!!
            }
        }

        return null
    }

    /*val x1 = Dijkstra.Node(1)
    val x2 = Dijkstra.Node(2)
    val x3 = Dijkstra.Node(3)
    val x4 = Dijkstra.Node(4)
    val x5 = Dijkstra.Node(5)
    val x6 = Dijkstra.Node(6)
    val x7 = Dijkstra.Node(7)
    val x8 = Dijkstra.Node(8)
    val x9 = Dijkstra.Node(9)

    val path17 = Dijkstra.Path(cost = 3, from = x1, to = x7)
    val path71 = Dijkstra.Path(cost = 3, from = x7, to = x1)
    val path72 = Dijkstra.Path(cost = 9, from = x7, to = x2)
    val path12 = Dijkstra.Path(cost = 2, from = x1, to = x2)
    val path21 = Dijkstra.Path(cost = 2, from = x2, to = x1)
    val path13 = Dijkstra.Path(cost = 6, from = x1, to = x3)
    val path14 = Dijkstra.Path(cost = 8, from = x1, to = x4)
    val path24 = Dijkstra.Path(cost = 3, from = x2, to = x4)
    val path31 = Dijkstra.Path(cost = 6, from = x3, to = x1)
    val path34 = Dijkstra.Path(cost = 7, from = x3, to = x4)
    val path43 = Dijkstra.Path(cost = 7, from = x4, to = x3)
    val path41 = Dijkstra.Path(cost = 8, from = x4, to = x1)
    val path32 = Dijkstra.Path(cost = 9, from = x3, to = x2)
    val path23 = Dijkstra.Path(cost = 9, from = x2, to = x3)
    val path75 = Dijkstra.Path(cost = 8, from = x7, to = x5)
    val path57 = Dijkstra.Path(cost = 8, from = x5, to = x7)
    val path42 = Dijkstra.Path(cost = 3, from = x4, to = x2)
    val path26 = Dijkstra.Path(cost = 4, from = x2, to = x6)
    val path62 = Dijkstra.Path(cost = 4, from = x6, to = x2)
    val path45 = Dijkstra.Path(cost = 5, from = x4, to = x5)
    val path64 = Dijkstra.Path(cost = 5, from = x6, to = x4)
    val path58 = Dijkstra.Path(cost = 9, from = x5, to = x8)
    val path89 = Dijkstra.Path(cost = 1, from = x8, to = x9)
    val path98 = Dijkstra.Path(cost = 1, from = x9, to = x8)
    val path96 = Dijkstra.Path(cost = 4, from = x9, to = x6)
    val path85 = Dijkstra.Path(cost = 9, from = x8, to = x5)
    val path69 = Dijkstra.Path(cost = 4, from = x6, to = x9)
    val path68 = Dijkstra.Path(cost = 6, from = x6, to = x8)

    x1.paths = mutableListOf(path17, path12, path14, path13)
    x2.paths = mutableListOf(path21, path26, path24, path23)
    x3.paths = mutableListOf(path31, path32, path34)
    x4.paths = mutableListOf(path43, path41, path42, path45)
    x5.paths = mutableListOf(path57, path58)
    x6.paths = mutableListOf(path68, path62, path64, path69)
    x7.paths = mutableListOf(path71, path72, path75)
    x8.paths = mutableListOf(path85, path89)
    x9.paths = mutableListOf(path98, path96)

    val to2 = Dijkstra.search(x1, x2)
    val to3 = Dijkstra.search(x1, x3)
    val to4 = Dijkstra.search(x1, x4)
    val to5 = Dijkstra.search(x1, x5)
    val to6 = Dijkstra.search(x1, x6)
    val to7 = Dijkstra.search(x1, x7)
    val to8 = Dijkstra.search(x1, x8)
    val to9 = Dijkstra.search(x1, x9)
    to9*/
}