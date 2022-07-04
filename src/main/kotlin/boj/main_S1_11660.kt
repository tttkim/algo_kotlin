package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val map = Array<Array<Int>>(N){
            st = StringTokenizer(br.readLine())
            Array<Int>(N){st.nextToken().toInt()}
        }

    val sumMap = Array<IntArray>(N) {IntArray(N)}
    for (i in 0..N-1) {
        for (j in 0..N-1) {
            if (i == 0 && j == 0) {
                sumMap[i][j] = map[i][j]
            } else if (i == 0) {
                sumMap[i][j] = sumMap[i][j-1] + map[i][j]
            } else if (j == 0) {
                sumMap[i][j] = sumMap[i-1][j] + map[i][j]
            } else {
                sumMap[i][j] = sumMap[i-1][j] + sumMap[i][j-1] + map[i][j] - sumMap[i-1][j-1]
            }
        }
    }

    repeat(M) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map{it.toInt()}
        var answer = 0
        if (x1 == 1 && y1 == 1){
            answer = sumMap[x2-1][y2-1]
        } else if (x1 == 1){
            answer = sumMap[x2-1][y2-1] - sumMap[x2-1][y1-2]
        } else if (y1 == 1) {
            answer = sumMap[x2-1][y2-1] - sumMap[x1-2][y2-1]
        } else {
            answer = sumMap[x2-1][y2-1] - sumMap[x2-1][y1-2] - sumMap[x1-2][y2-1] + sumMap[x1-2][y1-2]
        }
        println(answer)
    }
}