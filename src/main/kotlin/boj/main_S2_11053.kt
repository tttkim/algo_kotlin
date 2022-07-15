package boj

fun main() {
    val N = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val dp = Array<IntArray>(N+1){IntArray(N+1) {0} }

    var max = 0
    for (i in 1..N) {
        for (j in i..N) {
            if (arr[j-1] > arr[i-1]) {
                dp[i][j] = dp[i][j-1] + 1
            } else {
                dp[i][j] = dp[i][j-1]
            }
        }
        if (dp[i][N] > max) {
            max = dp[i][N]
        }
    }
    println(max)
}