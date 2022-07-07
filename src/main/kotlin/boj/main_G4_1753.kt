package boj

import java.util.PriorityQueue

fun main() {
    val (V, E) = readLine()!!.split(" ").map { it.toInt() }
    val start = readLine()!!.toInt()
    val adList = Array<ArrayList<Node>>(V+1){ArrayList<Node>()}
    val dist = IntArray(V+1)
    val queue = PriorityQueue<Node>()
    repeat(E) {
        val (u, v, w) = readLine()!!.split(" ").map { it.toInt() }
        adList[u].add(Node(v, w))
    }

    dist.fill(Int.MAX_VALUE)
    dist[start] = 0
    queue.add(Node(start, dist[start]))

    while (queue.isNotEmpty()){
        val (curIndex, curDist) = queue.poll()

        if (dist[curIndex] < curDist)
            continue
        for (n in adList[curIndex]) {
            val nextIndex = n.index
            val nextDist = curDist + n.dist

            if (nextDist < dist[nextIndex]){
                dist[nextIndex] = nextDist
                queue.add(Node(nextIndex, nextDist))
            }
        }
    }

    for (i in 1..V) {
        if (dist[i] == Int.MAX_VALUE) {
            println("INF")
        } else {
            println(dist[i])
        }

    }
}

data class Node(val index:Int, val dist:Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.dist - other.dist
}