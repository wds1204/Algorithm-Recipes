package com.modi.wu.mergesort

import com.modi.wu.testHelper.SortTestHelper.printArray

//该视频主要讲述了如何通过递归将一个无序的数列变有序，采用了左右两部分分别调用递归函数，再将两部分有序数列merge的方法。
// 对于长度小于等于2的有序数列，可以直接认为有序。对于最后剩下的数，如果个数小于等于n，
// 则无需排序，直接认为有序。此外，该视频还讲述了归并排序的merge方法，分析其时间复杂度，
// 以及在归并排序过程中如何进行数列的合并和排序，产生小和的逻辑和代码实现。
// 同时举例说明了如何使用归并排序解决问题。
fun main() {
    val array = arrayOf(31, 2, 10, 6, 121, 7, 0,11)
    array.mergeSort()
    array.toList().printArray()
}

/**
 * 归并排序
 */
fun <T : Comparable<T>> Array<T>.mergeSort() {
    process(0, size - 1)
}

fun <T : Comparable<T>> Array<T>.process(left: Int, right: Int) {
    if (left == right) return
    val mid: Int = left + (right - left shr 1)
    process(left, mid)
    process(mid + 1, right)
    merge(left, mid, right)
}

fun <T : Comparable<T>> Array<T>.merge(left: Int, mid: Int, right: Int) {

    val help = this.copyOfRange(left, right + 1)
    var p = left
    var q = mid + 1
    var index = left

    while (p <= mid && q <= right) {
        if (help[p - left] < help[q - left]) {
            this[index++] = help[p - left]
            p++
        } else {
            this[index++] = help[q - left]
            q++
        }
    }
    while (p <= mid) {
        this[index++] = help[p-left]
        p++
    }
    while (q <= right) {
        this[index++] = help[q-left]
        q++
    }

}
