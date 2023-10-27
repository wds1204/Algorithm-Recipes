package com.modi.wu.binarytree

import kotlin.math.max

/**
 * 给定一课二叉树的头节点head,任何两个节点之间都存在距离，那么返回整课二叉树的最大距离
 */

data class DistanceInfo(var height: Int, var maxDistance: Int)

fun <T> Node<T>.maxDistance(): Int {
    return this.distanceProcess().maxDistance
}

fun <T> Node<T>?.distanceProcess(): DistanceInfo {
    val head = this ?: return DistanceInfo(0, 0)

    val leftInfo = head.left.distanceProcess()
    val rightInfo = head.right.distanceProcess()
    val leftHeight = leftInfo.height
    val rightHeight = rightInfo.height

    val height = max(leftHeight, rightHeight) + 1

    //比较当前节点的最大距离、左右子节点下的最大距离，三者谁最大赋值给maxDistance
    val maxDistance = max(
        max(leftInfo.maxDistance, rightInfo.maxDistance), leftHeight + rightHeight + 1
    )


    return DistanceInfo(height, maxDistance)
}


fun main() {
    val head = generateRandomBST(4, 100)

    printTree(head)

    println("head二叉树的最大距离：${ head?.maxDistance()}")



    val head1 = Node("1")
    head1.left = Node("2-1")
    head1.right = Node("2-2")
    head1.left!!.left = Node("3-1")
    head1.left!!.right = Node("3-2")
    head1.left!!.left!!.left = Node("4-1")
    head1.left!!.left!!.left!!.left = Node("5-1")

    printTree(head1)

    println("head1二叉树的最大距离：${ head1.maxDistance()}")

}

