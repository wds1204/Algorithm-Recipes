package com.modi.wu.binarytree

import java.util.*

//不用递归遍历的方式打印二叉树


/**
 * 先序遍历
 * [node]
 */
fun <T> pre(node: Node<T>) {
    println("pre-order")
    var head = node
    val stack = Stack<Node<T>>()
    stack.push(head)//先把头节点放入栈中
    while (stack.isNotEmpty()) {
        head = stack.pop()
        print("${head.value} ")
        if (head.right != null) {
            stack.push(head.right)
        }
        if (head.left != null) {
            stack.push(head.left)
        }
    }

}

/**
 * 中序遍历
 */
fun <T> mid(node: Node<T>) {
    println("pre-order")

    var head: Node<T>? = node
    val stack = Stack<Node<T>>()
    while (stack.isNotEmpty() || head != null) {
        run {
            if (head != null) {
                stack.push(head)
                head = head!!.left
            } else {
                head = stack.pop()
                print("${head!!.value} ")
                head = head!!.right
            }
        }

    }
}

/**
 * 后序遍历
 */
fun <T> pos(node: Node<T>) {
    println("pre-order")
    var head = node

    val stack1 = Stack<Node<T>>()
    val stack2 = Stack<Node<T>>()

    stack1.push(head)//放入头节点
    while (stack1.isNotEmpty()) {
        head=stack1.pop()
        stack2.push(head)
        if (head.left!=null){
            stack1.push(head.left)
        }
        if (head.right!=null){
            stack1.push(head.right)
        }
    }
    while (stack2.isNotEmpty()){
        print("${stack2.pop().value} ")
    }
}

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