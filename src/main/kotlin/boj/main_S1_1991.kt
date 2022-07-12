package boj

fun main() {
    val N = readln().toInt()

    val adList = Array<CharArray>(26) {CharArray(2)}

    repeat(N) {
        val (root, left, right) = readln().split(" ")

        adList[root[0]-'A'][0] = left[0]
        adList[root[0]-'A'][1] = right[0]
    }

    dfs1('A', adList)
    println()
    dfs2('A', adList)
    println()
    dfs3('A', adList)
}

fun dfs1(cur: Char, adList: Array<CharArray>) {
    if (cur == '.')
        return
    print(cur)
    dfs1(adList[cur-'A'][0], adList)
    dfs1(adList[cur-'A'][1], adList)
}

fun dfs2(cur: Char, adList: Array<CharArray>) {
    if (cur == '.')
        return
    dfs2(adList[cur-'A'][0], adList)
    print(cur)
    dfs2(adList[cur-'A'][1], adList)
}

fun dfs3(cur: Char, adList: Array<CharArray>) {
    if (cur == '.')
        return
    dfs3(adList[cur-'A'][0], adList)
    dfs3(adList[cur-'A'][1], adList)
    print(cur)
}
