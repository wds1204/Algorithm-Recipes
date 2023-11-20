package com.modi.wu.slidewindow

import java.util.LinkedList

/**
 * 设置一个固定大小的窗口，依次划过array数组,
 * 返回每一次滑出状况的最大值。
 *
 * 例如array=[4,3,5,4,3,3,6,7] w=3
 * 返回: [5,5,5,4,6,7]
 */
fun getMaxWindow(array: IntArray, w: Int): IntArray {
    if (w < 1 || array.size < w) {
        return emptyArray<Int>().toIntArray();
    }
    val res = IntArray(array.size - w + 1)
    var index=0

    val max = LinkedList<Int>()
    for (right in array.indices){

        while (!max.isEmpty()&&max.peekLast()>array[right]){
            max.pollLast()
        }
        max.addLast(right)
        if (max.peekFirst()==right-w){
            max.pollFirst()
        }
        if (right>w-1){
            res[index++]=array[max.peekFirst()]
        }
    }


    return res
}