package com.modi.wu.graph


/**
 * 点的描述
 * [value]:点的value
 * [in]:有多个边指向改点
 * [out]:有多少个边从这个点出
 * [nexts]：改点指向的点
 * [edges]:多个边
 */
class Node(value: Int) {
    var value: Int? = value
    var `in`: Int = 0
    var out: Int = 0
    var nexts: MutableList<Node>
    var edges: MutableList<Edge>

    init {
        `in` = 0
        out = 0
        nexts = mutableListOf()
        edges = mutableListOf()
    }

    override fun toString(): String {
        return "Node(value=$value, `in`=$`in`, out=$out, nexts=$nexts, edges=$edges)"
    }


}

/**
 * 边的描述
 * [weight]:边的权重
 * [from]:边from的点
 * [to]:边指向的点
 */
data class Edge(var weight: Int, var from: Node, var to: Node)

/**
 * 图
 * 有多少点和多个边
 */
class Graph {
    val nodes = hashMapOf<Int, Node>()
    val edges = hashSetOf<Edge>()
}


/**
 * [metrics]是个N*3的矩阵
 * [weight边权重,from节点上的面值,to节点上的面值]
 */
fun `createGraph`(metrics: Array<Array<Int>>): Graph {
    val graph = Graph()
    for (i in metrics.indices) {
        val weight = metrics[i][0]
        val from = metrics[i][1]
        val to = metrics[i][2]

        val nodes = graph.nodes

        val fromNode = nodes.computeIfAbsent(from) { Node(it) }
        val toNode = nodes.computeIfAbsent(to) { Node(it) }

        fromNode.out++
        toNode.`in`++

        val edge = Edge(weight, fromNode, toNode)
        fromNode.edges.add(edge)
        val edges = graph.edges
        edges.add(edge)
    }

    return graph

}


fun main() {

    val graph = Graph()

    val node = graph.nodes.computeIfAbsent(1) {
        Node(1)
    }
    println("node--${node}")

}