package com.modi.wu.recursion

import java.lang.Integer.max
import kotlin.math.min

/**
 * 范围上尝试的模型
 *
 * 给定一个整形数组arr，代表数值不同的纸牌排成一条线
 * 玩家A和玩家B依次拿走每张纸牌，
 * 规定玩家A先拿，玩家B后拿
 *
 * 但是规定每个玩家每次只能拿最左或最右的纸牌
 * 玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数
 */


fun getMaxCardLine(cards: IntArray): Int {
    if (cards.size == 1) return cards[0]
    return max(first(cards, 0, cards.size - 1), slow(cards, 0, cards.size - 1))
}

/**
 * 先手拿，
 */
fun first(cards: IntArray, left: Int, right: Int): Int {

    if (left == right) return cards[left]//如果left=right,就剩一张排，直接拿走
    //还有多张排，因为是先手所以结果肯定是考虑自己最好的结果，
    //取left或right，先手那后接下你就变成后手
    return max(
        cards[left] + slow(cards, left + 1, right),//
        cards[right] + slow(cards, left, right - 1)
    )
}

/**
 * 后手
 */
fun slow(cards: IntArray, left: Int, right: Int): Int {
    if (left == right) return 0////如果left=right,就剩一张排，因为是后手拿，所返回0
    //后手拿肯定是对方留给自己最差的结果。
    //被先手拿了left或right，剩下的牌就是你自己先手
    return min(
        first(cards, left + 1, right),
        first(cards, left, right - 1)
    )
}

/*************************************动态规划**********************************************/

fun getMaxCardLine1(cards: IntArray): Int {
    val n = cards.size
    val fDp = Array(n) {
        Array(n) {
            0
        }
    }
    for (i in 0 until n) {
        fDp[i][i] = cards[i]
    }
    val sDp = Array(n) {
        Array(n) {
            0
        }
    }

    for (j in 1 until n) {
        var i=j-1
        while(i>=0){
            fDp[i][j] = max(cards[i] + sDp[i + 1][j], cards[j] + sDp[i][j - 1])
            sDp[i][j] = min(fDp[i + 1][j], fDp[i][j - 1])
            i--
        }

    }



    return max(fDp[0][n - 1], sDp[0][n - 1])
}

fun main() {
    val arr = intArrayOf(4, 7, 9, 5, 19, 29, 80, 4)
    val res = getMaxCardLine(arr)
    println(res)

    val res1 = getMaxCardLine1(arr)
    println(res1)


}