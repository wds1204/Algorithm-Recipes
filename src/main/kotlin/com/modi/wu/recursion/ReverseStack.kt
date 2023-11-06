package com.modi.wu.recursion

import java.util.*

/**
 * 给你一个栈，请你逆序这个栈
 * 不能申请额外的数据结构
 * 只能使用递归函数，如何实现
 */

fun <T> Stack<T>.reverse() {

    if (this.isEmpty()) return
    val result=this.popBt()
    reverse()
    this.push(result)


}

/**
 * [popBt]方法是返回Stack最先进入的值弹出返回，并stack保留其它值
 */
fun <T> Stack<T>.popBt(): T {
    if (this.size <= 1) {
        return this.pop()
    }

    val value: T = pop()
    val result = this.popBt()
    this.push(value)
    return result
}

fun f(stack: Stack<Int>): Int {
    val result = stack.pop()
    return if (stack.isEmpty()) {
        result
    } else {
        val last = f(stack)
        stack.push(result)
        last
    }
}


fun main() {

    val stack = Stack<Int>().apply {
        add(1)
        add(12)
        add(123)
        add(1234)
    }
    println("stack--$stack")

    val result = stack.popBt()

    println("result--$result  stack--$stack")


    val stack1 = Stack<Int>().apply {
        add(1)
        add(12)
        add(123)
        add(1234)
    }
    stack1.reverse()


    println("stack--$stack1")


}