import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var N = readLine()!!.toInt()
    var sum = 0

    while (N-- > 0) {
        val tmp = readLine()!!.split(" ").map { it.toInt() }
        sum += tmp[0] * tmp[1]
    }

    println(sum)
}