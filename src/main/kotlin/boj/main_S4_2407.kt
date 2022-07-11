package boj

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = LongArray(101)
    arr[0] = 1
    arr[1] = 1
    for (i in 2..n) {
        arr[i] = i * arr[i-1]
    }
    println(arr[n] / (arr[n-m] * arr[m]))
}