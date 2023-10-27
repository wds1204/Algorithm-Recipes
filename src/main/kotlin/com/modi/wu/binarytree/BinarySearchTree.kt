package com.modi.wu.binarytree

import kotlin.math.max


/**
 * 给定一颗二叉树的头节点head，返回这颗二叉树中最大的搜索二叉树的头节点
 * 搜索二叉树(Binary search tree,BST)是一种二叉树，其中每个节点的值大于其左子节点的值，小于其右子节点的值
 */

data class BSTInfo<Int>(var isBST: Boolean, var size: Int, val min: Int, val max: Int, var node: Node<Int>?)

fun Node<Int>.largestBSTSubtree(): Node<Int>? {
    println(this.bSTProcess())
    return this.bSTProcess().node

}

fun Node<Int>?.bSTProcess(): BSTInfo<Int> {
    if (this == null) return BSTInfo(true, 0, Int.MAX_VALUE, Int.MIN_VALUE, null)

    val leftInfo = this.left.bSTProcess()
    val rightInfo = this.right.bSTProcess()
    if (!leftInfo.isBST || !rightInfo.isBST ||
        this.value <= leftInfo.max || this.value >= rightInfo.min
    ) {
        return BSTInfo(
            false,
            max(leftInfo.size, rightInfo.size),
            0,
            0,
            if (leftInfo.size > rightInfo.size) leftInfo.node else rightInfo.node
        )
    }

    val size = leftInfo.size + rightInfo.size + 1
    val min = if (leftInfo.size == 0) this.value else leftInfo.min
    val max = if (rightInfo.size == 0) this.value else rightInfo.max


    return BSTInfo<Int>(true, size, min, max, this)
}

fun main() {
    // 示例用法
    val head = Node(10)
    head.left = Node(5)
    head.right = Node(15)
    head.left?.left = Node(1)
    head.left?.right = Node(8)
    head.right?.right = Node(7)

    printTree(head)


    println("head为头节点的二叉树，找到的最大搜索子树的头节点：${head.largestBSTSubtree()?.value}")



}





