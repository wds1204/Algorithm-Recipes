package com.modi.wu.heap

import com.modi.wu.testHelper.SortTestHelper
import java.util.*
import kotlin.math.min

fun main() {
    val intArray=SortTestHelper.randomArrayNoMoveMoreK(100,100,2)

    println(intArray.toList())

   val array= intArray.sortedArrDistanceLessK(2)

    println(array.toList())

}


/**
 * 堆排序算法题：
 * 已知一个几乎有序的数组。几乎有序是指，如果把数组排好序的话，每个元素移动的距离一定不超过K，并且K相对于数组长度来说是比较小的。
 *请选择一个合适的排序策略，对这个数组进行排序：
 */
fun IntArray.sortedArrDistanceLessK(k: Int):IntArray {
    val priorityQueue=PriorityQueue<Int>()
    val array = IntArray(this.size)
    var index=0
    while (index<=(min(this.size - 1, k - 1))){
        priorityQueue.add(this[index++])
    }
    var i=0
    while (index<this.size){
        array[i++]=priorityQueue.poll()
        priorityQueue.add(this[index++])
    }
    while (!priorityQueue.isEmpty()){
        array[i++]=priorityQueue.poll()
    }
    return array
}