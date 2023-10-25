package com.modi.wu.heap

import com.modi.wu.testHelper.SortTestHelper
import com.modi.wu.testHelper.swap

fun main() {
    val array = SortTestHelper.generateArray(10, 0, 100).apply {
        println("排序前：${ this.toList()}")
        heapSort()
        println("排序后：${ this.toList()}")

    }

}

/**
 * 堆结构
 * i位置的父节点：(i-1)/2
 * i位置的左子节点：2*1+1
 * i位置的右子节点：2*i+2
 *
 *
 */
fun IntArray.heapSort() {
    if (this.size < 2) return
    //1.生产一个大根堆,最大的数在第0个位置
//    for (i in 0 until this.size) {
//        heapInsert(i)
//    }
    // O(N*logN)

    for (i in this.indices.reversed()) {
        heapIfy( i, this.size)
    }
    var headSize = this.size
    //2.首位互换
    swap(0, --headSize)
    //3:把末尾换过来的数下沉
    while (headSize > 0) {
        this.heapIfy(0, headSize)
        swap(0, --headSize)//再次首位互换
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
        largest=if (get(largest)>get(index))largest else index

        if (largest==index)break//跳出while循环
        swap(index,largest)
        //互换位置
        index=lastIndex
        left=index*2+1//找到下个左位置继续
    }

}