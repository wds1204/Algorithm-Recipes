package com.modi.wu.binarytree

import kotlin.math.max

/**
 * 完全二叉树(Complete Binary tree):一种二叉树、除了最后一层，
 * 每层的节点都被从左到右填充，最后一层的节点尽可能靠左排列。
 */

data class CBTInfo(var isFull: Boolean, var isCBT: Boolean, var height: Int)

fun <T> Node<T>?.isCompleteBT(): Boolean {
    if (this == null) return true
    return this.cbtProcess().isCBT
}

fun <T> Node<T>?.cbtProcess(): CBTInfo {
    if (this==null) return CBTInfo(isFull = true, isCBT = true, height = 0)

    val leftInfo=this.left.cbtProcess()
    val rightInfo=this.right.cbtProcess()

    val height= max(leftInfo.height,rightInfo.height)+1

    val isFull=leftInfo.isFull&&rightInfo.isFull&&leftInfo.height==rightInfo.height

    var isCBT=false

    if (isFull){
        isCBT=true
    }else{
        if (leftInfo.isCBT&&rightInfo.isCBT){
            if (leftInfo.isCBT
                && rightInfo.isFull
                && leftInfo.height == rightInfo.height + 1
            ) {
                isCBT = true
            }
            if (leftInfo.isFull
                &&
                rightInfo.isFull
                && leftInfo.height == rightInfo.height + 1
            ) {
                isCBT = true
            }
            if (leftInfo.isFull
                && rightInfo.isCBT && leftInfo.height == rightInfo.height
            ) {
                isCBT = true
            }
        }

    }

    return CBTInfo(isFull,isCBT,height)


}


fun main() {
    val head=generateRandomBST(5,100)
    printTree(head)

    println("head: 是否是完全二叉树${head.isCompleteBT()}")



}