package boj

fun main() {
    val (A, B, C) = readln().split(" ").map { it.toLong() }
    val map = HashMap<Long, Long>()
    println(getResult(A, B, C, map))
}

fun getResult(a: Long, b: Long, c: Long, map: HashMap<Long, Long>): Long? {
    when (b) {
        1L -> return a % c
        else -> {
            return if (map.containsKey(b))
                map!![b]
            else {
                val key = getResult(a, b/2, c, map)?.rem(c)
                if (b % 2 == 0L) {
                    map!![b] = (key?.times(key))!!.rem(c)
                } else {
                    map!![b] = (key?.times(key))!!.rem(c)!!.times(a!!.rem(c))!!.rem(c)
                }
                map[b]
            }
        }

    }
}
