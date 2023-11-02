package com.modi.wu.unionfind

import java.util.*


class Node<V>(var value: V)

class UnionSet<V> {

    private val nodes = hashMapOf<V, Node<V>>()
    private val nodeSize = hashMapOf<Node<V>, Int>()
    private val parentNodes = hashMapOf<Node<V>, Node<V>>()

    constructor(list: List<V>) {
        list.forEach { cur ->
            val node = Node(cur)
            nodes[cur] = node
            parentNodes[node] = node
            nodeSize[node] = 1
        }
    }

    private fun findFather(node: Node<V>): Node<V> {
        var cur = node
        val stack = Stack<Node<V>>()
        while (cur != parentNodes[cur]) {
            stack.push(cur)
            cur = parentNodes[cur]!!
        }
        /**
         * 把链表弄扁平，father下面的子节点的father都指向它
         */
        while (stack.isNotEmpty()) {
            parentNodes[stack.pop()] = cur
        }
        return cur
    }

    fun isSameSet(x: V, y: V): Boolean {
        if (!nodes.containsKey(x) || !nodes.containsKey(y)) return false
        return findFather(nodes[x]!!) == findFather(nodes[y]!!)
    }

    fun union(x: V, y: V) {
        if (!nodes.containsKey(x) || !nodes.containsKey(y)) return

        val xHead = findFather(nodes[x]!!)
        val yHead = findFather(nodes[y]!!)

        if (xHead != yHead) {
            val xSize = nodeSize[xHead]!!
            val ySize = nodeSize[yHead]!!

            if (xSize <= ySize) {
                parentNodes[xHead] = yHead
                nodeSize.remove(xHead)
            } else {
                parentNodes[yHead] = xHead
                nodeSize.remove(yHead)
            }

        }
    }

    fun getNodeSize():Int=nodeSize.size

}
