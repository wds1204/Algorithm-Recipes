package com.modi.wu.linkedlist

fun main() {

    val node1 = generateRandomLinkedList(100, 100)
    node1?.print()

    val newNode1 = node1?.reverseLinkedList()
    newNode1?.print()
//
    val doubleNode = generateRandomDoubleList(100, 100)
    doubleNode?.print()

    val newDN = doubleNode?.reverseDoubleList()
    newDN?.print()

    val newDNR = newDN?.reverseDoubleList()
    newDNR?.print()


}

class NodeP<T>(var value: T) {
    var next: NodeP<T>? = null
}

fun <T> Node<T>.reverse(): Node<T> {
    var head: Node<T>? = this
    var pre: Node<T>? = null
    var next: Node<T>? = null

    while (head != null) {
        next = head.next
        head.next = pre
        pre = head
        if (next != null) {
            head = next
        }
    }

    return pre!!
}

fun <T> DoubleNode<T>.reverse(): DoubleNode<T> {
    var head: DoubleNode<T>? = this
    var pre: DoubleNode<T>? = null
    var next: DoubleNode<T>? = null

    while (head != null) {
        next = head.next

        head.next = pre
        head.last = next

        pre = head

        head = next

    }

    return pre!!
}


/**
 * 单链表反转
 */
fun <T> Node<T>.reverseLinkedList(): Node<T>? {
    var head: Node<T>? = this
    var pre: Node<T>? = null
    var next: Node<T>? = null

    while (head != null) {
        next = head.next//截取出head的next后部分链表
        head.next = pre//head.next=pre截取出head.next前部分的链表
        pre = head//
        head = next
    }

    return pre
}


/**
 * 双向链表反转
 */
fun <T> DoubleNode<T>.reverseDoubleList(): DoubleNode<T>? {
    var head: DoubleNode<T>? = this
    var pre: DoubleNode<T>? = null
    var next: DoubleNode<T>? = null

    while (head != null) {
        next = head.next
        head.next = pre
        head.last = next
        pre = head
        head = next
    }
    return pre
}







