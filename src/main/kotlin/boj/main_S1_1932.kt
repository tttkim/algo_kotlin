package boj

import java.lang.Integer.max

fun main() {
    val n = readln().toInt()
    val arr = ArrayList<ArrayList<Int>>()

    repeat(n) {
        arr.add(ArrayList(readln().split(" ").map { it.toInt() }))
    }

    for (i in 1 until n) {
        for (j in 0 until arr[i].size) {
            if (j == 0) {
                arr[i][j] += arr[i-1][j]
            } else if (j == arr[i].size - 1) {
                arr[i][j] += arr[i-1][j-1]
            } else {
                arr[i][j] += max(arr[i-1][j], arr[i-1][j-1])
            }
        }
    }

    var max = 0
    for (v in arr[n-1]) {
        if (v > max)
            max = v
    }

    println(max)
}