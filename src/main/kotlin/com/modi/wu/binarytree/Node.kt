package com.modi.wu.binarytree

import kotlin.random.Random

/**
 * 二叉树
 */
class Node<T>(var value:T) {
    var left: Node<T>? = null
    var right: Node<T>? = null
}


fun generateRandomBST(maxLevel: Int, maxValue: Int): Node<Int>? {
    return generate(1, maxLevel, maxValue)
}

fun generate(level: Int, maxLevel: Int, maxValue: Int): Node<Int>? {
    if (level > maxLevel ) {
        return null
    }

    val head = Node(Random.nextInt(0,maxValue))
    head.left = generate(level + 1, maxLevel, maxValue)
    head.right = generate(level + 1, maxLevel, maxValue)
    return head
}