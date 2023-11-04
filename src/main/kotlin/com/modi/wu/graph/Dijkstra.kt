package com.modi.wu.graph

import java.util.*

/**
 * Dijkstra 算法是一种用于求解带权重图中最短路径的算法。
 * 1.初始化:将起始值的到起始值的距离为0，到其他点的距离为正无穷大
 * 2.选择最短路径的节点：优先从队列中选择当前最短路径的节点，标记该节点为已处理的
 * 3.更新相邻节点的最短路径，对于当前节点的每个相邻节点，计算通过当前节点到达相邻节点的路径长度，
 * 并更新相邻节点的最短路径。如果新的路径长度比已知的最短路径短，则更新最短路径
 * 4.重复步骤2和步骤3。重复选择最短路径节点和更新相邻节点的最短路径，知道优先队列为空
 * 图中的边权重都为正数，给定一个点，列出这个点到所有点距离最短。
 *
 *
 *
 *
 *
 *
 *
 *
 */


fun dijkstra(from: Node): Map<Node, Int> {
    var node = from
    val nodeMap = mutableMapOf<Node, Int>()
    val selectMap = mutableSetOf<Node>()
    nodeMap[node] = 0

    var minNode: Node? = getMinNode(nodeMap, selectMap)

    while (minNode != null) {
        val length = nodeMap[minNode]!!
        minNode.edges.forEach { edge ->
            if (edge.to !in nodeMap || (nodeMap[edge.to]!! > (edge.weight + length))) {
                nodeMap[edge.to] = edge.weight + length
            }
        }
        selectMap.add(minNode)

        minNode = getMinNode(nodeMap, selectMap)
    }


    return nodeMap
}


private fun getMinNode(nodeMap: MutableMap<Node, Int>, selectMap: MutableSet<Node>): Node? {
    var minEdgeW = Int.MAX_VALUE
    var minNode: Node? = null
    nodeMap.forEach { (k, v) ->
        if (k !in selectMap && v < minEdgeW) {
            minEdgeW = v
            minNode = k
        }
    }
    return minNode
}


fun dijkstra2(head: Node): Map<Node, Int> {
    val nodeMap = mutableMapOf<Node, Int>()
    val priorityQueue = PriorityQueue<Node>(compareBy { nodeMap[it] })
    nodeMap[head] = 0
    priorityQueue.offer(head)

    while (priorityQueue.isNotEmpty()) {
        val node = priorityQueue.poll()
        val weight=nodeMap[node]!!
        node.edges.forEach { edge ->
            if (edge.to !in nodeMap||nodeMap[node]!!>edge.weight+weight){
                nodeMap[edge.to]=edge.weight+weight
                priorityQueue.offer(edge.to)
            }
        }
    }

    return nodeMap
}

/**************************************************/


class DijkstraAlgorithm(private val graph: Map<String, Map<String, Int>>) {
    fun dijkstra(startNode: String): Map<String, Int> {
        val shortestPaths = mutableMapOf<String, Int>()
        val priorityQueue = PriorityQueue<String>(compareBy { shortestPaths[it] })

        shortestPaths[startNode] = 0
        priorityQueue.offer(startNode)

        while (priorityQueue.isNotEmpty()) {
            println("priorityQueue---${priorityQueue}")
            val currentNode = priorityQueue.poll()

            graph[currentNode]?.forEach { (neighbor, weight) ->
                val newPath = shortestPaths[currentNode]!! + weight
                if (newPath < (shortestPaths[neighbor] ?: Int.MAX_VALUE)) {
                    shortestPaths[neighbor] = newPath
                    priorityQueue.offer(neighbor)
                }
            }
        }

        return shortestPaths
    }
}

fun main() {
    val graph = mapOf(
        "A" to mapOf("B" to 2, "C" to 4),
        "B" to mapOf("C" to 1, "D" to 7),
        "C" to mapOf("D" to 3),
        "D" to mapOf("E" to 1),
        "E" to emptyMap()
    )
//    val graph = mapOf(
//        "A" to mapOf("B" to 8, "C" to 6,"D" to 10),
//        "C" to mapOf("B" to 3,"D" to 1)
//    )

    val startNode = "A"
    val dijkstraAlgorithm = DijkstraAlgorithm(graph)
    val shortestPaths = dijkstraAlgorithm.dijkstra(startNode)

    println("Shortest Paths from Node $startNode:")
    shortestPaths.forEach { (node, distance) ->
        println("To Node $node: $distance")
    }
}