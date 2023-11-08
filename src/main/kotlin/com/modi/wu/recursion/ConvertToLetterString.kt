package com.modi.wu.recursion

/**
 * 固定1和A对应、2和B对应、3和C对应。。。
 * 那么一个数字字符串比如"111"就可以转化为："AAA"或者"KA"和"KA"
 *
 * 给定一个只有数字字符组成的字符串str,返回有多种转化结果
 */


fun convertToStr(str: String, index: Int = 0): Int {

    if (index == str.length) {
        return 1
    }
    if (str[index] == '0') {
        return 0
    }
    if (str[index] == '1') {
        var res = convertToStr(str, index + 1)
        if (index + 1 < str.length) {
            res += convertToStr(str, index + 2)
        }
        return res

    }
    if (str[index] == '2') {
        var res = convertToStr(str, index + 1)
        if (index + 1 < str.length) {
            if (str[index + 1] in '0'..'6') {
                res += convertToStr(str, index + 2)
            }
        }
        return res
    }

    return convertToStr(str, index + 1)
}


fun main() {
   val num= convertToStr("111")

    println("num=$num")
}