package boj

fun main() {
    val N = readln().toInt()
    val arr = Array<BooleanArray>(N+1) {BooleanArray(N * 2 + 1)}
    val sb = java.lang.StringBuilder()
    draw(N, N, N*2, arr)

    for (i in 1..N) {
        for (j in 1..N*2) {
            if (arr[i][j])
                sb.append("*")
            else
                sb.append(" ")
        }
        sb.append("\n")
    }
    println(sb.toString())
}

fun draw(n: Int, r: Int, c: Int, arr: Array<BooleanArray>) {
    if (n == 3) {
        arr[r][c-1] = true
        arr[r][c-2] = true
        arr[r][c-3] = true
        arr[r][c-4] = true
        arr[r][c-5] = true
        arr[r-1][c-2] = true
        arr[r-1][c-4] = true
        arr[r-2][c-3] = true
        return
    }

    draw(n/2, r, c, arr)
    draw(n/2, r, c-n, arr)
    draw(n/2, r-n/2, c-n/2, arr)
}


