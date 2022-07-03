package boj

import java.util.*

var N = 0
var M = 0
fun main() {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    M = sc.nextInt()

    var result = IntArray(M)
    permutation(0, 1, result)
}

fun permutation(cnt: Int, start: Int, result: IntArray) {
    if (cnt >= M){
        for (c in result){
            print(c)
            print(" ")
        }
        print("\n")
        return
    }

    for (n in start..N){
        result[cnt] = n
        permutation(cnt+1, n+1, result)
    }
}

