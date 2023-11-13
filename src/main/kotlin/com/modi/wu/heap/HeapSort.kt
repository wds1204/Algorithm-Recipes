package com.modi.wu.heap

import com.modi.wu.testHelper.SortTestHelper
import com.modi.wu.testHelper.swap

fun main() {
    val array = intArrayOf(4, 3, 5, 2, 1).apply {
        println("排序前：${this.toList()}")
        heapSort()
        println("排序后：${this.toList()}")

    }

    val arr=SortTestHelper.generateArray(10,1,30).toTypedArray().apply {
        println("排序前：${this.toList()}")
        heapSort()
        println("排序后：${this.toList()}")
    }


}

/**
 * 堆结构
 * i位置的父节点：(i-1)/2
 * i位置的左子节点：2*1+1
 * i位置的右子节点：2*i+2
 *
 *
 * 堆排序的过程：
 * 步骤1: 原数组排序成一个大根堆数组
 * 步骤2: 然后数组头和尾互换位置（此时最大的数在尾部）
 * 步骤3：在数组[0..n-1]范围内再排序成大根堆数组（此时最大的数在尾部）
 * 步骤4: 步骤3结果的数组头和尾互换位置
 * 循环步骤3和4直到数组有序
 *
 */
fun IntArray.heapSort() {
    if (this.size < 2) return

    for (i in this.indices.reversed()) {
        heapIfy(i, this.size)
    }
    println("heapIfy后${this.toList()}  heapSize:${this.size}")
    var headSize = this.size
    //2.首位互换
    swap(0, --headSize)
    println("首位互换后${this.toList()} \n")
    //3:把末尾换过来的数下沉
    while (headSize > 0) {

        this.heapIfy(0, headSize)
        println("heapIfy后${this.toList()}   heapSize:$headSize")
        swap(0, --headSize)//再次首位互换
        println("首位互换后${this.toList()} \n")
    }

}

// arr[index]刚来的数，往上
fun IntArray.heapInsert(index: Int) {
    var i = index
    while (get(i) > get((i - 1) / 2)) {
        swap(i, (i - 1) / 2)
        i = (i - 1) / 2
    }
}

fun IntArray.heapIfy(i: Int, heapSize: Int) {
    var index = i
    var left = index * 2 + 1
    while (left < heapSize) {
        //先找出左右那个更大的位置,如果没有右边直接返回左边

        var largest = if (left + 1 < heapSize && get(left + 1) > get(left)) left + 1 else left
        //在比较当前位置和上一步得到的位置比较
        largest = if (get(largest) > get(index)) largest else index
        if (largest == index) break//如果头节点就是最大值直接跳出while循环/

        swap(largest, index)
        //互换位置
        index = largest
        left = index * 2 + 1//找到下个左位置继续
    }

}


fun Array<Int>.heapSort() {
    if (this.size < 2) return
    var heapSize = this.size
    for (i in this.size - 1 downTo 0) {
        heapIfy(i, heapSize)
    }

    swap(0, heapSize - 1)

    heapSize -= 1

    while (heapSize >=1) {
        heapIfy(0, heapSize)
        swap(0, --heapSize)
    }


}

/**
 * 大的数组往上走
 * 比较头节点、左子节点、右字节点的大小，值大节点来到头节点
 */
fun Array<Int>.heapIfy(idx: Int, heapSize: Int) {
    var index = idx
    var left = index * 2 + 1
    while (left < heapSize) {

        var largestIndex = if ((left + 1) < heapSize && get(left + 1) > get(left)) left + 1 else left

        if (get(index) > get(largestIndex)) {
            largestIndex = index
        }

        if (largestIndex == index) break

        swap(index, largestIndex)

        index = largestIndex

        left = index * 2 + 1
    }

}