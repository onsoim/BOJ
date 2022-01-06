import java.io.*
import java.util.*
import kotlin.math.*

fun floyd_warshall(N: Int, arr: Array<Array<Int>>) {
    repeat(N) { i->
        repeat(N) { j->
            repeat(N) { k->
                arr[j][k] = min(arr[j][k], arr[j][i] + arr[i][k])
            }
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val T = readLine()!!.toInt()
    
    repeat(T) {
        val (N, M) = readLine()!!.split(" ").map { it.toInt() }

        val room = Array(N, { Array(N, { 4951 }) })
        repeat(N) { i-> room[i][i] = 0}

        repeat(M) {
            val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
            room[a - 1][b - 1] = c.also { room[b - 1][a - 1] = c}
        }

        floyd_warshall(N, room)

        val K = readLine()!!.toInt()
        val pos = readLine()!!.split(" ").map { it.toInt() - 1 }

        var idx = 0
        var cnt = 0

        pos.forEach { cnt += room[0][it] }
        repeat(N - 1) { i->
            var tmp = 0
            pos.forEach { tmp += room[i + 1][it] }
            if (tmp < cnt) cnt = tmp.also { idx = i + 1 }
        }

        println(idx + 1)
    }
}