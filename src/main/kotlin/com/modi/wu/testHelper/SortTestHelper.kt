package com.modi.wu.testHelper

import java.util.*
import kotlin.random.Random


object SortTestHelper {

    /**
     * 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
     */
    fun generateRandomArray(n: Int, rangeL: Int, rangeR: Int): MutableList<Int> {
        assert(rangeL <= rangeR)

        val arr = mutableListOf<Int>()
        for (i in 0 until n) arr.add(i, (Math.random() * (rangeR - rangeL + 1) + rangeL).toInt())
        return arr
    }

    fun generateArray(size: Int, from: Int, until: Int): IntArray {

        val arr = IntArray(size)
        for (i in 0 until size) {
            arr[i] = Random.nextInt(from, until)
        }
        return arr
    }

    // 生成一个近乎有序的数组
    // 首先生成一个含有[0...n-1]的完全有序数组, 之后随机交换swapTimes对数据
    // swapTimes定义了数组的无序程度:
    // swapTimes == 0 时, 数组完全有序
    // swapTimes 越大, 数组越趋向于无序
    fun generateNearlyOrderedArray(n: Int, swapTimes: Int): Array<Int?> {
        val arr: Array<Int?> = arrayOfNulls(n)
        for (i in 0 until n) arr[i] = i
        for (i in 0 until swapTimes) {
            val a = (Math.random() * n).toInt()
            val b = (Math.random() * n).toInt()
            val t = arr[a]
            arr[a] = arr[b]
            arr[b] = t
        }
        return arr
    }

    // for test
    fun randomArrayNoMoveMoreK(maxSize: Int, maxValue: Int, K: Int): IntArray {
        val arr = IntArray(((maxSize + 1) * Math.random()).toInt())
        for (i in arr.indices) {
            arr[i] = ((maxValue + 1) * Math.random()).toInt() - (maxValue * Math.random()).toInt()
        }
        // 先排个序
        Arrays.sort(arr)
        // 然后开始随意交换，但是保证每个数距离不超过K
        // swap[i] == true, 表示i位置已经参与过交换
        // swap[i] == false, 表示i位置没有参与过交换
        val isSwap = BooleanArray(arr.size)
        for (i in arr.indices) {
            val j = Math.min(i + (Math.random() * (K + 1)).toInt(), arr.size - 1)
            if (!isSwap[i] && !isSwap[j]) {
                isSwap[i] = true
                isSwap[j] = true
                val tmp = arr[i]
                arr[i] = arr[j]
                arr[j] = tmp
            }
        }
        return arr
    }

    // 打印arr数组的所有内容
    fun List<Int>.printArray() {
        for (i in this.indices) {
            print(get(i))
            print(' ')
        }
        println()
        return
    }

    // 判断arr数组是否有序
    fun isSorted(arr: Array<Comparable<Any>>): Boolean {
        for (i in 0 until arr.size - 1) if (arr[i] > arr[i + 1]) return false
        return true
    }


}

fun IntArray.swap(i: Int, j: Int) {
    val temp = get(i)
    set(i, get(j))
    set(j, temp)

}

fun IntArray.println(isPrint:Boolean=true): String {
    var value = StringBuffer()
    this.forEach {
        value.append(it).append(" ")
    }
    return value.toString().apply {
        if (isPrint) println(this)
    }

}

