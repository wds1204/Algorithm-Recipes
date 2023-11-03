package com.modi.wu.graph

import java.util.*


/**
 * 广度优先搜索(BFS)是一种图遍历的算法，它从图的起始节点开始，逐层访问层节点，先访问当前层的节点，
 * 然后在访问下一层的节点，进行广度优先搜索的时，通常会记录节点访问顺序，以及节点之前的遍历顺序。
 */


fun bfs(node: Node) {
    val queue = LinkedList<Node>()
    val set = hashSetOf<Node>()
    queue.add(node)
    set.add(node)
    while (!queue.isEmpty()) {
        val node = queue.pop()
        println("${node.value}")
        val listNodes = node.nexts
        listNodes.forEach { node ->
            if (node !in set) {
                queue.add(node)
                set.add(node)
            }

        }
    }
}

fun bfs(graph: Map<String, List<String>>, start: String): List<Pair<String, String>> {
    val visited = mutableSetOf<String>()
    val queue: Queue<String> = LinkedList()
    val edgeTraversal = mutableListOf<Pair<String, String>>()

    queue.add(start)
    visited.add(start)

    while (queue.isNotEmpty()) {
        val current = queue.poll()

        graph[current]?.forEach { neighbor ->
            if (neighbor !in visited) {
                visited.add(neighbor)
                queue.add(neighbor)
                edgeTraversal.add(Pair(current, neighbor))
            }
        }
    }

    return edgeTraversal
}

fun main() {
    // 举例：使用邻接表表示图
    val graph = mapOf(
        "A" to listOf("B", "C"),
        "B" to listOf("A", "D", "E"),
        "C" to listOf("A", "F", "G"),
        "D" to listOf("B"),
        "E" to listOf("B", "F"),
        "F" to listOf("C", "E"),
        "G" to listOf("C")
    )

    val startNode = "A"
    val result = bfs(graph, startNode)
    println(result)
}

