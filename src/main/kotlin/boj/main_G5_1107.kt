package boj

import java.util.Scanner
import kotlin.math.abs

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val M = sc.nextInt()
    val set = HashSet<Int>()
    var minPush = abs(N-100)
    repeat(M) {
        set.add(sc.nextInt())
    }

    for (i in 0..1000000) {
        if (isPushable(i, set)) {
            val localMin = i.toString().length + abs(N-i)
            if (localMin < minPush){
                minPush = localMin
            }
        }
    }

    println(minPush)
}
fun isPushable(num: Int, set: Set<Int>): Boolean {
    val arr = num.toString().toCharArray().map { n -> n-'0' }
    for (n in arr) {
        if (set.contains(n)) {
            return false
        }
    }
    return true
}