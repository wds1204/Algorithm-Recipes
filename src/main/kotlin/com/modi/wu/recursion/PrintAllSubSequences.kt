package com.modi.wu.recursion

/**
 * 打印出字符串中全部子序列
 * 字符串的子序列可以不连续，但是相对次序不能乱（每个字符 要跟不要 所有的路都走一遍）——深度优先遍历
 *
 * 字符串：abc
 * 全部子序列:
 * a、ab、ac、abc
 * b、bc
 * c
 *
 */


fun printSubsequences(s: String, current: String = "", index: Int = 0) {
    // Base case: 当索引达到字符串的末尾时
    if (index == s.length) {
        println(current)
        return
    }

    // 递归情况 1: 包含当前字符
    printSubsequences(s, current + s[index], index + 1)

    // 递归情况 2: 不包含当前字符
    printSubsequences(s, current, index + 1)
}

fun main() {
    val inputString = "abc"
    println("字符串 '$inputString' 的全部子序列:")
    printSubsequences(inputString)
}
