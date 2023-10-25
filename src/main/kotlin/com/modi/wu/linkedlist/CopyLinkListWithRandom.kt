package com.modi.wu.linkedlist

/**
 * 一种特殊的单链表节点描述如下：
 * class RandomNode(value:Int){
 *   var next:Node?=null
 *   var rand:Node?=null
 * }
 * rand指针是单链表节点结构中新增的指针，rand可能指向链表中任意一个节点，也可能指向null
 *
 * 给定一个由Node节点类型组成的无环单链表节点head,请实现一个函数完成这个链表的复制，并返回复制的新链表的头节点
 * 要求：时间复杂的O(N)，而外空间复杂O(1)
 */
class RandomNode(var value: Int) {
    var next: RandomNode? = null
    var rand: RandomNode? = null
}

/**
 * 输出单向链表
 */
fun RandomNode?.nullPrint(name: String = "node") {
    var node = this

    val str = StringBuffer().append(node?.value)
    while (node?.next != null) {
        str.append("->")
        str.append(node.next!!.value)
        node = node.next!!
    }
    println("$name:{$str}")
}

fun printRandLinkedList(head: RandomNode?) {
    var cur: RandomNode? = head
    print("order: ")
    while (cur != null) {
        print(cur.value.toString() + " ")
        cur = cur.next
    }
    println()
    cur = head
    print("rand:  ")
    while (cur != null) {
        print(if (cur.rand == null) "- " else cur.rand!!.value.toString() + " ")
        cur = cur.next
    }
    println()
}

fun copyLinkList(head: RandomNode): RandomNode {
    var cur: RandomNode? = head
    var next: RandomNode? = null

    while (cur != null) {
        next = cur.next
        cur.next = RandomNode(cur!!.value)
        cur.next!!.next = next
        cur = next
    }

    cur = head
    var curCopy: RandomNode? = null
    // set copy node rand
    // 1 -> 1' -> 2 -> 2'
    while (cur != null) {
        // cur 老
        // cur.next  新 copy
        next = cur.next!!.next
        curCopy = cur.next
        curCopy?.rand = if (cur.rand != null) cur.rand!!.next else null
        cur = next
    }

    var res = head.next
    cur = head

    // split
    while (cur != null) {
        next = cur.next!!.next
        curCopy = cur.next
        cur.next = next
        curCopy!!.next = next?.next
        cur = next
    }

    head.nullPrint("head")
    return res!!
}

fun main() {
    val head = RandomNode(1)
    head.next = RandomNode(2)
    head.next!!.next = RandomNode(3)
    head.next!!.next!!.next = RandomNode(4)
    head.next!!.next!!.next!!.next = RandomNode(5)
    head.next!!.next!!.next!!.next!!.next = RandomNode(6)

    head.rand = head.next!!.next!!.next!!.next?.next // 1 -> 6

    head.next!!.rand = head.next!!.next!!.next!!.next!!.next // 2 -> 6

    head.next!!.next?.rand = head.next!!.next?.next?.next // 3 -> 5

    head.next!!.next?.next?.rand = head.next!!.next // 4 -> 3

    head.next!!.next?.next?.next?.rand = null // 5 -> null

    head.next!!.next?.next?.next?.next?.rand = head.next!!.next?.next // 6 -> 4

    printRandLinkedList(head)

    val res = copyLinkList(head)
    printRandLinkedList(res)

}