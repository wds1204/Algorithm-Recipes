package com.modi.wu.linkedlist

class Node<T>(var value: T) {
    var next: Node<T>? = null
}

class DoubleNode<T>(var value: T) {

    var next: DoubleNode<T>? = null
    var last: DoubleNode<T>? = null
}

/**
 * 生产单向链表
 */
fun generateRandomLinkedList(len: Int, value: Int): Node<Int>? {
    var size = (Math.random() * (len + 1)).toInt()
    if (size == 0) {
        return null
    }
    size--
    val head = Node((Math.random() * (value + 1)).toInt())
    var pre = head
    while (size != 0) {
        val cur =
            Node((Math.random() * (value + 1)).toInt())
        pre.next = cur
        pre = cur
        size--
    }
    return head
}

/**
 * 生产双向链表
 */
fun generateRandomDoubleList(len: Int, value: Int): DoubleNode<Int>? {
    var size = (Math.random() * (len + 1)).toInt()
    if (size == 0) {
        return null
    }
    size--
    val head = DoubleNode((Math.random() * (value + 1)).toInt())
    var pre = head
    while (size != 0) {
        val cur = DoubleNode((Math.random() * (value + 1)).toInt())
        pre.next = cur
        cur.last = pre
        pre = cur
        size--
    }
    return head
}

/**
 * 输出单向链表
 */
fun <T>Node<T>?.nullPrint(name: String="node") {
    var node = this

    val str = StringBuffer().append(node?.value)
    while (node?.next != null) {
        str.append("->")
        str.append(node.next!!.value)
        node = node.next!!
    }
    println("$name:{$str}")
}
/**
 * 输出单向链表
 */
fun <T>Node<T>.print(name: String="node") {
    var node = this

    val str = StringBuffer().append(node.value)
    while (node.next != null) {
        str.append("->")
        str.append(node.next!!.value)
        node = node.next!!
    }
    println("$name:{$str}")
}

/**
 * 输出双向链表
 */
fun <T>DoubleNode<T>.print() {
    var node = this

    val str = StringBuffer().append(node.value)
    while (node.next != null) {
        str.append("->")
        str.append(node.next!!.value)
        node = node.next!!
    }
    println("DoubleNode:{$str}")
}