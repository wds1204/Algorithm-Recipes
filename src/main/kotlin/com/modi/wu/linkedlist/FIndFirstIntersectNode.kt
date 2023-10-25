package com.modi.wu.linkedlist

import kotlin.math.abs

/**
 * 给定两个有环也可能无环的单链表，头节点head1和head2,请实现一个函数，如果两个链表相交，
 * 请返回相交的第一个节点，如果不相交，返回null
 *
 * 如果两个链表的长度之和为N，时间复杂度请达到O(N),额外空间复杂的请达到O(1)
 */


/**
 * 找到链表第一个入环节点，如果无环，返回null
 *
 * 慢指针移动一位，快指针移动两位，如果有环两个指针会相遇，然后快指针重新指向链表头部
 * 两个指针接着同时移动一步，当它们相遇时就是链表的入环节点。
 *
 *
 */
fun Node<Int>.getLoopNode(): Node<Int>? {
    if (this.next == null || this.next!!.next == next) return null

    var n1 = this.next//慢指针
    var n2 = this.next!!.next//快指针

    while (n1 != n2) {
        if (n2?.next == null || n2.next!!.next == null) return null
        n1 = n1!!.next
        n2 = n2.next!!.next
    }
    //将n2重新指到链表的头部，然后两个指针每次移动一步，当它们相遇时即为入环节点
    n2 = this

    while (n1 != n2) {
        n1 = n1?.next
        n2 = n2?.next
    }

    return n1
}

/**
 * 如果两个链表都无环，返回第一个相交节点，如果不相交，返回NULL
 */
fun Node<Int>.noLoop(node: Node<Int>): Node<Int>? {

    val node1 = this
    val node2 = node
    var cur1: Node<Int>? = node1
    var cur2: Node<Int>? = node2
    var n = 0
    while (cur1?.next != null) {
        n++
        cur1 = cur1.next!!
    }
    while (cur2?.next != null) {
        n--
        cur2 = cur2.next!!
    }
    if (cur2 != cur1) return null

    cur1 = if (n > 0) node1 else node2
    cur2 = if (cur1 == node1) node2 else node1

    n = abs(n)
    while (n != 0) {
        n--
        cur1 = cur1?.next
    }

    while (cur1 != cur2) {
        cur1 = cur1?.next
        cur2 = cur2?.next
    }

    return cur1
}

/**
 * 两个有环链表，返回第一个相交节点，如果不相交返回null
 *
 * 两个有环链表相交只有两种情况，链表zai
 */
fun Node<Int>.bothLoopNode(node: Node<Int>): Node<Int>? {
    //找到各自入环节点
    val loopStartA = this.getLoopNode()
    val loopStartB = node.getLoopNode()

    var cur1: Node<Int>?
    var cur2: Node<Int>?
    //如果两个有环链表的入环节点相同，则它们在环上相交
    if (loopStartA == loopStartB) {
        val node1 = this
        val node2 = node
        cur1 = node1
        cur2 = node2
        var n = 0
        while (cur1?.next != null) {
            n++
            cur1 = cur1.next!!
        }
        while (cur2?.next != null) {
            n--
            cur2 = cur2.next!!
        }
        if (cur2 != cur1) return null

        cur1 = if (n > 0) node1 else node2
        cur2 = if (cur1 == node1) node2 else node1

        n = abs(n)
        while (n != 0) {
            n--
            cur1 = cur1?.next
        }

        while (cur1 != cur2) {
            cur1 = cur1?.next
            cur2 = cur2?.next
        }

        return cur1

    } else {
        cur1 = loopStartA?.next
        while (cur1 != loopStartA) {
            if (cur1 == loopStartB) {
                return loopStartA
            }
            cur1 = cur1?.next
        }
        return null

    }

}


fun Node<Int>.getIntersectNode(node: Node<Int>): Node<Int>? {

    val head1 = this

    val loop1 = head1.getLoopNode()
    val loop2 = node.getLoopNode()
    if (loop1 == null && loop2 == null) {
        return head1.noLoop(node)
    }
    if (loop1 != null && loop2 != null) {
        return head1.bothLoopNode(node)
    }
    return null
}

fun main() {

    // 1->2->3->4->5->6->7->null
    val head1 = Node(1)
    head1.next = Node(2)
    head1.next!!.next = Node(3)
    head1.next!!.next!!.next = Node(4)
    head1.next!!.next!!.next!!.next = Node(5)
    head1.next!!.next!!.next!!.next!!.next = Node(6)
    head1.next!!.next!!.next!!.next!!.next!!.next = Node(7)

    // 0->9->8->6->7->null

    // 0->9->8->6->7->null
    val head2 = Node(0)
    head2.next = Node(9)
    head2.next!!.next = Node(8)
    head2.next!!.next!!.next = head1.next!!.next!!.next!!.next!!.next // 8->6

    val node = head1.getIntersectNode(head2)

    node.nullPrint("first node")

}