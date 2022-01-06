import java.io.*
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
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val computer = Array(N, { Array(N, { 2000001 }) })
    repeat(N) { i-> computer[i][i] = 0}
    
    repeat(M) {
        val (A, B, C) = readLine()!!.split(" ").map { it.toInt() }
        computer[A - 1][B - 1] = C.also { computer[B - 1][A - 1] = C }
    }

    floyd_warshall(N, computer)

    var idx = 0
    var cnt = computer[0].sum()

    repeat(N - 1) { i->
        var tmp = computer[i + 1].sum()
        if (tmp < cnt) cnt = tmp.also { idx = i + 1 }
    }

    println(idx + 1)
}