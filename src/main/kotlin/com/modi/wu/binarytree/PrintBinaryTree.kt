package com.modi.wu.binarytree

fun <T>printTree(head: Node<T>?) {
    println("Binary Tree:")
    printInOrder(head, 0, "H", 17)
    println()
}

fun <T>printInOrder(head: Node<T>?, height: Int, to: String, len: Int) {
    if (head == null) {
        return
    }
    printInOrder(head.right, height + 1, "v", len)
    var `val` = to + head.value + to
    val lenM = `val`.length
    val lenL = (len - lenM) / 2
    val lenR = len - lenM - lenL
    `val` = getSpace(lenL) + `val` + getSpace(lenR)
    println(getSpace(height * len) + `val`)
    printInOrder(head.left, height + 1, "^", len)
}

fun getSpace(num: Int): String {
    val space = " "
    val buf = StringBuffer("")
    for (i in 0 until num) {
        buf.append(space)
    }
    return buf.toString()
}