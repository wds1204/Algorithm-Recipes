package com.modi.wu.pratice.class1

fun main() {
    val parentheses = "(())("

    if (!parentheses.isValidParentheses()) {
        println("need ${parentheses.needParenthesesCount()} parentheses ")
    }
}

/**
 * 判断一个括号字符串是否有效
 * "(())("
 * 括号字符串遇到'('计数加一，遇到‘)’计数减一
 * 如果在统计过程中计数小于0直接括号字符串直接无效
 * 如果最后的结果大于0无效，等于0则为有效括号字符串
 */
fun String.isValidParentheses(): Boolean {
    val arr = this.toCharArray()
    var count = 0
    for (i in arr.indices) {
        count += if (arr[i] == '(') 1 else -1
        if (count < 0) return false

    }
    return count == 0

}

fun String.needParenthesesCount(): Int {
    val arr = this.toCharArray()
    var count = 0
    var need = 0
    for (i in arr.indices) {
        if (arr[i] == '(') {
            count++
        } else {//遇到')'
            if (count == 0) {
                need++
            } else {
                count--
            }
        }

    }
    return count + need
}