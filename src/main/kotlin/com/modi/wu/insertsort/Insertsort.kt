package com.modi.wu.insertsort

import com.modi.wu.testHelper.SortTestHelper
import com.modi.wu.testHelper.SortTestHelper.printArray


fun main() {
    val array = SortTestHelper.generateRandomArray(100, 0, 100)
    array.printArray()
    val newArray = array.insetSort()
    newArray.printArray()

    val index = mutableListOf(5, 3, 4, 3, 2, 1, 3).findLessIndex()
    println("index-->$index")

    var a = 10
    var b = 11
    a = a xor b
    b = a xor b
    a = a xor b
    println("a = $a\nb = $b")

    findBit1(12)
    countBit1(12)
}

fun <T : Comparable<T>> MutableList<T>.insetSort(): MutableList<T> {
    if (size < 2) return this
    for (i in 1 until size) {
        var j = i - 1
        val temp = get(i)
        val index = this.binarySearch(temp, fromIndex = 0, toIndex = j)
        while (j >= 0 && j >= index) {
            set(j + 1, get(j))
            j--
        }
        set(j + 1, temp)
    }

    return this
}


fun <T : Comparable<T>> List<T>.binarySearch(element: T, fromIndex: Int = 0, toIndex: Int = size - 1): Int {
    var low = fromIndex
    var high = toIndex

    while (low <= high) {
        val mid = low + (high - low shr 1)
        val midVal = get(mid)
        if (midVal > element) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return low
}

/**
 * 一个[0..n-1]无序的数组，且相邻的数不想等，找出任意一个局部最小数。
 * 局部最小：
 * ● 数组arr[0]的位置小于arr[1]，arr[]0是局部最小数。
 * ● arr[n-1]的位置小于arr[n-2]，则arr[n-1]的位置局部最小。
 * ● arr[i-1]>ar[i]<arr[i+1], arr[i]则为局部最小数
 */
fun <T : Comparable<T>> MutableList<T>.findLessIndex(): Int {
    if (size < 2) return 0
    if (get(0) < get(1)) return 0
    if (get(size - 1) < get(size - 2)) return size - 1
    var left = 1
    var right = size - 2
    var mid = 0
    while (left < right) {
        mid = (left + right) / 2
        when {
            get(mid) > get(mid - 1) -> {
                right = mid - 1
            }
            get(mid) > get(mid + 1) -> {
                left = mid + 1
            }
            else -> {
                return mid
            }
        }
    }

    return left
}

/*亦或运算的使用*/
/**
 * 一个二进制数比如10010100，找出最近1的数，比如00000100
 * 10010100 inv
 * 01101011 +1
 * 01101100
 *
 */
fun findBit1(num:Int){
    println(Integer.toBinaryString(num))
    val value=num.and((num.inv()+1))

    println(Integer.toBinaryString(value))
}
/**
 * 统计一个数二进制格式中有个多个1
 */
fun countBit1(num: Int) {
    println(Integer.toBinaryString(num))
    var N=num
    var count=0
    while (N != 0) {
        var value=N.and(N.inv()+1)
        count++
        N=N.xor(value)

    }
    println("count$count")
}