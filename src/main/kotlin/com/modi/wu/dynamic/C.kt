package com.modi.wu.dynamic


/**
 * 在一个数组中有N中不同的面值的货币，取数组中的货币，每种货币使用的数量不限，组成M价格的金额。
 *
 * 比如从[50,10,20,5]选取不同的面值的货币，组成100的金额
 *
 * 这个问题递归的思路：
 *
 * 取0位置1张50面值 +  f(1..N)
 * 取0位置2张50面值 +  f(1..N)
 *
 * 取1位置1张10面值 +  f(2..N)
 * 取1位置2张10面值 +  f(2..N)
 *          .
 * 取1位置10张10面值 +  f(2..N)
 *
 * 在相加的金额<= 一直这么往下递归
 *
 *
 *
 */
/**
 * 暴力递归的方法
 */
fun coinsWay(arr: IntArray, aim: Int, index: Int = 0): Int {

    if (aim < 0) return 0
    if (index == arr.size) {
        return if (aim == 0) 1 else 0
    }
    var sheet = 0
    var ways = 0
    while (sheet * arr[index] <= aim) {
        ways += coinsWay(arr, aim - sheet * arr[index], index + 1)
        sheet++
    }

    return ways
}

/************************************************************************************/
/**
 *  记忆化搜索的方法，通过一个结构化的容器缓存数据，如果通过[index]与[aim]的所以在容器中能找到值直接返回结果.
 *  在首次递归中在容器存放计算的值
 *
 */
fun coinsWayCache(
    arr: IntArray, aim: Int, index: Int = 0,
    dp: Array<IntArray> = Array(arr.size) { IntArray(aim + 1) { -1 } }
): Int {

    if (dp[index][aim] != -1) return dp[index][aim]

    if (index == arr.size) {
        dp[index][aim] = if (aim == 0) 1 else 0
        return dp[index][aim]

    }
    var sheet = 0
    var ways = 0
    while (sheet * arr[index] <= aim) {
        ways += coinsWay(arr, aim - sheet * arr[index], index + 1)
        sheet++
    }
    dp[index][aim] = ways
    return ways
}


/************************************************************************************/
/**
 *  动态规划方法，
 *  通过分析递归的过程：
 *
 */
fun coinsWayDynamic(
    arr: IntArray, aim: Int,
    dp: Array<IntArray> = Array(arr.size + 1) { IntArray(aim + 1) { 0 } }
): Int {
    //初始化值
    val n = arr.size
    dp[n][0] = 1
    for (i in n - 1 downTo 0) {
        for (rest in 0..aim) {
            var ways = 0
            var sheets = 0
            while (sheets * arr[i] <= rest) {
                ways += dp[i + 1][rest - sheets * arr[i]]
                sheets++
            }
            dp[i][rest] = ways
        }
    }
    return dp[0][aim]
}


fun main() {
    val array = intArrayOf(50, 10, 20, 5)
    println("暴力递归计算结果：${coinsWay(array, 100)}")
    println("记忆化搜索计算结果：${coinsWayCache(array, 100)}")
    println("动态规划计算结果：${coinsWayDynamic(array, 100)}")


}