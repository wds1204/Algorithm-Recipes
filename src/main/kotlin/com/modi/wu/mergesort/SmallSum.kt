package com.modi.wu.mergesort


/**
 * 在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。
 * 例如：【1，3，4，2，5】
 * 1的左边是没有
 * 3的左边是1
 * 4的左边是1+3
 * 2的左边是1
 * 5的左边是1、3、4、2
 *
 * 数组的小和=1+1+3+1+1+3+4+2
 *
 *
 */

fun main() {
    val array = intArrayOf(1, 3, 4, 2, 5)
    val res = array.comparator()
    println(res)
    val array1 = intArrayOf(1, 3, 4, 2, 5)
    val res1=array1.smallSum()
    println(res1)
}

//暴力解法
fun IntArray.comparator(): Int {
    var res = 0
    for (i in 1 until size) {
        for (j in 0..i) {
            if (this[j] < this[i]) {
                res += this[j]
            }
        }
    }
    return res
}

/**
 * 归并解法
 * 【1，3，4，2，5】
 * 求数组的小和登记
 *
 * 1的右边有4个数把它大，则有4个1
 * 3的右边有2个数比它大，则有2个3
 * 4的右边有1个数比它大，则有1个4
 * 2的右边有1个数比它大，则有1个2
 * 在每一次归并过程中计算数的小和：累计记录左部分比右部分小的数，
 *
 * 4+2*3+4+2
 */
fun IntArray.smallSum(): Int {

    return process(0,size-1)
}

fun IntArray.process(left: Int, right: Int): Int {
    if (left>=right)return 0
    val mid = left + (right - left).shr(1)

    return process(left, mid) + process(mid + 1, right) + merge(left, mid, right)


}

fun IntArray.merge(left: Int, mid: Int, right: Int): Int {
    var res = 0

    val help = this.copyOfRange(left, right + 1)
    var p1=left
    var p2=mid+1
    var index=left

    while (p1<=mid&&p1<=right){
        if (help[p1-left]<help[p2-left]){
            val value=help[p1-left]
            val num=right-p2+1
            res += value * num
            this[index++]=help[p1-left]
            p1++
        }else{
            this[index++]=help[p2-left]
            p2++
        }
    }
    while (p1<=mid){
        this[index++]=help[p1-left]
        p1++
    }
    while (p2<=mid){
        this[index++]=help[p2-left]
        p2++
    }

    return res
}
