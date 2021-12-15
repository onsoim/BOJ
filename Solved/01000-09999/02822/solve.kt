import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val score = arrayListOf<Pair<Int, Int>>()
    var sum = 0
    var sub = arrayListOf<Int>()

    for (i in 0..7) { score.add(Pair(readLine()!!.toInt(), i + 1)) }
    score.sortByDescending { it.first }

    for (i in 0..4) {
        sum += score[i].first
        sub += score[i].second
    }

    println(sum)
    println(sub.sorted().joinToString(" "))
}