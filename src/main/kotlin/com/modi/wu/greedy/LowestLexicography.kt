package com.modi.wu.greedy

/**
 * 给定一个又字符串组成的数组strs,
 * 必须把所有的字符串拼接起来
 * 返回所有可能的拼接结果中，字典序最小的结果
 *
 * 例如[ac,db,ab,ck,kz]
 * 拼接结果中字典序最小的是：abacckdbkz
 *
 */


/**
 * 暴力递归的方法，穷尽各种字符串拼接的可能性，通过比较字典序的大小
 * 1:需要有一个存放拼接后字符的集合
 */
fun Array<String>.lowestString():String{
    if (this.isEmpty())return ""
    val all= mutableListOf<String>()
    val use= hashSetOf<Int>()

    process(this,all,use,"")

    //存放字符串
    var lowest= all[0]
    for (i in 1 until all.size){
        if (all[i] < lowest){
            lowest=all[i]
        }
    }

    return lowest

}

fun process(strs:Array<String>,all:MutableList<String>,use:HashSet<Int>,path:String){

    if (use.size==strs.size){
        all.add(path)
    }else{
        for (i in strs.indices){
            if (!use.contains(i)){
                use.add(i)
                process(strs, all, use, path+strs[i])
                use.remove(i)
            }
        }

    }

}

fun main() {
    val array=arrayOf("ac","db","ab","ck","kz")

    println("array数组中字符拼接最小字典序：${array.lowestString()}")
}