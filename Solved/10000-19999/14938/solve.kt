import java.io.*
import java.util.*
import kotlin.math.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m, r) = readLine()!!.split(" ").map { it.toInt() }
    val items = readLine()!!.split(" ").map { it.toInt() }

    val field = Array(n, { Array(n, { 1501 }) })
    repeat(n) { i -> field[i][i] = 0 }

    repeat(r) {
        val (a, b, l) = readLine()!!.split(" ").map { it.toInt() }
        field[a - 1][b - 1] = l.also { field[b - 1][a - 1] = l }
    }

    repeat(n) { i->
        repeat(n) { j->
            repeat(n) { k->
                field[j][k] = min(field[j][k], field[j][i] + field[i][k])
            }
        }
    }

    var cnt = 0
    repeat(n) { i->
        var tmp = 0
        repeat(n) { j-> if (field[i][j] <= m) tmp += items[j] }
        cnt = max(tmp, cnt)
    }
    println(cnt)
}