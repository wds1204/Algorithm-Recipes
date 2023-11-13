package com.modi.wu.quicksort

import com.modi.wu.testHelper.swap

fun main() {

    val array1 = intArrayOf(12, 3, 4, 9, 6, 7, 1, 0, 5, 6)
    array1.quickSort()
    println(array1.toList())
    array1.quickSort()
    println(array1.toList())

}

/**
 * 快排的思路，从数组取某位个数进行划分，比该值小放左边，等于放中间，大于放右边
 * 核心点就是partition的过程，设置小于区的右边界和大于区的左边界
 * 1:当考察的元素小于基准元素时，当前元素与小于区右边界的值交换，右边界+1，考察元素位置+1
 * 2:当考察的元素等于基准元素时，考察元素位置+1
 * 3:当考察的元素大于基准元素时，当前元素与大于区左边界的值交换，左边界-1，考察元素位置+1
 * 4:直到考察元素位置<=右边界位置
 *
 * 然后在划分好的左边和右边重复该过程
 */
fun IntArray.quickSort( left: Int = 0, right: Int = this.size - 1) {
    if (left >= right) return
    val (l, r) = quickPartition( left, right)
    this.quickSort( left, l)
    this.quickSort( r, right)
}

fun IntArray.quickPartition( left: Int, right: Int): Pair<Int, Int> {
    val p = this[right]//选择基准元素
    /*定义小于基准元素区域的右边界和大于基准元素区域的左边界*/
    var low = left
    var hight = right
    //定义当前考察元素的指针
    var index = left

    while (index <= hight) {
        when {
            this[index] < p -> {
                this.swap(index++, low++)
            }
            this[index] == p -> {
                index++
            }
            else -> {
                this.swap(index, hight--)
            }
        }

    }
    return low - 1 to hight
}



/**
 * 荷兰国旗问题：
 * 给出一个数组，大于num的数再右边，等于num的数在中间，小于num的数在左边
 */
fun IntArray.partitionArray(num: Int) {
    var l = 0
    var r = this.size - 1
    var index = 0
    while (index <= r) {
        when {
            get(index) < num -> {
                swap(index, l)
                index++
                l++
                println("小于--》${this.toList()}  l==$l, r==$r")
            }
            get(index) > num -> {
                swap(index, r)
                r--
                println("大于--》${this.toList()}  l==$l, r==$r")
            }
            else -> {
                index++
                println("等于--》${toList()}  l==$l, r==$r")

            }
        }
    }
}
