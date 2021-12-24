import java.io.*
import java.util.*
import kotlin.math.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()

    val cost = Array(n, { _ -> Array(n) { 10000001 } })
    repeat(n) { i -> cost[i][i] = 0 }

    repeat(m) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        cost[a - 1][b - 1] = min(c, cost[a - 1][b - 1])
    }

    // layover
    repeat(n) { i ->
        // start
        repeat(n) { j ->
            // end
            repeat(n) { k ->
                cost[j][k] = min(cost[j][k], cost[j][i] + cost[i][k])
            }
        }
    }

    cost.forEachIndexed { i, i_v ->
        i_v.forEachIndexed { j, j_v ->
            if (j_v == 10000001) cost[i][j] = 0
        }
        println(i_v.joinToString(" "))
    }
}