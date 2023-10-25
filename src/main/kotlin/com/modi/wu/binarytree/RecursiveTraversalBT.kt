package com.modi.wu.binarytree

/**
 * 使用递归遍历的方式打印
 */
fun <T> pre(head: Node<T>?) {
    if (head == null) return
    print("${head.value} ")
    pre(head.left)
    pre(head.right)
}


fun <T> mid(head: Node<T>?) {
    if (head == null) return
    mid(head.left)
    print("${head.value} ")
    mid(head.right)
}


fun <T> pos(head: Node<T>?) {
    if (head == null) return
    pos(head.left)
    print("${head.value} ")
    pos(head.right)
}

/**
 *        二叉树
 *          1
 *      2        3
 *    4   5    6   7
 *
 *
 * 二叉数的打印可以分为先序(头->左->右)、中序(左->头->右)、后序(左->右->头)
 *
 * 分别用不同的方式展开上述二叉树
 * 先序的结果:1、2、4、5、3、6、7
 * 中序的结果:4、2、5、1、6、3、7
 * 先序的结果:4、5、2、6、7、3、1
 */
fun main() {
    val head = Node(1)
    head.left = Node(2)
    head.right = Node(3)
    head.left!!.left = Node(4)
    head.left!!.right = Node(5)
    head.right!!.left = Node(6)
    head.right!!.right = Node(7)

    //先序打印
    println("\n${"=".repeat(20)}>先序打印<${"=".repeat(20)}")
    pre(head)
    println("\n${"=".repeat(20)}>中序打印<${"=".repeat(20)}")
    mid(head)
    println("\n${"=".repeat(20)}>后序打印<${"=".repeat(20)}")
    pos(head)


}