package com.modi.wu.graph

import java.util.*

/**
 * 拓扑排序是有向无环图(DAG)的一种排序方式，其中途中每个节点都是按照一定的顺序排列，
 * 使得所有的有向边都从排到前面的节点指向排在后面的节点。换句话说，如果存在一条从节点A到节点B的有向边，
 * 那么在拓扑排序中，节点A排在节点B的前面。
 * 拓扑排序可以用来表示人物的执行顺序
 */
fun sortedTopology(graph: Graph): MutableList<Node> {
    // 拓扑排序的结果，依次加入result
    val inMap= mutableMapOf<Node,Int>()
    val result = mutableListOf<Node>()
    val zeroQueue = LinkedList<Node>()
    for (node in graph.nodes.values) {
        inMap[node]=node.`in`
        if (node.`in` == 0) {
            zeroQueue.add(node)
        }
    }
    while (zeroQueue.isNotEmpty()) {
        val node = zeroQueue.pop()
        result.add(node)
        for (next in node.nexts){
            inMap[next] = inMap[next]?.minus(1) ?: 0
            if (inMap[next]==0){
                zeroQueue.add(next)
            }
        }
    }
    return result

}