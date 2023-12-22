package com.modi.wu.pratice.class1

import kotlin.math.min

fun main() {
    println(minPaint("GGGGGR"))
    println(minPaint("RGRGGGR"))
}

/**
 * RGRGGGR 可以把字符串中R变成G也可以G变成R，最终使最后的字符串每个R距左边距离比所有的G到左边的距离小，
 * 如果操作最小的步骤达成效果
 *
 * 原始字符串：RGRGGGR
 * - 得到GGGGGGG 改变0个G，3个R
 * - 得到RGGGGGG 改变0个G，2个R
 * - 得到RRGGGGG 改变1个G，2个R
 * - 得到RRRGGGG 改变1个G，1个R
 * - 得到RRRRGGG 改变2个G，1个R
 * - 得到RRRRRGG 改变3个G，1个R
 * - 得到RRRRRRG 改变4个G，1个R
 * - 得到RRRRRRR 改变4个G，0个R
 * 转化一下思路，用来存储数组中i位置的右边多少个R
 * 我们如下数组[3,2,2,1,1,1,1]
 *
 *
 */
fun minPaint(s: String): Int {
    if (s.length < 2) return 0
    val arr = s.toCharArray()
    val size = arr.size
    var res = Int.MAX_VALUE
    val rigthR = IntArray(size) {
        0
    }
    for (i in arr.indices.reversed()) {
        if (arr[i] == 'R') {
            rigthR[i] = (if (i < (size - 1)) rigthR[i + 1] else 0) + 1
        } else {
            rigthR[i] = (if (i < (size - 1)) rigthR[i + 1] else 0)
        }
    }
    var left = 0
    var right = 0
    for (i in arr.indices) {
        left += if (arr[i] == 'G') 1 else 0
        right = rigthR[i] - if (arr[i] == 'R') 1 else 0
        res = min(res, left + right)
    }
    //最后一种情况全部都是G..G
    res = min(res, rigthR[0])
    return res
}