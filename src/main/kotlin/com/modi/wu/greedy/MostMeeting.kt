package com.modi.wu.greedy


data class Meeting(var start: Int, var end: Int)

/**
 * 一些项目要占用一个会议试，会议室不能同时容纳两个项目的宣讲，给你每个项目开始的时间和结束的时间
 * 不来安排宣讲的日程，要求会议室进行的宣讲的场次最多。
 * 安排尽可能多的会议是个典型的贪心算法问题，以下是一种基本的贪心算法思路：
 *
 * 1、首先，对所有的会议按照结束时间进行升序排序
 * 2、选择第一个会议，并将其加入已安排的会议列表
 * 3、从剩下的会议中选择下一个未安排的会议，其开始时间必须晚于或等于当前已安排的会议的结束时间
 * 4、重复步骤3，直到不能再选择会议为止
 */


/**
 * 暴力递归解法
 */
fun allMeetingCombinations(meetings: List<Meeting>): List<List<Meeting>> {
    if (meetings.isEmpty()) return emptyList()

    val combinations = mutableListOf<List<Meeting>>()
    process(combinations, meetings, mutableListOf())

    return combinations
}

fun process(all: MutableList<List<Meeting>>, meetings: List<Meeting>, path: MutableList<Meeting>) {
    if (path.isNotEmpty()&&isValid(path)) {

        all.add(ArrayList(path))
    }
    for (i in meetings.indices) {
        path.add(meetings[i])
        println("meetings--${meetings.take(i) + meetings.drop(i + 1)}")
        println("path--${path}")
        process(all, meetings.take(i) + meetings.drop(i + 1), path)
        path.removeAt(path.size - 1)
    }

}

/**
 * 校验组合是否合规
 *
 */
fun isValid(path: MutableList<Meeting>): Boolean {
    println("isValid---path$path")
    for (i in 0 until path.size) {
        if (i < (path.size - 1) && path[i].end > path[i + 1].start) {
            return false
        }
    }
    return true

}


/********************************贪心算法*************************************/
fun greedyAllMeetingCombinations(meetings: List<Meeting>): Int {

    meetings.sortedWith{o1,o2->
        o1.end-o2.end
    }
    var startLine=0
    var size=0
    meetings.forEach {
        if (it.start>=startLine){
            startLine=it.end
            size++
        }
    }
    return size

}


fun main() {
    val meetings = listOf(Meeting(1, 3), Meeting(2, 4), Meeting(3, 5), Meeting(5, 6))

    val allCombination = allMeetingCombinations(meetings)
    println("allCombination--$allCombination")
    val maxCombination = allCombination.maxByOrNull { it.size }
    println("maxCombination--$maxCombination")

    println("${greedyAllMeetingCombinations(meetings)}")
}