package com.modi.wu.binarytree

import kotlin.math.max

/**
 * 满二叉树（Full Binary Tree）： 一种二叉树，除了叶子节点，每个节点都有两个子节点。
 *
 * 解题思路：n为二叉树的层数，2^n-1为满二叉树的节点的个数
 */

data class FullInfo(var height: Int, var nodeSize: Int)

fun <T> Node<T>.isFull(): Boolean {

    return (1 shl fullProcess().height) - 1 == fullProcess().nodeSize
}


fun <T> Node<T>?.fullProcess(): FullInfo {
    if (this == null) return FullInfo(0, 0)
    val leftInfo = this.left.fullProcess()
    val rightInfo = this.right.fullProcess()

    val height = max(leftInfo.height, rightInfo.height) + 1
    val nodeSize = leftInfo.nodeSize + rightInfo.nodeSize + 1


    return FullInfo(height, nodeSize)
}

fun main() {
    val head = generateRandomBST(4, 100)

    printTree(head)

    println("head二叉树是否是满二叉树:${head!!.isFull()}")

    // 示例用法
    val head1 = Node(10)
    head1.left = Node(5)
    head1.right = Node(15)
    head1.left?.left = Node(1)
    head1.left?.right = Node(8)
    head1.right?.right = Node(7)

    printTree(head1)
    println("head1二叉树是否是满二叉树:${head1.isFull()}")


}