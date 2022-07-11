package boj

import java.lang.Integer.max

fun main() {
    val (N, K) = readln().split(" ").map{it.toInt()}

    val dp = Array<IntArray>(K+1){IntArray(N+1)}
    val things = Array<Pair<Int, Int>>(N+1){Pair(0, 0)}
    for (i in 1..N) {
        val (w, v) = readln().split(" ").map{it.toInt()}
        things[i] = Pair(w, v)
    }

    for (i in 1..K) {
        for (j in 1..N) {
            dp[i][j] =
                if (things[j].first > i)
                    dp[i][j-1]
                else
                    max(dp[i-things[j].first][j-1] + things[j].second, dp[i][j-1])
        }
    }
    println(dp[K][N])
}