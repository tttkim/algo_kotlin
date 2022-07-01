package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    st = StringTokenizer(br.readLine())
    val arr = Array(N) {0}
    for (i in 0..N-1){
        arr[i] = when (i){
            0 -> st.nextToken().toInt()
            else -> st.nextToken().toInt() + arr[i-1]
        }
    }

    repeat(M){
        st = StringTokenizer(br.readLine())
        val start = st.nextToken().toInt() - 2
        val end = st.nextToken().toInt() - 1

        if (start < 0) {
            bw.write(arr[end].toString())
        } else {
            bw.write((arr[end]-arr[start]).toString())
        }
        bw.newLine()
    }
    bw.flush()
    bw.close()

}