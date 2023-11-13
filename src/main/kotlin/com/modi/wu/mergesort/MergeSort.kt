package com.modi.wu.mergesort

// 通过递归将一个无序的数列变有序，采用了左右两部分分别调用递归函数，再将两部分有序数列merge的方法。
// 对于长度小于等于2的有序数列，可以直接认为有序。对于最后剩下的数，如果个数小于等于n，
// 则无需排序，直接认为有序。此外，该视频还讲述了归并排序的merge方法，分析其时间复杂度，
// 以及在归并排序过程中如何进行数列的合并和排序，产生小和的逻辑和代码实现。
// 同时举例说明了如何使用归并排序解决问题。
fun main() {
    val array = arrayOf(31, 2, 10, 6, 121, 7, 0, 11)

    array.mergeSort()
    println(array.toList())

    println(findMiddle(5, 9))
}

fun findMiddle(left: Int, right: Int): Int {
    // 通过无符号右移操作获得中间值
    return left + (right - left).shr(1)
}

/**
 * 归并排序
 *
 *
 */
fun <T : Comparable<T>> Array<T>.mergeSort(left: Int = 0, right: Int = this.size - 1) {
    if (left == right) return
    val mid = left + (right - left).shr(1)
    mergeSort(left = left, right = mid)
    mergeSort(left = mid + 1, right = right)

    merge(left, mid, right)


}

/**
 * 把两个有序的数组合并成一个大的有序的数组
 */
fun <T : Comparable<T>> Array<T>.merge(left: Int, mid: Int, right: Int) {

    val copyArray = this.copyOfRange(left, right + 1)
    var n = left
    var m = mid + 1
    var index = left
    while (n <= mid && m <= right) {
        if (copyArray[n - left] < copyArray[m - left]) {
            this[index++] = copyArray[n - left]
            n++
        } else {
            this[index++] = copyArray[m - left]
            m++
        }
    }

    while (n < mid) {
        this[index++] = copyArray[n - left]
        n++
    }
    while (m < right) {
        this[index++] = copyArray[m - left]
        m++
    }

}


