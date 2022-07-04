package boj

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val M = sc.nextInt()
    val visited = BooleanArray(N)
    var result = IntArray(M)
    var input = ArrayList<Int>()

    repeat(N) {
        input.add(sc.nextInt())
    }
    input.sort()
    permutation(0, N, M, visited, result, input)
}

fun permutation(cnt: Int, n: Int, m: Int, visited: BooleanArray, result: IntArray, input: ArrayList<Int>) {
    if (cnt >= m) {
        for (i in result) {
            print("$i ")
        }
        println()
        return
    }

    for (i in 0..n-1){
        if (visited[i])
            continue
        visited[i] = true
        result[cnt] = input[i]
        permutation(cnt+1, n, m, visited, result, input)
        visited[i] = false
    }
}

