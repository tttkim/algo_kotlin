package boj

import java.lang.Integer.max

fun main() {
    val T = readln().toInt()

    repeat(T) {
        val n = readln().toInt()
        val arr = Array<IntArray>(2) { readln().split(" ").map { it.toInt() }.toIntArray()}

        for (i in 1 until n) {
            if (i == 1) {
                arr[0][i] += arr[1][i-1]
                arr[1][i] += arr[0][i-1]
            } else {
                arr[0][i] += max(arr[1][i-1], arr[1][i-2])
                arr[1][i] += max(arr[0][i-1], arr[0][i-2])
            }
        }

        println(max(arr[0][n-1], arr[1][n-1]))

    }
}