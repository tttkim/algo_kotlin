package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.nio.Buffer
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val adList = Array<ArrayList<Int>>(N+1) {ArrayList<Int>()}
    val visited = BooleanArray(N+1)
    val parents = IntArray(N+1)
    repeat(N-1) {
        val (node1, node2) = br.readLine().split(" ").map { it.toInt() }
        adList[node1].add(node2)
        adList[node2].add(node1)
    }

    val queue = ArrayDeque<Int>()
    queue.add(1)
    visited[1] = true
    while (!queue.isEmpty()) {
        val cur = queue.removeFirst()
        visited[cur] = true
        for (node in adList[cur]) {
            if (!visited[node]) {
                queue.add(node)
                parents[node] = cur
            }
        }
    }
    for (i in 2 ..N) {
        bw.write(parents[i].toString())
        bw.newLine()
    }
    bw.flush()
    bw.close()
}