package com.modi.wu.graph

import java.util.*

/**
 * Kruskal 算法是一种用于找到最小生成树（Minimum Spanning Tree，MST）的贪心算法。
 * 最小生成树是一个包含所有图节点的树，它的边权重之和最小，且没有环路。
 * Kruskal 算法的基本思想是按照边的权重从小到大的顺序逐个考虑，每次选择一条权重最小且不形成环路的边加入最小生成树中，
 * 直到最小生成树中包含了所有的节点。
 *
 */


// Union-Find Set
class UnionFind {
    // key 某一个节点， value key节点往上的节点
    private var fatherMap: HashMap<Node?, Node?> = HashMap()

    // key 某一个集合的代表节点, value key所在集合的节点个数
    private var sizeMap: HashMap<Node?, Int> = HashMap()


    fun makeSets(nodes: Collection<Node?>) {
        fatherMap.clear()
        sizeMap.clear()
        for (node in nodes) {
            fatherMap[node] = node
            sizeMap[node] = 1
        }
    }

    private fun findFather(n: Node): Node? {
        var n: Node? = n
        val path = Stack<Node?>()
        while (n !== fatherMap[n]) {
            path.add(n)
            n = fatherMap[n]
        }
        while (!path.isEmpty()) {
            fatherMap[path.pop()] = n
        }
        return n
    }

    fun isSameSet(a: Node, b: Node): Boolean {
        return findFather(a) === findFather(b)
    }

    fun union(a: Node?, b: Node?) {
        if (a == null || b == null) {
            return
        }
        val aDai = findFather(a)
        val bDai = findFather(b)
        if (aDai !== bDai) {
            val aSetSize = sizeMap[aDai]!!
            val bSetSize = sizeMap[bDai]!!
            if (aSetSize <= bSetSize) {
                fatherMap[aDai] = bDai
                sizeMap[bDai] = aSetSize + bSetSize
                sizeMap.remove(aDai)
            } else {
                fatherMap[bDai] = aDai
                sizeMap[aDai] = aSetSize + bSetSize
                sizeMap.remove(bDai)
            }
        }
    }


}


class EdgeComparator : Comparator<Edge> {
    override fun compare(o1: Edge, o2: Edge): Int {
        return o1.weight - o2.weight
    }
}

fun kruskalMST(graph: Graph): Set<Edge>? {
    val unionFind = UnionFind()
    unionFind.makeSets(graph.nodes.values)
    val priorityQueue: PriorityQueue<Edge> = PriorityQueue<Edge>(EdgeComparator())
    for (edge in graph.edges) { // M 条边
        priorityQueue.add(edge) // O(logM)
    }
    val result: MutableSet<Edge> = HashSet()
    while (!priorityQueue.isEmpty()) { // M 条边
        val edge = priorityQueue.poll() // O(logM)
        if (!unionFind.isSameSet(edge.from, edge.to)) { // O(1)
            result.add(edge)
            unionFind.union(edge.from, edge.to)
        }
    }
    return result
}