package com.modi.wu.dynamic

fun main() {

    println("马从左下角，走3步走到(3,2)一共要走:${getHorseSetWays(3, 2, 3)} 步")
    println("马从左下角，走3步走到(3,2)一共要走:${getHorseSetWaysDyn(3, 2, 3)} 步")
}


/**
 * 中国象棋问题：在象棋棋盘的左下角，有只马，需要走到棋盘(x,y)位置，总共走K步,一共有多少种方式走到(x.y)点。
 *
 * 注意：象棋棋盘9列10排，马走日字。
 * 假如马(x,y)位置，根据马走日的规则接下来可以走到一下8个位置:
 * (x+1,y+2)、(x+1,y-2)、(x+2,y+1)、(x+2,y-1)
 * (x-1,y-2)、(x-1,y+2)、(x-2,y-1)、(x-2,y+1)
 *
 * [x]:马当前所在的列的位置，[y]:马当前所在排的位置
 * [k]:还剩余多少步可走
 *
 * 暴力递归的方法
 *
 */
fun getHorseSetWays(x: Int, y: Int, k: Int): Int {
    if (k == 0) {
        return if (x == 0 && y == 0) 1 else 0
    }

    if (x < 0 || x > 8 || y < 0 || y > 9) return 0

    return getHorseSetWays(x + 1, y + 2, k - 1) +
            getHorseSetWays(x + 1, y - 2, k - 1) +
            getHorseSetWays(x + 2, y + 1, k - 1) +
            getHorseSetWays(x + 2, y - 1, k - 1) +
            getHorseSetWays(x - 1, y - 2, k - 1) +
            getHorseSetWays(x - 1, y + 2, k - 1) +
            getHorseSetWays(x - 2, y - 1, k - 1) +
            getHorseSetWays(x - 2, y + 1, k - 1)

}

/**
 * 动态规划的版本
 */
fun getHorseSetWaysDyn(x: Int, y: Int, k: Int): Int {

    val dp: Array<Array<IntArray>> = Array(10) {
        Array(11) {
            IntArray(k + 1) {
                0
            }
        }
    }
    dp[0][0][0] = 1


    for (level in 1..k) {
        for (i in 0..9) {
            for (j in 0..10) {
                dp[i][j][level] = getLevelValue(dp, i + 1, j + 2, level - 1) +
                        getLevelValue(dp, i + 1, j - 2, level - 1) +
                        getLevelValue(dp, i + 2, j + 1, level - 1) +
                        getLevelValue(dp, i + 2, j - 1, level - 1) +
                        getLevelValue(dp, i - 1, j - 2, level - 1) +
                        getLevelValue(dp, i - 1, j + 2, level - 1) +
                        getLevelValue(dp, i - 2, j - 1, level - 1) +
                        getLevelValue(dp, i - 2, j + 1, level - 1)
            }
        }
    }
    return dp[x][y][k]
}

fun getLevelValue(dp: Array<Array<IntArray>>, x: Int, y: Int, k: Int): Int {

    if (x < 0 || x > 8 || y < 0 || y > 9) return 0

    return dp[x][y][k]
}
