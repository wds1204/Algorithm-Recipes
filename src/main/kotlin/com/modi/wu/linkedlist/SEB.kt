package com.modi.wu.linkedlist

/**
 *将单向链表按某个值划分成左边小、中间相等、右边大的形式 smaller equal bigger
 *
 * 通过把链表中的值依次放入数组中，然后通过partition过程来做很简单，可参考快排partition的流程，但是空间复杂O(n)
 *
 * 但如果需要优化空间复杂的，有什么好的算法来做呢？
 */


fun Node<Int>.linkPartition(pivot: Int) :Node<Int>{

    var sHead: Node<Int>? = null //small的头
    var sTall: Node<Int>? = null //small的尾

    var eHead: Node<Int>? = null //equal的头
    var eTall: Node<Int>? = null //equal的尾

    var bHead: Node<Int>? = null //bigger的头
    var bTall: Node<Int>? = null //bigger的尾

    var head: Node<Int> ?= this
    var next: Node<Int>? = null
    while (head != null) {
        next = head.next
        head.next = null
        when {
            head.value < pivot -> {
                if (sHead == null) {
                    sHead = head
                    sTall = head
                } else {
                    sTall?.next = head//因为sHead和sTall指向相同的内存地址，经过这步操作sHead.next也指向了head
                    sTall = head
                }
            }
            head.value == pivot -> {
                if (eHead == null) {
                    eHead = head
                    eTall = head
                } else {
                    eTall?.next = head
                    eTall = head
                }
            }
            else -> {
                if (bHead == null) {
                    bHead = head
                    bTall = head
                } else {
                    bTall?.next = head

                    bTall = head
                }

            }
        }
        head = next
    }

    if(sTall!=null){
        sTall.next=eHead
        //有可能等于部分的链表为空
        eTall= eTall ?: sTall
    }
    if (eTall!=null)eTall.next=bHead


   return  sHead?:(eHead?:bHead!!)



}


fun main() {

    val head1 = Node(7)
    head1.next = Node(9)
    head1.next!!.next = Node(1)
    head1.next!!.next!!.next = Node(8)
    head1.next!!.next!!.next!!.next = Node(5)
    head1.next!!.next!!.next!!.next!!.next = Node(2)
    head1.next!!.next!!.next!!.next!!.next!!.next = Node(5)

    head1.nullPrint("原队列")
    head1.linkPartition(5).nullPrint("排序后队列")
}
