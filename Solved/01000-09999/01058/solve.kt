import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    val list = Array(N) { Array(N) { 0 } }

    repeat(N) { i ->
        readLine().forEachIndexed { j, v ->
            if (v == 'Y') list[i][j] = 1
        }
    }

    // layover
    repeat(N) { i ->
        // from
        repeat(N) { j ->
            // to
            repeat(N) { k ->
                if (j != k && list[j][i] == 1 && list[i][k] == 1 && list[j][k] == 0) { list[j][k] = 2 }
            }
        }
    }

    var max = 0
    list.forEach { line ->
        val tmp = line.count { it > 0 }
        if (tmp > max) max = tmp
    }
    println(max)
}