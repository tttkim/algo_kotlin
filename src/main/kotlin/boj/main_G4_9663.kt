package boj

import java.lang.Math.abs

var answer = 0

fun main() {
    val N = readln().toInt()
    val loc = IntArray(N) {0}

    nQueen(0, N, loc)

    println(answer)
}

fun nQueen(cnt: Int, n: Int, loc: IntArray) {
    if (cnt == n) {
        answer++
        return
    }

    for (i in 0 until n) {
        loc[cnt] = i
        if (possible(cnt, loc))
            nQueen(cnt+1, n, loc)
    }
}

fun possible(cnt: Int, loc: IntArray): Boolean {
    for (i in 0 until cnt) {
        if (loc[cnt] == loc[i])
            return false
        else if (abs(cnt - i) == abs(loc[cnt] - loc[i]))
            return false
    }
    return true
}

