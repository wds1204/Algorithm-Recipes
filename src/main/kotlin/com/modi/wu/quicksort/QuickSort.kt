package com.modi.wu.quicksort

import com.modi.wu.testHelper.swap

fun main() {

    var array1 = intArrayOf(12, 3, 4, 9, 6, 7, 1, 0, 5, 6)
    array1.quickSort()
    println(array1.toList())
    array1.quickSort()
    println(array1.toList())

//    var array = intArrayOf(12, 3, 4, 9, 6,7, 1, 0, 5, 6)
//    array.partitionArray(6)
//    println("array--${array1.toList()}")
//    array1.quickSort()
//    println("排序后：${array1.toList()}")


}

fun IntArray.quickSort() {
    if (this.size < 2) return
    process(0, this.size - 1)
}

fun IntArray.process(left: Int, right: Int) {
    if (left >= right) return

    val (l, r) = partition(left, right)

    process(left, l)
    process(r, right)

}

fun IntArray.partition(left: Int, right: Int): Pair<Int, Int> {
    val pivot = this[right]//选择基准元素
    /*定义小于基准元素区域的右边界和大于基准元素区域的左边界*/
    var low = left-1
    var high = right+1

    //定义当前考察元素的指针
    var index = left

    while (index < high) {
        when {
            this[index] < pivot -> {
                swap(index, ++low)
                index++
            }
            this[index] == pivot -> {
                index++
            }
            else -> {
                swap(index, --high)
            }
        }
    }
    return (low to high ).apply {
    }

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
