package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var maxWeight = Int.MIN_VALUE
var maxNode = 0
var V = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    V = st.nextToken().toInt()
    var adList = Array<ArrayList<Pair<Int, Int>>>(V+1){ArrayList()}
    var visited = BooleanArray(V+1)

    repeat(V) {
        st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        while (true) {
            val to = st.nextToken().toInt()
            if (to == -1)
                break
            else {
                val weight = st.nextToken().toInt()
                adList[from].add(Pair(to, weight))
            }
        }
    }

    dfs(1, 0, adList, visited)
    visited = BooleanArray(V+1)
    maxWeight = Int.MIN_VALUE
    dfs(maxNode, 0, adList, visited)
    println(maxWeight)
}

fun dfs(node: Int, weight: Int, adList: Array<ArrayList<Pair<Int, Int>>>, visited: BooleanArray) {
    if (weight > maxWeight) {
        maxNode = node
        maxWeight = weight
    }
    visited[node] = true
    for (next in adList[node]) {
        if (!visited[next.first]) {
            dfs(next.first, weight+next.second, adList, visited)
        }
    }
}

