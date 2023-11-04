package com.modi.wu.recursion

/**
 * 汉诺塔问题是一个经典的数学问题和递归问题，其规则如下：

 * 1. 有三根柱子，分别为A、B、C，以及一些盘子，这些盘子从小到大按顺序叠放在柱子A上。
 * 2. 目标是将所有的盘子从柱子A移动到柱子C，通过柱子B作为辅助。
 * 3. 一次只能移动一个盘子。
 * 4. 在移动过程中，任何时刻大盘子不能放在小盘子上面。
 *
 * 汉诺塔问题的解决方案采用递归的思想。具体步骤如下：
 *
 * 1. 将n-1个盘子从柱子A通过柱子C移动到柱子B（利用C作为辅助）。
 * 2. 将第n个盘子从柱子A移动到柱子C。
 * 3. 将n-1个盘子从柱子B通过柱子A移动到柱子C（利用A作为辅助）。
 * 这个过程一直递归下去，直到只剩下一个盘子时，直接将它从柱子A移动到柱子C。
 *
 * 递归解决汉诺塔问题的思想是将大问题分解为小问题，然后递归地解决小问题。在每一步递归中，都要明确当前的操作和递归调用的对象。这样，通过不断解决规模较小的子问题，最终达到解决原始问题的目的。
 */

fun hanoi1(n: Int) {
    leftToRight(n)
}

fun leftToRight(n: Int) {
    if (n == 1) {
        println("Move 1 from left to right")
        return
    }
    leftToMid(n - 1)
    println("Move $n from left to right")
    midToRight(n - 1)

}

fun leftToMid(n: Int) {
    if (n == 1) {
        println("Move 1 from left to mid")
        return
    }

    leftToRight(n - 1)
    println("Move $n from left to mid")
    rightToMid(n - 1)
}

fun midToRight(n: Int) {
    if (n == 1) {
        println("Move 1 from mid to right")
        return
    }
    midToLeft(n - 1)
    println("Move $n form mid to right")
    leftToRight(n - 1)
}

fun midToLeft(n: Int) {
    if (n == 1) {
        println("Move 1 from mid to left")
        return
    }

    midToRight(n - 1)
    println("Move $n from mid to left")
    leftToRight(n - 1)

}

fun rightToMid(n: Int) {
    if (n == 1) {
        println("Move 1 from right to mid")
        return
    }
    rightToLeft(n - 1)
    println("Move $n from right to mid")
    leftToMid(n - 1)

}

fun rightToLeft(n: Int) {
    if (n == 1) {
        println("Move 1 from right to left")
        return
    }
    rightToMid(n - 1)
    println("Move $n from right to left")
    midToLeft(n - 1)
}


fun hanoi2(n: Int) {
    moveFun(n, "left", "right", "mid")
}

fun moveFun(n: Int, from: String, to: String, other: String) {
    if (n == 1) {
        println("move 1 form $from to $to")
        return
    }
    moveFun(n - 1, from, other, to)
    println("move $n from $from to $to")
    moveFun(n - 1, other, to, from)

}


fun main() {
    println("#".repeat(30))
    hanoi1(3)
    println("#".repeat(30))
    hanoi2(3)

}


