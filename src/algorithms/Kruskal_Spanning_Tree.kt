package algorithms

class Kruskal_Spanning_Tree {

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