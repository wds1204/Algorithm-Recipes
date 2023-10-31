package com.modi.wu.greedy

import kotlin.math.min

/**
 * 给定一个字符串str,只由X和*两种字符构成
 * X表示墙，不能放灯，也不需要点亮
 * *表示居民点，可以放灯，需要点亮
 * 如果灯放在i的位置，可以让i-1、i和i+1三个位置被点亮
 *
 * 返回如果点亮str中所有的亮点的位置，至少需要几盏灯
 */
fun minLight(strs: Array<String>): Int {
    if (strs.isEmpty()) return 0
    val light = hashSetOf<Int>()
    val all = mutableListOf<List<Int>>()
    process1(all, strs, light, 0)

    strs.forEachIndexed { index, str ->
        if (str != "X") {
            val iterator = all.iterator()
            while (iterator.hasNext()) {
                val it = iterator.next()
                if ((!it.contains(index - 1)) && (!it.contains(index)) && (!it.contains(index + 1))) {
                    iterator.remove()
                }
            }
        }

    }
    return all.minByOrNull { it.size }?.size?:0

}

fun process1(all: MutableList<List<Int>>, strs: Array<String>, light: HashSet<Int>, index: Int) {
    if (index == strs.size) {
        all.add(light.toList())
    } else {
        process1(all, strs, light, index + 1)
        if (strs[index] == "*") {
            light.add(index)
            process1(all, strs, light, index + 1)
            light.remove(index)
        }
    }
}


fun process(all: MutableList<List<Int>>, strs: Array<String>, light: HashSet<Int>, index: Int): Int {
    if (index == strs.size) {
        for (i in strs.indices) {
            if (strs[i] != "X") {
                if (!light.contains(i - 1) && !light.contains(i) && !light.contains(i + 1)) {
                    return Int.MAX_VALUE
                }
            }
        }
        all.add(light.toList())
        return light.size
    } else {
        val no = process(all, strs, light, index + 1)
        var yes = Int.MAX_VALUE
        if (strs[index] == "*") {
            light.add(index)
            yes = process(all, strs, light, index + 1)
            light.remove(index)
        }
        return min(no, yes)
    }
}

/*********************贪心算法***************************/
fun minLightsToLightUp(strs: Array<String>): Int {
    val length = strs.size
    var lights = 0
    var index = 0
    while (index < length) {
        if (strs[index] == "X") {
            index++
        } else {
            lights++
            if (index + 1 >= length) {
                break
            } else {
                if (strs[index + 1] == "X") {
                    index += 2
                } else {
                    index += 3
                }
            }


        }

    }
    return lights

}

fun main() {
    val all = arrayOf("*", "X", "X", "*", "*", "*", "X", "X", "*", "*", "X", "*")

    val size1 = minLight(all)
    val size2 = minLightsToLightUp(all)
    println("size1----${size1}   size2---$size2")
}