package boj

import java.util.*

fun main(args: Array<String>) {
    var sc : Scanner = Scanner(System.`in`)
    for (tc in 1..sc.nextInt()) {
        val N = sc.nextInt()
        var dp = arrayOfNulls<ULong>(N+6)
        dp[1] = 1u
        dp[2] = 1u
        dp[3] = 1u
        dp[4] = 2u
        dp[5] = 2u
        if (N < 6){
            println(dp[N])
        } else {
            for (i in 6..N) {
                dp[i] = dp[i-2]?.plus(dp[i-3]!!)
            }
            println(dp[N])
        }
    }
}