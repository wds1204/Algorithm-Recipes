package com.modi.wu.slidewindow

import java.util.LinkedList


fun main() {

}

/**
 * 给定一个整型数组arr,和一个整数num,某个arr中的子数组sub,如果想达标，必须满足：\n sub中最大值-sub中最小值<=num,返回arr中达标子数组的数量
 *
 */
fun getSubNum(array: IntArray, num: Int): Int {
    var res = 0
    val max = LinkedList<Int>()
    val min = LinkedList<Int>()
    var left = 0
    var right = 0

    while (left < array.size) {
        while (right < array.size) {
            while (max.isNotEmpty() && array[max.peekLast()] > array[right]) {
                max.pollLast()
            }
            max[right]
            while (min.isNotEmpty() && array[min.peekLast()] < array[right]) {
                min.pollLast()
            }
            min[right]

            if (array[max.first] - array[min.first] > num) {
                break
            }
            right++
        }
        res += right - left

        if (min.peekFirst() == left) {
            min.pollFirst()
        }
        if (max.peekFirst() == left) {
            max.pollFirst()
        }

        left++
    }


    return res

}