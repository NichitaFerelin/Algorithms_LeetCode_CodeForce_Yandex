package algorithms

class Kruskal_Spanning_Tree {

    /*val nodeA = Kruskal_Spanning_Tree.Node('A')
    val nodeB = Kruskal_Spanning_Tree.Node('B')
    val nodeC = Kruskal_Spanning_Tree.Node('C')
    val nodeD = Kruskal_Spanning_Tree.Node('D')
    val nodeE = Kruskal_Spanning_Tree.Node('E')
    val nodeF = Kruskal_Spanning_Tree.Node('F')
    val nodeG = Kruskal_Spanning_Tree.Node('G')
    val nodeH = Kruskal_Spanning_Tree.Node('H')
    val nodeI = Kruskal_Spanning_Tree.Node('I')
    val nodeJ = Kruskal_Spanning_Tree.Node('J')

    val ab = Kruskal_Spanning_Tree.Edge(5, nodeA, nodeB)
    val ae = Kruskal_Spanning_Tree.Edge(1, nodeA, nodeE)
    val ad = Kruskal_Spanning_Tree.Edge(4, nodeA, nodeD)
    val bc = Kruskal_Spanning_Tree.Edge(4, nodeB, nodeC)
    val bd = Kruskal_Spanning_Tree.Edge(2, nodeB, nodeD)
    val cj = Kruskal_Spanning_Tree.Edge(2, nodeC, nodeJ)
    val ci = Kruskal_Spanning_Tree.Edge(1, nodeC, nodeI)
    val ch = Kruskal_Spanning_Tree.Edge(4, nodeC, nodeH)
    val ji = Kruskal_Spanning_Tree.Edge(0, nodeJ, nodeI)
    val ih = Kruskal_Spanning_Tree.Edge(6, nodeI, nodeH)
    val ig = Kruskal_Spanning_Tree.Edge(4, nodeI, nodeG)
    val hg = Kruskal_Spanning_Tree.Edge(1, nodeH, nodeG)
    val hd = Kruskal_Spanning_Tree.Edge(2, nodeH, nodeD)
    val de = Kruskal_Spanning_Tree.Edge(2, nodeD, nodeE)
    val df = Kruskal_Spanning_Tree.Edge(5, nodeD, nodeF)
    val dg = Kruskal_Spanning_Tree.Edge(11, nodeD, nodeG)
    val gf = Kruskal_Spanning_Tree.Edge(7, nodeG, nodeF)
    val fe = Kruskal_Spanning_Tree.Edge(1, nodeF, nodeE)*/

    class Node(val name: Char)

    class Edge(val cost: Int, val from: Node, val to: Node)

    class Union(val size: Int, val nodes: HashMap<Node, Unit> = HashMap(size)) {

        fun contains(edge: Edge): Node? {
            return if (nodes[edge.from] != null || nodes[edge.to] != null) {
                if (nodes[edge.from] == null) edge.to else edge.from
            } else null
        }
    }

    fun findMinimumSpanningTree(edges: List<Edge>): List<Node> {
        val sortedEdges = edges.sortedBy { it.cost }
        val unions = mutableListOf<Union>()

        for (edge in sortedEdges) {
            val edgeUnions = unions.findNodesUnionsByEdge(edge)
            val fromNodeUnion = edgeUnions.first
            val toNodeUnion = edgeUnions.second

            when {
                fromNodeUnion == null && toNodeUnion == null -> {
                    val newUnion = Union(sortedEdges.size)
                    newUnion.nodes[edge.from] = Unit
                    newUnion.nodes[edge.to] = Unit
                    unions.add(newUnion)
                }
                fromNodeUnion != null && toNodeUnion != null -> {
                    if (fromNodeUnion == toNodeUnion) {
                        continue
                    }
                    fromNodeUnion.nodes.forEach { mapNode ->
                        toNodeUnion.nodes[mapNode.key] = Unit
                    }
                    unions.remove(fromNodeUnion)
                }
                fromNodeUnion == null -> toNodeUnion!!.nodes[edge.from] = Unit
                toNodeUnion == null -> fromNodeUnion.nodes[edge.to] = Unit
            }
        }

        val result = mutableListOf<Node>()
        unions[0].nodes.forEach { mapNode -> result.add(mapNode.key) }
        return result
    }

    private fun List<Union>.findNodesUnionsByEdge(edge: Edge): Pair<Union?, Union?> {
        var firstNodeUnion: Union? = null
        var secondNodeUnion: Union? = null

        forEach { union ->
            if (firstNodeUnion == null && union.nodes[edge.from] != null) {
                firstNodeUnion = union
            }

            if (secondNodeUnion == null && union.nodes[edge.to] != null) {
                secondNodeUnion = union
            }

            if (firstNodeUnion != null && secondNodeUnion != null) {
                return@forEach
            }
        }

        return Pair(firstNodeUnion, secondNodeUnion)
    }
}