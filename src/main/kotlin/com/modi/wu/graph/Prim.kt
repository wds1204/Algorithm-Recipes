package com.modi.wu.graph

import java.util.*

/**
 * 最小生成树算法
 * Prim算法是一种找到最小生成树的贪心算法，生成的树是一个包含所有图节点的树，它的边权重之和最小，且没有环路
 * Prim算法的基本思想找一饿初识点，
 *
 */
fun primAlgorithm(graph: Graph): List<Edge> {
    val queue = PriorityQueue<Edge>(Comparator.comparingInt { it.weight })

    val nodeSet = mutableSetOf<Node>()

    val result = mutableListOf<Edge>()
    val edges = mutableListOf<Edge>()

    for (node in graph.nodes.values) {
        if (node !in nodeSet) {
            nodeSet.add(node)
            node.edges.forEach {
                if (!edges.contains(it)){
                    queue.add(it)
                }
                edges.add(it)

            }
            while (queue.isNotEmpty()) {
                val edge = queue.poll()
                val toNode = edge.to
                if (toNode !in nodeSet) {
                    nodeSet.add(toNode)
                    queue.add(edge)
                    result.add(edge)
                    toNode.edges.forEach {
                        if (!edges.contains(it)){
                            queue.add(it)
                        }
                        edges.add(it)
                    }
                }
            }
        }
        break

    }

    return result

}