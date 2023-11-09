package com.modi.wu.recursion

import kotlin.math.max

/**
 *    给定两个长度都为N的数组：weights和values
 *    weights[i]和values[i]分别代表i号物品的重量和价值.
 *    给定一个正数bag，表示一个载重bag的袋子，你装的物品不能超过这个重量。
 *    返回你能装下做多的价值是多少
 *
 *
 */


fun getMaxValue(weights: IntArray, values: IntArray, bag: Int): Int {
    return process(
        weights,
        values,
        0,
        0,
        bag,
    )
}

/**
 * 可以很明确可能行就是选或则不选。然后取这两种可能性的最大值value
 *
 * 方式：
 * [allWeights]:表示[0..index]范围内所有袋子中所装的重量,
 * 对于[index]位置有两种可能装袋或不装袋子
 * @return [process]方法返回-1表示方案不成立
 */
fun process(weights: IntArray, values: IntArray, index: Int, allWeights: Int, bag: Int): Int {

    if (allWeights > bag) return -1

    if (index == weights.size) return 0//后面没有价值了

    val p1 = process(weights, values, index + 1, allWeights, bag)
    val p2Next = process(weights, values, index + 1, allWeights + weights[index], bag)

    var p2 = -1
    if (p2Next != -1) {
        p2 = p2Next + values[index]
    }

    return max(p1, p2)
}

/******************************************************************/

fun getMaxValue1(weights: IntArray, values: IntArray, bag: Int): Int {
    return process1(weights, values, 0, bag)

}

fun process1(weights: IntArray, values: IntArray, index: Int, reset: Int): Int {
    if (reset < 0) return -1
    if (index == weights.size) return 0

    val p1=process1(weights, values, index+1, reset)
    var p2Next=process1(weights, values, index+1, reset-weights[index])
    var p2 = -1
    if (p2Next != -1) {
        p2 = values[index] + p2Next
    }
    return max(p1, p2)
}

fun main() {

    val weights = intArrayOf(3, 2, 4, 7)
    val values = intArrayOf(5, 6, 3, 19)
    val bag = 11

    println("#".repeat(30))
    val value1 = getMaxValue(weights, values, bag)
    println("#".repeat(30))


}