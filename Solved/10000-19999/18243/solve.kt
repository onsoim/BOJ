import java.io.*
import java.util.*
import kotlin.math.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    val friends = Array(N) { Array(N) { 101 } }

    repeat(N) { i -> friends[i][i] = 0 }
    repeat(K) {
        val (A, B) = readLine().split(" ").map { it.toInt() - 1 }
        friends[A][B] = 1.also { friends[B][A] = 1 }
    }

    // layover
    repeat(N) { i ->
        // from
        repeat(N) { j ->
            // to
            repeat(N) { k ->
                if (j != k) {
                    friends[j][k] = min(friends[j][k], friends[j][i] + friends[i][k])
                }
            }
        }
    }

    var max = 0
    friends.forEach { max = max(max, it.maxOrNull()!!) }
    println( (if (max > 6) "Big" else "Small") + " World!")
}