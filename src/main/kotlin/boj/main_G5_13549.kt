package boj

import java.util.PriorityQueue

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val dist = IntArray(100001){Int.MAX_VALUE}
    val queue = PriorityQueue<Pair<Int, Int>>() {p1, p2 -> p1.second - p2.second}

    dist[N] = 0
    queue.add(Pair(N, dist[N]))

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        val newPos = arrayOf(cur.first * 2, cur.first + 1, cur.first -1)
        for (i in 0..2) {
            if (newPos[i] < 0 || newPos[i] > 100000)
                continue
            val newDist = if (i == 0)  cur.second  else cur.second+1
            if (dist[newPos[i]] > newDist) {
                dist[newPos[i]] = newDist
                queue.add(Pair(newPos[i], newDist))
            }
            if (newPos[i] == K)
                break
        }

    }
    println(dist[K])
}