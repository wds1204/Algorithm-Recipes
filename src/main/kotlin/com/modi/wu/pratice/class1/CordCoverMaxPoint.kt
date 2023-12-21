package com.modi.wu.pratice.class1

import java.util.Arrays
import kotlin.math.max


/**
 * 在一个有序数组中，在固定长度范围内能覆盖最多数字个数
 *
 * 例如:[1,2,6,7,8,9,12,17] 长度:6
 *  index=0位置求能选中的最大范围，右边界限right不断++，当[right]-[index]>6,求出范围值max=right-left
 *  index=1位置求能选中的最大范围，右边界限right不断++，当[right]-[index]>6,max=right-left,与上次比较保留最大的
 *  ....
 *
 *  这是一个典型的滑动窗口算法
 *
 */
fun maxPoint(array: IntArray, L: Int): Int {
    var max = 0

    var left = 0
    var right = 0
    val N = array.size

    while (left < N) {
        while (right < N && array[right] - array[left] <= L) {
            right++
        }

        max = max(max, right - left)
        left++
    }

    return max
}

// for test
fun generateArray(len: Int, max: Int): IntArray {
    val ans = IntArray(len)
    for (i in ans.indices) {
        ans[i] = (Math.random() * max).toInt()
    }
    Arrays.sort(ans)
    return ans
}

fun main() {
    val array = generateArray(20, 100)

    println(array.toList())

    val max = maxPoint(array, 7)
    println(max)

    intArrayOf(1, 2, 6, 7, 8, 9, 12, 17).run {
        println(maxPoint(this, 7))
    }

}