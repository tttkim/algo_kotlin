package boj

import java.lang.Integer.max

fun main() {
    val s1 = readLine()
    val s2 = readLine()
    val len1 = s1!!.length
    val len2 = s2!!.length
    val dp = Array<IntArray>(len1+1) {IntArray(len2+1)}
    for (r in 1..len1) {
        for (c in 1 .. len2) {
            if (s1[r-1] == s2[c-1]) {
                dp[r][c] = dp[r-1][c-1] + 1
            } else {
                dp[r][c] = max(dp[r-1][c], dp[r][c-1])
            }
        }
    }
    println(dp[len1][len2])
}