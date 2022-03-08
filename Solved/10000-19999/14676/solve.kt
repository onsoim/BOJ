import java.io.*
import java.util.*

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M, K) = get(0)
    val depend = Array(N, { arrayListOf<Int>() })
    val flow = Array(N, { arrayListOf<Int>() })
    val build = Array(N, { false })
    val cnt = Array(N, { 0 })

    repeat(M) {
        val (X, Y) = get(1)
        depend[Y] += X
        flow[X] += Y
    }

    repeat(N) { i ->
        if (depend[i].size == 0) build[i] = true
    }

    repeat(K) {
        val (b, a) = get(1)

        when (b) {
            0 -> {
                if (!build[a]) {
                    var flag = true
                    depend[a].forEach {
                        if (cnt[it] < 1) flag = false
                    }
                    build[a] = flag
                }

                if (build[a]) cnt[a]++
                else {
                    println("Lier!")
                    return
                }
            }
            1 -> {
                if (--cnt[a] < 0) {
                    println("Lier!")
                    return
                }
                else if (cnt[a] == 0) {
                    flow[a].forEach { i ->
                        var flag = true
                        depend[i].forEach {
                            if (cnt[it] < 1) flag = false
                        }
                        build[i] = flag
                    }
                }
            }
        }
    }
    println("King-God-Emperor")
}