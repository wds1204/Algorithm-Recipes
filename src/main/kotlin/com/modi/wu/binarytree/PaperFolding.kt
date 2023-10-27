package com.modi.wu.binarytree

/**
 *清把一段纸条竖着放在桌子上，然后从字条的下边向上方对折1次，压出折痕后展开。此时折痕是凹下去的，即折痕突起的方向指向纸条的背面。
 * 如果从纸条的下面向上连续对折2次，压出折横后展开，此时有三条折痕，从上到下依次是下折痕、下折痕和上折痕。
 *
 * 给定一个输入参数N，代表纸条都从下边向上放连续对折N次，请从上到下打印所有折痕的方向
 *
 * 例如：N=1时，打印：down N=2时，打印：down down up
 */


/**
 *  解题思路：第一次对折得到down，第二次对折由原来的down有生成了down、up,第三次对折从第二次对结果down->down up  up->down up
 *  数据结构敏感的画能想到这是二叉树
 *
 *
 *             down
 *        down      up
 *     down   up  down   up
 *
 * [num]:表示折多少此
 */
fun printAllFolder(num: Int) {
    process(1, num, true)
}

fun process(index: Int, num: Int, down: Boolean) {
    if (index > num) return

    process(index+1,num,true)
   val result=if (down)
        "down"
    else
        "up"

    print("$result ")
    process(index+1,num,false)

}


fun main() {

    printAllFolder(4)

}