package com.modi.wu.linkedlist

import java.util.*

fun main() {
    val head: Node<Int> = Node(1)
    val node1: Node<Int> = Node(2)
    val node2: Node<Int> = Node(3)
    val node3: Node<Int> = Node(2)
//    val node4: Node<Int> = Node(1)

    head.next = node1
    node1.next = node2
    node2.next = node3
//    node3.next = node4
    head.print()
    println(head.isPalindromeByStack().toString() + " | ")
    println(head.isPalindrome().toString() + " | ")

}

/**
 * 给定一个单链表的头节点head，请判断该链表是否为回文结构
 *
 * [a->b->c->b->a]这种结构为回文结构
 * 用堆栈把所有的节点存储起来，结合堆先进后出的原则，
 * 逐个弹出堆中的数据，和链表逐个比较。如果所有元素都相同则为回文数，否则不是回文。
 *
 */
fun <T> Node<T>.isPalindromeByStack(): Boolean {
    if (this.next == null) return true
    var cur: Node<T>? = this
    val stack = Stack<Node<T>>()
    while (cur != null) {
        stack.add(cur)
        cur = cur.next
    }

    cur = this
    while (!stack.isEmpty()) {
        if (stack.pop().value == cur!!.value) {
            cur = cur.next
        } else {
            return false
        }
    }

    return true
}

/**
 * 快慢指针：相同的位置，慢指针移动一位，快指针移动两位。循环执行到最后，
 * 如果链表是奇数长度，慢指针指向中点位置，链表偶数长度，慢指针指向中电前一个位置
 * 先找到中点位置，然后把中点位置后面的链表反转
 * 然后逐个取出对比
 *
 *
 */
fun <T> Node<T>.isPalindrome(): Boolean {
    if (this.next == null) return true

    var node1 :Node<T>?= this
    var node2: Node<T>? = this

    while (node2?.next != null && node2.next!!.next != null) {
        node1 = node1?.next!!
        node2 = node2.next?.next
    }//经过这段操作 node1为中点位置
    node2 = node1?.next!!//此时的node2为右侧链表，只需要反转一下
    node1.next = null
    /*右侧链表反转*/
    var node3:Node<T>?=null
    var pre:Node<T>?=null
    while (node2!=null){
        node3=node2.next
        node2.next=pre
        pre=node2
        node2=node3
    }

    node2=this
    var res=true
    while (pre!=null&&node2!=null){
        if (pre.value!=node2.value){
            res = false
            break
        }
        pre = pre.next
        node2 = node2.next
    }

    return res
}


fun isPalindrome(str: String): Boolean {
    var left: Int = 0
    var right: Int = str.length - 1

    while (left < right) {
        if (str[left] != str[right]) {
            return false
        }
        left++
        right--

    }
    return true
}
