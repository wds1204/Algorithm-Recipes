package com.modi.wu.recursion

/**
 * 打印一个字符串的全部排列
 *
 *一个字符串的全部排列是指将字符串中的字符重新排列，形成所有可能的不同顺序的字符串。每个字符在排列中只能出现一次。
 * 换句话说，如果有一个字符串 "abc"，那么它的全部排列包括 "abc"、"acb"、"bac"、"bca"、"cab" 和 "cba"。
 *
 *
 */


fun printPermutations(s: String, index: Int = 0) {
    if (index == s.length - 1) {
        println(s)
        return
    }
    for (i in index until s.length){
        val charArray=s.toCharArray()
        charArray[index]=s[i].also {
            charArray[i]=s[index]
        }
        printPermutations(String(charArray),index+1)
    }
}

fun main() {
    printPermutations("abc")
}