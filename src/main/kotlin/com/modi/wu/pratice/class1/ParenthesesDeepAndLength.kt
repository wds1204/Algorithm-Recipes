package com.modi.wu.pratice.class1

import kotlin.math.max

fun main() {
    val parentheses = "())(())()()(()())("
    println(maxLength2(parentheses))
}

/**
 * 求一个括号字符串中有效括号字符串的最大长度
 *
 *
 * 例如："())(())()()(()())("这个括号字符串的有效括号字符串是：(())()()(()())，长度为14
 * 其实我们记录每个位置能得到的有效括号字符串的长度
 * str= "( ) ) ( ( ) ) ( ) ( ) ( ( ) ( )  ) ("
 *  dp= [0 2 0 0 0 2 4 0 6 0 8 0 0 2 0 4 14 0]
 *
 *
 *
 *
 * 比如index=N的位置开始，
 * 如果该位置是符号‘(’,那么此位置能得到有效长度为0,
 * 如果该位置是符号‘)’,那我们需要从前面找与‘)’配套的‘(’。
 * 之前我们在数组中保存了0~N-1各个位置的有效长度，找与当前位置‘)’配套的‘(’。
 * - 1.如果保存的数组dp[N-1]=0，这说明N-1就是我们需要找得匹配位置。
 * 如果字符串中N-1位置的字符为‘(’，那么N位置有效长度至少为2。还需要加上保存数组中dp[N-1-1]上的值。
 * - 2.如果保存的数组dp[N-1]!=0，那说明N-1位置的括号已经和其它括号匹配了，需要需要数组中N-1位置的值再减1，就是我们需要与字符串N位置匹配的字符。
 * 如果N-dp[N-1]-1位置的字符为‘(’，那么N位置有效长度至少为2。还需要加上保存数组中dp[N-dp[N-1]-1-1]+dp[N-1]上的值。
 *
 * 分析到这感觉是一道动态规划的题目
 */

fun maxLength2(s: String): Int {
    val arr = s.toCharArray()
    var res = 0
    val dp = IntArray(arr.size) {
        0
    }
    for (i in 1 until arr.size) {
        if (arr[i] == ')') {
            val len = dp[i - 1]
            if (len != 0) {
                if (i - len - 1 >= 0) {
                    if (arr[i - len - 1] == '(') {
                        dp[i] =
                            2 + dp[i - 1] + if ((i - len - 1 - 1) > 0) dp[i - len - 1 - 1] else 0
                    }
                }
            } else {
                if (arr[i - 1] == '(') {
                    dp[i] = 2 + if (i - 1 - 1 > 0) dp[i - 1 - 1] else 0
                }
            }
        }
        res = max(res, dp[i])
    }
    return res

}

/**
 *
 * 精简写法
 */
fun maxLength(s: String): Int {
    val arr = s.toCharArray()
    var res = 0
    val dp = IntArray(arr.size) {
        0
    }

    for (i in 1 until arr.size) {
        if (arr[i] == ')') {
            val pre = i - dp[i - 1] - 1
            if (pre >= 0 && arr[pre] == '(') {
                dp[i] = 2 + dp[i - 1] + if (pre > 0) dp[pre - 1] else 0
            }
        }
        res = max(res, dp[i])
    }
    return res
}