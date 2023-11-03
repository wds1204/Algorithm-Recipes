package com.modi.wu.graph

/**
 * 深度优先搜索(DFS)是一种图的遍历方法，用于深入尽可能元的节点，然后回溯到之前节点。
 */

import java.util.*

class `Graph_` {
    private val adjacencyList = mutableMapOf<String, MutableList<String>>()

    fun addEdge(source: String, destination: String) {
        adjacencyList.computeIfAbsent(source) { mutableListOf() }.add(destination)
        adjacencyList.computeIfAbsent(destination) { mutableListOf() }.add(source)
    }

    fun dfs(startNode: String): List<String> {
        val visited = mutableSetOf<String>()
        val result = mutableListOf<String>()

        dfsRecursive(startNode, visited, result)

        return result
    }

    private fun dfsRecursive(node: String, visited: MutableSet<String>, result: MutableList<String>) {
        visited.add(node)
        result.add(node)

        adjacencyList[node]?.forEach { neighbor ->
            if (neighbor !in visited) {
                dfsRecursive(neighbor, visited, result)
            }
        }
    }
}


fun dfs(node: Node) {
    val stack = Stack<Node>()
    val set = mutableSetOf<Node>()
    stack.add(node)
    set.add(node)
    println("${node.value}")
    while (stack.isNotEmpty()) {
        val cur = stack.pop()
        for (next in cur.nexts) {
            if (next !in set){
                stack.push(cur)
                stack.push(next)
                set.add(next)
                println("${next.value}")
                break
            }

        }

    }


}


fun main() {
    val graph = Graph_()
    graph.addEdge("A", "B")
    graph.addEdge("A", "C")
    graph.addEdge("B", "D")
    graph.addEdge("B", "E")
    graph.addEdge("C", "F")
    graph.addEdge("C", "G")

    val startNode = "A"
    val dfsResult = graph.dfs(startNode)

    println("DFS traversal starting from node $startNode: $dfsResult")
}
