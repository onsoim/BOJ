import java.io.*
import java.util.*
import kotlin.math.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val time = Array(N, { arrayListOf<Int>() })

    repeat(N) { i -> time[i] += readLine()!!.split(" ").map { it.toInt() } }

    repeat(N) { i ->
        repeat(N) { j ->
            repeat(N) { k ->
                if (j != k) {
                    time[j][k] = min(time[j][k], time[j][i] + time[i][k])
                }
            }
        }
    }

    repeat(M) {
        val (A, B, C) = readLine()!!.split(" ").map { it.toInt() }

        if (time[A - 1][B - 1] > C) println("Stay here")
        else println("Enjoy other party")
    }
}