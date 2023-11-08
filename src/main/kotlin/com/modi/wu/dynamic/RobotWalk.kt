package com.modi.wu.dynamic

/**
 * 假设有排成一行的N个位置，记为1～N,N一定大于或等于2。
 *  开始是机器人在其中的M位置上（M一定是1～N的一个）
 *  如果机器人来的1位置，那么机器人下一步只能往右移动来2位置；
 *  如果机器人来到N位置，那么机器人下一步只能往左走来到N-1位置；
 *  如果机器人在中间位置，那么机器人可以往走一步也可往有走一步。
 *
 *  现在规定机器人在当前位置M，必须只能走k步，最终能来到P的位置，求一共有多少中走法？

 */


/**
 * [N]:一共N的位置
 * [current]:机器人的当前位置
 * [k]:机器人还能走多数
 * [park]:机器人需要听到的位置
 */
fun walkWay(N: Int, current: Int, k: Int, park: Int): Int {

    if (k == 0) {//k=0时表示机器人已经走完了
        return if (current == park) 1 else 0
    }
    if (current == 1) {//机器人走到1位置，只能右移一个位置
        return walkWay(N, 1, k - 1, park)
    }

    if (current == N) {//机器人走到N位置，只能左移一个位置
        return walkWay(N, N - 1, k - 1, park)
    }

    return walkWay(N, current - 1, k - 1, park) + walkWay(N, current + 1, k - 1, park)
}

/***************************************************************************************/

/**
 * 暴力递归的解法每种路径都尝试一遍，会存在重复递归拆解的情况。
 * 比如一共7个位置，机器人最开始在3位置上，走3步走到4位置；
 * 通过递归的方式。最开始在3位置，有两种情况可走
 *
 * 第一种情况：往左走一步到2位置,到2位置后,【可以往3走】,也可以往1走...
 * 第二种情况：往右走一步到4位置,到4位置后,【可以往3走】,也可以往5走...
 *
 * 分析可的上面两种情况加黑中括号框住步骤，为重复部分。反应到暴力递归中，会重复展开该情况。
 * 避免重复可以通过缓存结果，
 *
 */


fun walkWayCache(
    N: Int,
    current: Int,
    k: Int, park: Int,
    dp: Array<IntArray> = Array(N + 1) {
        IntArray(k + 1) { -1 }
    }
): Int {

    if (k == 0) {//k=0时表示机器人已经走完了
        return if (dp[current][k] != -1) {
            dp[current][k]
        } else {
            if (current == park) 1 else 0
        }

    }
    if (current == 1) {//机器人走到1位置，只能右移一个位置

        dp[current][k] = walkWay(N, 1, k - 1, park)
        return dp[current][k]
    }

    if (current == N) {//机器人走到N位置，只能左移一个位置
        dp[current][k] = walkWayCache(N, N - 1, k - 1, park)
        return dp[current][k]
    }

    return walkWayCache(N, current - 1, k - 1, park) + walkWayCache(N, current + 1, k - 1, park)
}


fun main() {
    val walkSize = walkWay(7, 3, 3, 4)
    println(walkSize)
}