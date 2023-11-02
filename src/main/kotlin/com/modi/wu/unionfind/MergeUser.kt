package com.modi.wu.unionfind

/**
 * user对象有三个字段a,b,c
 * 两个user对象，如果a字段一样、或者b字段一样、或者c字段一样，就认为是同一个user
 * 现在有若干个user，请合并这些users，返回合并之后user的数量
 */
data class User(var a: String, var b: String, var c: String)


fun mergeUsers(users: List<User>): Int {
    val unionSet = UnionSet(users)

    val aMap = hashMapOf<String, User>()
    val bMap = hashMapOf<String, User>()
    val cMap = hashMapOf<String, User>()

    users.forEach { user ->
        if (aMap.containsKey(user.a)) {
            unionSet.union(user, aMap[user.a]!!)
        } else {
            aMap[user.a] = user
        }
        if (bMap.containsKey(user.b)) {
            unionSet.union(user, bMap[user.b]!!)
        } else {
            bMap[user.b] = user
        }
        if (cMap.containsKey(user.c)) {
            unionSet.union(user, cMap[user.c]!!)
        } else {
            cMap[user.c] = user
        }
    }

    return unionSet.getNodeSize()
}