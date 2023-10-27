package com.modi.wu.binarytree

import kotlin.math.abs
import kotlin.math.max

/**
 * 给定一个二叉树，判断该二叉树是否是平衡二叉树
 *
 * 平衡二叉树（Balanced Binary Tree）： 一种高度平衡的二叉树，确保每个节点的两个子树的高度差不超过一个固定的值，
 * 以确保树的高度不会过高，从而保持高效的操作复杂度。平衡二叉树的定义是每个节点的左右子树高度差不超过1。
 */


fun <T> isBalanced(head: Node<T>?): Boolean {
    return process(head) != -1

}

fun <T> process(head: Node<T>?): Int {
    if (head == null) return 0

    val leftHeight = process(head.left)
    val rightHeight = process(head.right)
    if (leftHeight == -1 || rightHeight == -1 || abs(leftHeight - rightHeight) > 1) {
        return -1
    }
    return max(leftHeight, rightHeight) + 1

}
/******************更具递归套路的做法******************/

/**
 * 判断二叉树是否是平衡二叉树
 * 1.从头节点X开始，如果X节点是平衡二叉树，那么其左右子节点的一定是平衡横叉树
 * 2.X节点的左右子节点的长度差值不超过
 * 3.所以需要从左右子节点树得到如是信息：是否是平衡二叉树以及子节点的高度
 * 4.把左右子节点书的信息求全集，就能得到任何一棵树都需要返回的信息
 * 5.递归函数返回全集的信
 *
 */


data class BalancedInfo(var isBalanced: Boolean, var height: Int)


fun <T> Node<T>.isBalanced1(): Boolean {
    return process().isBalanced
}

fun <T> Node<T>?.process(): BalancedInfo {
    var head: Node<T>? = this ?: return BalancedInfo(true, 0)
    val leftInfo = head!!.left.process()
    val rightInfo = head.right.process()
    val leftHeight = leftInfo.height
    val rightHeight = rightInfo.height
    val height = max(leftHeight, rightHeight) + 1
    if (leftInfo.isBalanced && rightInfo.isBalanced && abs(leftInfo.height - rightInfo.height) <= 1) {
        return BalancedInfo(true, height)
    }
    return BalancedInfo(false, height)
}

/*****************************************************/


fun main() {
    val head = generateRandomBST(4, 100)

    printTree(head)

    println("head 是否是平衡二叉树：${isBalanced(head)}")
    println("head 是否是平衡二叉树：${head?.isBalanced1()}")

    val head1 = Node("1")
    head1.left = Node("2-1")
    head1.right = Node("2-2")
    head1.left!!.left = Node("3-1")
    head1.left!!.right = Node("3-2")
    head1.left!!.left!!.left = Node("4-1")
    head1.left!!.left!!.left!!.left = Node("5-1")

    printTree(head1)


    println("head1 是否是平衡二叉树：${isBalanced(head1)}")
    println("head1 是否是平衡二叉树：${head1.isBalanced1()}")
}



