import java.io.*
import java.util.*

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = get()[0]
    val card = get().toTypedArray()

    repeat(N) { i ->
        if (card[i] == 0) {
            val color = Array(3, { true })

            if (i > 0) color[card[i - 1] - 1] = false
            if (i < N - 1 && card[i + 1] != 0) color[card[i + 1] - 1] = false

            var flag = true
            repeat(3) {
                if (color[it] && card[i] == 0) {
                    card[i] = it + 1
                    flag = false
                }
            }

            if (flag) {
                println(-1)
                return
            }
        }
        else if (i < N - 1 && card[i] == card[i + 1]) {
            println(-1)
            return
        }
    }
    println(card.joinToString(" "))
}